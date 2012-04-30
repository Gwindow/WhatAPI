WhatAPI
=======

This is a Java API for What.CD that provides a wrapper around the AJAX API of Gazelle. Please don't make more than 1 request to the site per second and don't do anything malicious or there will be consequences.  

If you have any questions on the java or ajax api please contact Gwindow in #what.cd-code.



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

## Index, basic info such as passkey, authkey, and U/D/R
ajax.php?action=index

User Profile
ajax.php?action=user&id=<User ID>&auth=<Authkey>

Inbox and Conversation
ajax.php?action=inbox&auth=<Authkey>
ajax.php?action=inbox&type=viewconv&id=<Message Id>&auth=<Authkey>

Top 10
ajax.php?action=top10&type=<Type>&limit=<Limit>&auth=<Authkey>
Type = torrents, tags, users.
Limit = 10,25,100; if no limit is specified defaults to 25.

User Search
ajax.php?action=usersearch&search=<Search Term>&auth=<Authkey>

Requests Search
ajax.php?action=requests&search=<Search Term>&auth=<AuthKey>
ajax.php?action=requests&search=<Search Term>&tag=<Tags>&auth=<AuthKey>
If no search term then latest requests will be listed.

Torrent Search
ajax.php?action=browse&searchstr=<Search Term>&auth=<AuthKey>
ajax.php?action=browse&searchstr=<Search Term>&taglist=<Tags>&tags_type=1&auth=<AuthKey>

Searches also take all the advanced search parameters but there are too many to include, check Gazelle.  

Bookmarks
ajax.php?action=bookmarks&auth=<AuthKey>

Subscriptions
ajax.php?action=subscriptions&auth=<Authkey>

Forums
ajax.php?action=forum&type=main&auth=<Authkey>
ajax.php?action=forum&type=viewforum&forumid=<Forum Id>&auth=<Authkey>
ajax.php?action=forum&type=viewthread&threadid=<Thread Id>&page=<Page>&auth=<Authkey>
ajax.php?action=forum&type=viewthread&threadid=<Thread Id>&postid=<Post Id>&auth=<Authkey>

Artist
ajax.php?action=artist&id=<Artist Id>&auth=<Authkey>

Torrent Group
ajax.php?action=torrentgroup&id=<Torrent Group Id>&auth=<Authkey>

Request
ajax.php?action=request&id=<Request Id>&auth=<Authkey>

Notifications
ajax.php?action=notifications&page=<Page>&auth=<Authkey>

Rippy
ajax.php?action=rippy
