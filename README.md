SwissPassClient SDK for Android
===============================

Copyright &copy; Schweizerische Bundesbahnen SBB, 2016-2019.$

## Overview

The SwissPassClient SDK provides access to the SwissPass Login and SwissPassMobile.

### SwissPass Login

The authentication of a user with the SwissPass login is based on the protocol OAuth 2.0 and the so-called Authorization Code Grant. This was implemented for use with native apps. The following points should be noted:
* If an Access Token issued by the SwissPass Login is used to access further services resp. Data used, then this must be given to the corresponding requests as bearer tokens. See RFC 6750 at https://tools.ietf.org/html/rfc6750. In this case the app has to implement the error handling according to OAuth 2.0.
* OAuth bearer tokens can be validated via token introspection on SwissPass IAM, see RFC 7662 at https://tools.ietf.org/html/rfc7662.
* If an access token issued by the SwissPass login is renewed via SDK, then in some cases this operation may fail. In this case, either a RequestListener.SPC_ERROR_ACCESS_DENIED or a RequestListener.SPC_ERROR_INVALID_TOKEN is returned by the SDK and the app must re-login for the user.

### SwissPassMobile

The SwissPassMobile is a virtualized SwissPass card. This can be displayed with the SDK by the SwissPassMobileFragment. Please note the following points:
The SwissPassMobile can be activated by the user in up to 10 apps simultaneously. If there are more than 10 activations, already existing activations will be deleted automatically.
In the event of a logout, the existing activation on the SwissPass will not be deactivated. The following login checks whether the same user logs in again, if this is not the case the existing SwissPassMobile will be deactivated.

## Requirements

Android min API Level 21.

## further information

All error messages and their descriptions are in RequestListener.java

### documentation

The project page is available at Confluence https://confluence-ext.sbb.ch/display/NOVAUG/SwissPass+Client+integration

### Demo App

The demo app can be found on Code-Ext https://code-ext.sbb.ch/projects/SID/repos/swisspassclientsdk/browse/android/swisspassclientsdk-demo