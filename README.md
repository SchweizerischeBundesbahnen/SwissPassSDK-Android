SwissPassClient SDK for Android
===============================

Copyright &copy; Schweizerische Bundesbahnen SBB, 2016-2024.

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

Android min API Level 23.

## Further information

All error messages and their descriptions are in RequestListener.java

## Usage

* Add the Maven Repo in the root build.gradle
```groovy
repositories {
    ${otherDependencies}
    maven {
        url "https://sbb-artefact-repo-prod.s3.eu-central-1.amazonaws.com/releases"
    }
}
```

* Add the dependency in the app build.gradle (for Login and Mobile)
```groovy
implementation 'ch.sbb.sid.android.lib:swisspass-client:${latestSwissPassRelease}'
```

* Add the dependency in the app build.gradle (for Login)
```groovy
implementation 'ch.sbb.sid.android.lib:swisspass-login:${latestSwissPassRelease}'
```

* initialize the components
```java
// lifecycle must be a LifecycleOwner, ViewModelStoreOwner (e.g. Activity or Application)
final ClientFactory clientFactory = new ClientFactory<>(lifecycle);
clientFactory.initializeActivityResult(lifecycle);
// clientId, provider and redirectAppUrl are client specific
final Settings settings = new Settings(clientId, provider, redirectAppUrl, Environment.PRODUCTION);
final SwissPassLoginClient loginClient = clientFactory.createLoginClient(settings);
// only with dependency to Mobile
final SwissPassMobileClient mobileClient = clientFactory.createMobileClient(loginClient);
```

* using the clients in the app
```java
final SwissPassLoginClient loginClient = SwissPassLoginClient.getInstance();
// only with dependency to Mobile
final SwissPassMobileClient mobileClient = SwissPassMobileClient.getInstance();
```

* register the OAuthActivity in the AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application>
        ...
        <activity
            android:name="ch.sbb.spc.OAuthActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
        
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />
        
                <data
                    android:host="${host}"
                    android:scheme="${scheme}" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```
