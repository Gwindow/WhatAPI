## Twinklebear Work Notes
Just a file to track my notes related to working on the WhatAPI since there isn't much of a point
in opening issues on the main repo that only I really need to keep track of hah.

### Deprecation work
Within MySoup some deprecated functions/classes are used, namely HTTP.UTF-8 and ThreadSafeClientConnManager
I'll be replacing these with the appropriate functionality (when i found out what that is..)

Update: ThreadSafeClientConnManager has to stay for now, using the recommended alternative, PoolingClientConnectionManager
works when running standalone, but on Android it crashes with a missing class def error.

in MySoup.java
```Java
public static String scrape(String url) {
    url = SITE + url;
    httpGet = getHttpGet(url);
    response = null;
    try {
        response = httpClient.execute(httpGet);
        entity = response.getEntity();
        // String s = Jsoup.parse(entity.getContent(), "utf-8", "").text();
        //Using HTTP.USER_AGENT crashes, UnupportedCharsetException on desktop (not in app for some reason)
        String s = EntityUtils.toString(entity, HTTP.UTF_8);
        // EntityUtils.consume(entity);
        // InputStream s = entity.getContent();
        // System.err.println("encoding " + entity.getContentEncoding());
        return s;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
```
It only seems to throw UnsupportedCharsetException when running on desktop, but accepts UTF-8 on desktop and Android, so I've changed it to that.

I've also left the various HTTP.UTF-8 in as I couldn't seem to turn up any information on what they should be changed too.

HttpEntity.consumeContent is also still being used as it's replacement method, EntityUtils.consume doesn't exist on Android.

### Code comments
It seems like the comments are auto-generated perhaps? I'd like to add some more descriptive comments,
if only to just force myself to read through the all the code. Seems like there's a lot of TODO: description,
so I will DO

### Shortening of some simple Boolean returning functions (getStatus and such)
In many places a function like so exists:
```Java
public boolean getStatus() {
    return status.equalsIgnoreCase("success");
    if (status.equalsIgnoreCase("success"))
        return true;
    return false;
}
```
Where I have now changed them too
```Java
public boolean getStatus() {
    return status.equalsIgnoreCase("success");
}
```
In other areas where and if else statement was being used to simply decide whether to return true or false
I've changed the return statement to just return the result of evaluating the if condition, as is done here.

In the areas where it can throw, is this ok? I will test.

I'm also shrinking some conditional checks of the form
```Java
if (blah == true)

//To:

if (blah)
```

### Function name shortening
In many areas a function exists like so:
```Java
//Within class Thread
public static Thread threadFromIdandPage
```
I have shortened the function names to
```Java
public static Thread fromIdandPage
```

I've left the various crossReferenceByX, requestSearchFromX, torrentSearchFromX, userSearchFromX the same.
Although maybe they should be shortened.

### Removal of redundant local variables
In some areas a value is returned like so:
```Java
Notifications n = (Notifications) MySon.toObject(url, Notifications.class);
return n;
```
the local variable n isn't needed, so I've reduced the statement too
```Java
return (Notifications) MySon.toObject(url, Notifications.class);
```

### Bugs
#### Torrent Search returning null
I seem to be getting a null torrentSearch in the Async task in TorrentSearchActivity, looking into why. Have
tracked the issue down through my WhatAPI Test program. When trying to parse the search result to object from json
we get Expecting number, got: STRING. Now to find out which one is wrong. Found the issue:
in the search response results, the value of groupTime is supposed to be a number, but I seem to be getting a string back
the API says it should return a number on the wiki page and the app running on my phone doesn't seem to crash either.

The scraped JSON response showing the issue:
```json
Scraped: {"status":"success","response":{"currentPage":1,"pages":31,"results":[
{"groupId":72058492,"groupName":"All Punk Rods: A Gearhead Magazine Compilation",
"artist":"Various Artists","tags":["garage","punk","surf"],"bookmarked":false,
"vanityHouse":false,"groupYear":1998,"releaseType":"Compilation",
"groupTime":"1352875841","maxSize":248945626,
```
Where you can see groupTime is a String now. But it should be a number. Why has this changed? Why doesn't the released
app crash with what I can only assume is the same response? A note for this also exists in the Android app repo as that's
where I encountered the issue.

#### Intermittent null artist name and/or image file
This is a tricky one on the server side where sometimes we'll be given a null for artist name or image file or both
for now I'll band-aid it by converting nulls to "failed to load" strings in the deserializer.

### Enable Notification toggling for Artists
Trying to do this results in an error in the API as a result of how the site handles notification toggleing via a circular redirect.
This is currently interpreted as an error but in fact it means the notification status change was successful. I'm undecided quite what to do now.
Should I catch CircularRedirectException, check if the url has "notify" in it and if so, say it went ok?

I've restructured the pressLink function to allow for enabling/disabling notifications. To do this I've added a catch block to
check for the specific error thrown by receiving the circular redirect resulting from setting notifications and in for additional checking
it confirms that "notify" is in the url to make sure this error is actually the expected behavior and we still print the error if it
turns out this is actually an error, not the notify behavior.

In addition I've modified the function to perform clean up the HttpEntity in a finally block, with some null checking for safety, this way
we still clean up if needed even when hitting an exception.

### Feature Additions
#### Adding ability to view Better.php for transcoding torrents
Unfortunately the way this is implemented at the moment is pretty hideous. Separate class exists
for viewing Transcoded better, BetterTranscode and it uses TranscodingResponse as its Response field.
This is mainly due to how Google gson handles serialization and the differences in the API response.

For single seeded flac response we get an array of Artists (the class) containing some information.
For transcoding we're given a single artist name as a string. Google gson doesn't like this heh.

So for the time being it's pretty nasty. I've got to look more into how gson handles inheritance and such and
maybe I can clean up this, along with the rest of the API. But it seems like we're kind of shoved into this
style by how gson functions. Maybe we can do better though.

In addition when trying to view better API response for: Snatch, Uploading, Tags, Folder names, File names,
Various Artists and 1982 Cleanup I either got status: failure or no response at all. I should ask Gwindow if it
would be possible to have these responses added.

### Questions:
What should be done about html characters? Namely things such as <b>, <br /> and so on.

Within inbox.inbox.Inbox.hasNextPage and inbox.inbox.Inbox.hasPreviousPage there is nothing that can throw an exception, so why is it in try/catch?
I've removed the try catch, let's see what happens. I should ask Gwindow to confirm this removal is ok.

In function in notifications.Results:
```Java
public void downloadFile(String url, String path) throws IOException {
    // todo fix this
    String name = "Unknown " + "(" + getMediaFormatEncoding() + ")";
    URL u;
    u = new URL(getDownloadLink());
    ReadableByteChannel rbc = Channels.newChannel(u.openStream());
    FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
    fos.getChannel().transferFrom(rbc, 0, 1 << 24);
    System.out.println("Downloaded " + name + " to " + path);
}
```
What's broken? Some testing would probably reveal it, but if I'll ask first to save some trouble haha.

Within soup.MySoup.postMethod it says to investigate. What's being investigated?

Within subscriptions.Subscriptions.sortThreadsBySection says not to use as it hasn't been tested. How should it be tested?

In torrents.artist.Artist.getDownloadLinksList() it's commented out and says TODO fix. What is to be fixed?

In user.User the function removeFromFriends is commented out and tagged TODO complete. What is left to be finished?

In whatstatus.WhatStatus the function getTweets is commented out. What should be done with this function?

## Resolved Bugs
#### Japanese/Non-English characters
##### Resolved:
This issue was resolved by adding the apache commons lang3 library to the WhatAPI and using
StringEscapeUtils.unescapeHtml4 in MyStringDeserializer in the API. This bug resolution note will also
be added to the api.

#### Issue:
Seems to not display them correctly instead showing gibberish symbols. Perhaps we aren't drawing
the text with the right encoding? Or reading it with the wrong encoding? This happens on my phone too
so I'm sure I didn't break anything with this issue.

I made some requests to artists with Japanese characters and have found the issue. The response we receive
contains bad characters for the artist name and album names. Basically anywhere that the Kanji characters appear,
I think it's safe to assume this issue would also come up for other special characters but will have to find
an artist with the characters to test on. For now see response for artist id 781409 name 神聖かまってちゃん

where I've edited it to show the relevant areas.
```json
{"status":"success","response":{"id":781409,"name":null,"notificationsEnabled":false,
"hasBookmarked":false,"image":null
```

it does also have an image, so why do we get null here? Note the name being null.
For the torrent groups: album titles should be 8月32日へ for first album and つまんね for second. Instead we get

```json
First:
"torrentgroup":[{"groupId":72287531,"groupName":"8&#26376;32&#26085;&#12408;","groupYear":2011,

Second:
{"groupId":72289938,"groupName":"&#12388;&#12414;&#12435;&#12397;","groupYear":2010,
```

Where now we get garbage for the group names. I tested this in my browser so I think this is a serverside issue?
I'll have to ask Gwindow.

The plot thickens: When I google
```txt
8&#26376;32&#26085;&#12408;
```
it brings up results for 8月32日へ. This is clearly an encoding issue, but what is the encoding being used?
It also seems if I type it in the text here github interprets it correctly.

Have found the cause. The encoding that is being sent in the API response for these characters is HTML Entity (decimal)
but the encoding Java expects is Unicode. We should get something like
```Java
"\u795E"
```
From the API response to receive a unicode character. That or we'll need to do some sort of conversion. I think a tweak
in the API response is probably best though, as this may be an issue for other people using the API too. Although they should
probably be notified of the change if it does change.