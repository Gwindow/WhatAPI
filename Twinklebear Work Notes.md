# Twinklebear Work Notes
Just a file to track my notes related to working on the WhatAPI since there isn't much of a point
in opening issues on the main repo that only I really need to keep track of hah.

## Deprecation work
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

## Code comments
It seems like the comments are auto-generated perhaps? I'd like to add some more descriptive comments,
if only to just force myself to read through the all the code. Seems like there's a lot of TODO: description,
so I will DO

## Shortening of some simple Boolean returning functions (getStatus and such)
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

## Function name shortening
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

## Removal of redundant local variables
In some areas a value is returned like so:
```Java
Notifications n = (Notifications) MySon.toObject(url, Notifications.class);
return n;
```
the local variable n isn't needed, so I've reduced the statement too
```Java
return (Notifications) MySon.toObject(url, Notifications.class);
```

## Bugs
#### Wrong data for some fields in the Request
it seems that the fields for the Requests returned in the Request search have some mixed up fields. Specifically release type:

For a request search with search tag Midori, viewing the request for Midori Takada - Through the Looking Glass [1983]
```Json
"releaseType":"RCA"
```
however, RCA is the record label. The desired release type as shown on the request page is "Album"

When viewing the request page itself, I'm given "0". Is this some enum corresponding to the types? If so
what number means what? I should write up some more documentation on the wiki, especially if those other folks
want to make an iOS app using the API.

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

## Feature Additions
#### Enable Notification toggling for Artists
Trying to do this results in an error in the API as a result of how the site handles notification toggleing via a circular redirect.
This is currently interpreted as an error but in fact it means the notification status change was successful. I'm undecided quite what to do now.
Should I catch CircularRedirectException, check if the url has "notify" in it and if so, say it went ok?

I've restructured the pressLink function to allow for enabling/disabling notifications. To do this I've added a catch block to
check for the specific error thrown by receiving the circular redirect resulting from setting notifications and in for additional checking
it confirms that "notify" is in the url to make sure this error is actually the expected behavior and we still print the error if it
turns out this is actually an error, not the notify behavior.

In addition I've modified the function to perform clean up the HttpEntity in a finally block, with some null checking for safety, this way
we still clean up if needed even when hitting an exception.

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

#### Improving the public side of the library
It seems like a lot of the classes are defined the way they are because it's how Gson requires them to be in order for it
to properly deserialize the API Json response. As such we're using the highest-level of the response so to speak
as our main class for requesting/interacting with the site API, and using getters to get the subclasses returned by the
response (Response and status and so on). I'm curious if it would be possible to create a better wrapper class of
sorts to clean up how we interact with these Gson-styled classes from the public side of the library.

Just a thought. As it is now, I'm still trying to get familiar with the code-base so after I know more perhaps I can
come up with something more concrete and test it out.

Perhaps a good option would be to ditch Gson and work with JSON directly? It'd be a bit of a pain,
but we'd have far more freedom in how we design our classes instead of having to match the API response
JSON formatting.

I think Gson really has got to go. It seems that a lot of the poor design/layout of the library is a direct
result of having to model our classes to exactly match the JSON response and since we have no control over the
response we're forced to write individual classes in cases where re-use/inheritance would be a cleaner choice
and so on. I'll make my case to Gwindow as to the reasons for ditching Gson to improve the API library.

In forum.section.Section the id and page fields are static. Why? We limit ourselves to only being able to have
one possible forum Section being viewed at once. Same for the static fields in forum.thread.Thread.

Instead of requiring the user to do a seperate check of hasNextPage/hasPreviousPage before trying to navigate, we should
just do the check ourselves in the fromNextPage/fromPreviousPage function and if there is no next/previous page, just
do nothing.

All the unnecessary "this" I added in the getters should be removed, if only for consistency heh.

#### Enable/Disable Notifications from a Bookmarked Artist response
Note that this will require two additional site interactions. The bookmarked artist response gives us the name and ID
from this we must get the artist, then do pressLink on enable/disable notifications.

#### View Request/Collage bookmarks
Is the site API set up to handle this request? I'll have to see. If it is I'll toss in the feature, if not I'll discuss
it with Gwindow. Is viewing collages supported in the API library at the moment? Or on the site?

Related: Why do I not get the artist name when looking at a torrentgroup bookmark? It seems like a reasonable thing to
expect to be returned in the API response, but it isn't there.

#### Voting on Polls in the Forums
It looks like we need to send some sort of post request, but what information do we need to send and to where?

#### Viewing Top Users, Tags and Favorites
The code for handling Users and Tags isn't written. For Favorites it appears that the API response is yet to be
written as I get status: failure when trying what a guess at the url is

#### Removing Friends
The function is commented out in user.User and marked as todo complete, I'll do it.

## Questions:
What should be done about html characters? Namely things such as
```html
<b>, <br />
```
and so on.
I've decided to leave these in since we can make use of them to format the text being displayed in the
Android text view or in any other thing that's using the library.

For bookmarks.Torrent the field freeTorrent I can only assume relates to the freeleech status of the torrent. Is this correct?
For bookmarks.Torrent there is a field "hasFile" What does this mean?

For comments.Userinfo what is the field userTitle for?

in forum.thread.Author a field permissionId was marked TODO: remove. I removed it. What was it? It doesn't seem to be in the API response.
in forum.thread.Author the field paranoia is commented out as causing a crash. Do we even care about this field? It seems kind of
irrelevant to viewing a forum post. It'd be nice to know the paranoia level when viewing a user page though, i'll see if that field is there
when I get to the user package.

in forum.thread.Poll what are maxVotes and featured?

in inbox.inbox.Message, what are the fields forwardedId and forwardedName for? Can you forward messages on what? If so, is that the user
information about the person who forwarded the message?

in notifications.Results what is the field groupCategoryId? what is logInDb?

in notifications.Results the function downloadFile is tagged as needing fixing. Can I just replace it with another implementation?
there seem to be quite a few copies of the download torrent function around, perhaps they should be rolled into a utility or base class.

What is the products package used for? Is it the barcode/upc searching? I'll ask and work on it later.

There seem to be multiple definitions of download file/download torrent found throughout the API. Can we not consolidate these?
They seem rather generic, taking only a url and a file path.

Within inbox.inbox.Inbox.hasNextPage and inbox.inbox.Inbox.hasPreviousPage there is nothing that can throw an exception, so why is it in try/catch?
I've removed the try catch, let's see what happens. I should ask Gwindow to confirm this removal is ok.

in requests.Response what are the fields catalogueNumber, logCue, bitRateList?
also in search.requests.Request, what is logCue.
I thought bit rate list would be a list of acceptable bitrates, but inspecting the response it appears to be a number. What is its meaning?
Same question for releaseType

In requests.Conductor is the field id corresponding to the conductor's artist id?

In requests package, Conductor, Artist, RemixedBy, DJ and With are identical. Why not have them inherit from a
base class defining their shared properties, or simply make them all the same class?

in search.crossreference.CrossReference perhaps the determineSearchString is the function we can improve
to improve our search results when searching via UPC/barcode scans?

The various search classes could do with a bit of a re-working, I'll look into this after I've finished my documentation + minor refactoring sweep

Why is the artist list returned to us in the Request search a 2d array, when it's just an array of artists? I'll have to ask Gwindow about this. Maybe
we can change it to a 1d array, 2d is an odd choice.

in search.torrents.Torrent what is the field editionId?

what is personal freeleech? Is that if you use a token on the torrent, it tags as personal freeleech til you download it?

in search.torrents.Artist what is the field aliasId?

in general: what is catalogueNumber/remasterCatalogueNumber?

in soup.MySoup what are the fields headerName, headerValue?
in soup.MySoup why do we have the function
```Java
private static HttpGet getHttpGet(String url) {
	return new HttpGet(url);
}
```
in soup.MySoup why do we need
```Java
public static ForumSections getForumSections() {
	return forumSections;
}
```
when loadForumSections does the same thing but makes sure the sections are loaded first? And if they are loaded, just returns them

do we use soup.MySoup.inputStreamToString or soup.MySoup.toPlainText? IDE seems to say no. Do we need them? Should we be using them?

in subscriptions.Subscriptions what is sortThreadsBySection supposed to do? So I can test it and make sure it does what's expected. I'm
guessing it orders the subscriptions by forum section to match the ordering on the site's forum section view?

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