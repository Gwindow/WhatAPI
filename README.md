WhatAPI
=======

This is a Java API for What.CD that provides a wrapper around the AJAX API of Gazelle. Please don't make more than 1 request to the site per second and don't do anything malicious or there will be consequences.  

If you have any questions contact Gwindow in #what.cd-code or through Github. 

Example
-------
    //set the site and login
    MySoup.setSite("ssl.what.cd");
    MySoup.login("login.php", username, password);
    //create an object
    User user = User.userFromId(id);
    //you now have an object to work with, awesome right?
    System.out.println(user); //this will print all the values that the object contains
    //Most classes also have extra methods to do special stuff, like sending messages or downloading files
    user.sendMessage(subject, body);
And that is a basic example of how you can use the api.

Java documentation: http://gwindow.github.com/WhatAPI/

List of JSON pages present on What.CD and Gazelle 
==================================================

### Index
ajax.php?action=index

The most important page, provides basic info such as passkey, authkey, and U/D/R

### User Profile
ajax.php?action=user&id=<_User ID_>&auth=<_Authkey_>

Inbox and Conversation
ajax.php?action=inbox&auth=<_Authkey_>

ajax.php?action=inbox&type=viewconv&id=<_Message Id_>&auth=<_Authkey_>

### Top 10
ajax.php?action=top10&type=<_Type_>&limit=<_Limit_>&auth=<_Authkey_>

Type = torrents, tags, users.

Limit = 10,25,100; if no limit is specified defaults to 25.

### User Search

ajax.php?action=usersearch&search=<_Search Term_>&auth=<_Authkey_>

### Requests Search
ajax.php?action=requests&search=<_Search Term_>&auth=<_AuthKey_>

ajax.php?action=requests&search=<_Search Term_>&tag=<_Tags_>&auth=<_AuthKey_>

If no search term then latest requests will be listed.

### Torrent Search
ajax.php?action=browse&searchstr=<_Search Term_>&auth=<_AuthKey_>

ajax.php?action=browse&searchstr=<_Search Term_>&taglist=<_Tags_>&tags_type=1&auth=<_AuthKey_>

Searches also take all the advanced search parameters but there are too many to include, check Gazelle.  

### Bookmarks
ajax.php?action=bookmarks&auth=<_AuthKey_>

### Subscriptions
ajax.php?action=subscriptions&auth=<_Authkey_>

### Forums
ajax.php?action=forum&type=main&auth=<_Authkey_>

ajax.php?action=forum&type=viewforum&forumid=<_Forum Id_>&auth=<_Authkey_>

ajax.php?action=forum&type=viewthread&threadid=<_Thread Id_>&page=<_Page_>&auth=<_Authkey_>

ajax.php?action=forum&type=viewthread&threadid=<_Thread Id_>&postid=<_Post Id_>&auth=<_Authkey_>

### Artist
ajax.php?action=artist&id=<_Artist Id_>&auth=<_Authkey_>

### Torrent Group
ajax.php?action=torrentgroup&id=<_Torrent Group Id_>&auth=<_Authkey_>

### Request
ajax.php?action=request&id=<_Request Id_>&auth=<_Authkey_>

### Notifications
ajax.php?action=notifications&page=<_Page_>&auth=<_Authkey_>

### Rippy
ajax.php?action=rippy
