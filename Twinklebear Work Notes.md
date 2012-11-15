## Twinklebear Work Notes
Just a file to track my notes related to working on the WhatAPI since there isn't much of a point
in opening issues on the main repo that only I really need to keep track of hah.

### Deprecation work
Within MySoup some deprecated functions/classes are used, namely HTTP.UTF-8 and ThreadSafeClientConnManager
I'll be replacing these with the appropriate functionality (when i found out what that is..)

Update: ThreadSafeClientConnManager has to stay for now, using the recommended alternative, PoolingClientConnectionManager
works when running standalone, but on Android it crashes.

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
Torrent Search returning null
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

### Questions:
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