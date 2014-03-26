WhatAPI
=======
This is a Java API for What.CD that provides a wrapper around the AJAX API of Gazelle. The [What.CD Android App](http://gwindow.github.com/WhatAndroid/) heavily utilizes this API. Please follow the site API rules and don't use this library or the API for malicious or bannable offenses or to make more 5 requests every 10 seconds.

Licensed under the 2-Clause BSD License, see LICENSE for full terms.

Dependencies
--------
- Apache Commons libraries: codec, io, lang3, logging
- Gson
- Jsoup

Example
-------
```Java
//set the site and login
MySoup.setSite("ssl.what.cd");
MySoup.login("login.php", username, password);
//create an object
User user = User.userFromId(id);
//you now have an object to work with, awesome right?
System.out.println(user); //this will print all the values that the object contains
//Most classes also have extra methods to do special stuff
//like sending messages or downloading files
user.sendMessage(subject, body);
```

Documentation
--
- [Javadoc](http://gwindow.github.com/WhatAPI/)
- [Gazelle API](https://github.com/WhatCD/Gazelle/wiki/JSON-API-Documentation)

Contributing
--
We're following the Git branching model outlined in [this post](http://nvie.com/posts/a-successful-git-branching-model/) for development. Contact us for write permissions or fork and submit a pull request when you've made your changes.

Questions? Contact [Gwindow](https://github.com/Gwindow/) or [Twinklebear](https://github.com/Twinklebear) through GitHub, the site, or in #whatAndroid or #code on the site irc.
