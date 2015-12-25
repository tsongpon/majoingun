
<!DOCTYPE html>
<!-- saved from url=(0049)http://www.getmdl.io/templates/article/index.html -->
<html lang="en" class="mdl-js"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Material Design Lite</title>

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="http://www.getmdl.io/templates/article/images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="http://www.getmdl.io/templates/article/images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="http://www.getmdl.io/templates/article/images/favicon.png">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->

    <link href="/majoingun/fonts/css" rel="stylesheet" type="text/css">
    <link href="/majoingun/fonts/icon" rel="stylesheet">
    <link rel="stylesheet" href="/majoingun/css/material.min.css">
    <link rel="stylesheet" href="/majoingun/css/styles.css">

    <script src="/majoingun/js/material.min.js"></script>
</head>
<body>
    <div class="mdl-layout__container has-scrolling-header"><div class="demo-layout mdl-layout mdl-layout--fixed-header mdl-js-layout mdl-color--grey-100 is-upgraded" data-upgraded=",MaterialLayout">
        <header class="demo-header mdl-layout__header mdl-layout__header--scroll mdl-color--grey-100 mdl-color-text--grey-800">
            <div class="mdl-layout__header-row">
                <span class="mdl-layout-title"><img src="/majoingun/images/ABC-LOGO-WHITE-BG.png"></span>
                <div class="mdl-layout-spacer"></div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable is-upgraded" data-upgraded=",MaterialTextfield">
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="search" data-upgraded=",MaterialButton">
                        <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                        <input class="mdl-textfield__input" type="text" id="search">
                        <label class="mdl-textfield__label" for="search">Enter your query...</label>
                    </div>
                </div>
            </div>
        </header>
        <div class="demo-ribbon"></div>
            <main class="demo-main mdl-layout__content">
                <div class="demo-container mdl-grid">
                    <div class="mdl-cell mdl-cell--2-col mdl-cell--hide-tablet mdl-cell--hide-phone"></div>
                    <div class="demo-content mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800 mdl-cell mdl-cell--8-col">
                        <div class="demo-crumbs mdl-color-text--grey-500">
                            <h3>Majoingun</h3>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="Title" />
                                <label class="mdl-textfield__label" for="title">Title</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="fullname" />
                                <label class="mdl-textfield__label" for="fllname">Fullname</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="lastname" />
                                <label class="mdl-textfield__label" for="lastname">Lastname</label>
                            </div>
                            <div class="mdl-cell mdl-cell--12-col mdl-typography--text-left">
                                <h6>Gender</h6>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="male">
                                    <input class="mdl-radio__button" id="male" name="gender" type="radio" value="male">
                                    <span class="mdl-radio__label">Male</span>
                                </label>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="female">
                                    <input class="mdl-radio__button" id="female" name="gender" type="radio" value="female">
                                    <span class="mdl-radio__label">Female</span>
                                </label>
                            </div>

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="email" />
                                <label class="mdl-textfield__label" for="email">E-Mail</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="mobile" />
                                <label class="mdl-textfield__label" for="mobile">Mobile</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="university" />
                                <label class="mdl-textfield__label" for="university">University</label>
                            </div>
                            <div class="mdl-cell mdl-cell--12-col mdl-typography--text-left">
                                <h6>Interested fields</h6>
                                <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="tester">
                                    <input type="checkbox" id="tester" class="mdl-checkbox__input">
                                    <span class="mdl-checkbox__label">Tester</span>
                                </label>
                                <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="backend">
                                    <input type="checkbox" id="backend" class="mdl-checkbox__input">
                                    <span class="mdl-checkbox__label">Backend Developer</span>
                                </label>
                                <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="frontend">
                                    <input type="checkbox" id="frontend" class="mdl-checkbox__input">
                                    <span class="mdl-checkbox__label">Frontend Developer</span>
                                </label>
                                <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="other">
                                    <input type="checkbox" id="other" class="mdl-checkbox__input">
                                <span class="mdl-checkbox__label"> Other
                                    <input class="mdl-textfield__input_other" type="text" pattern="[A-Z,a-z]*" id="othertxt" />
                                    <label class="mdl-textfield__label" for="othertxt">Other</label>
                                </span>
                                </label>
                            </div>
                            <div class="mdl-cell mdl-cell--12-col mdl-typography--text-left">
                                <h6>Type</h6>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="intern">
                                    <input class="mdl-radio__button" id="intern" name="type" type="radio" value="intern">
                                    <span class="mdl-radio__label">Intern</span>
                                </label>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="permanent">
                                    <input class="mdl-radio__button" id="permanent" name="type" type="radio" value="permanent">
                                    <span class="mdl-radio__label">Permanent</span>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="demo-footer mdl-mini-footer">
                    <div class="mdl-mini-footer--left-section">
                        <ul class="mdl-mini-footer--link-list">
                            <li><a href="http://www.getmdl.io/templates/article/index.html#">Help</a></li>
                            <li><a href="http://www.getmdl.io/templates/article/index.html#">Privacy and Terms</a></li>
                            <li><a href="http://www.getmdl.io/templates/article/index.html#">User Agreement</a></li>
                        </ul>
                    </div>
                </footer>
            </main>
        </div>
    </div>
</body>
</html>