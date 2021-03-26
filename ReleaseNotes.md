Release Notes SwissPassClient SDK for Android
=============================================

## Version 3.0.11
_26.03.2021_
#### Bugfixes
* fix rare bug when decrypting an existing OIDC token
* fix rare crash when displaying the SPM barcode image
* updated backup rules

## Version 3.0.8-10
* Unreleased internal versions

## Version 3.0.7
_04.03.2021_
#### Bugfixes
* fix crash when versionName of browser is null

## Version 3.0.6
_02.03.2021_
#### Bugfixes
* refresh spm cardview when its attached

## Version 3.0.5
_23.02.2021_
#### Bugfixes
* Fix crash on finalizeRequest

## Version 3.0.4
_05.02.2021_
#### Bugfixes
* Change birthday label fontsize to 12 on SPM Cardview

## Version 3.0.3
_03.02.2021_
#### Bugfixes
* Fix multiple animators running simultaneously in the swisspass logo view
* Fix info message display in the SPM back view

## Version 3.0.2
_21.01.2021_
#### Bugfixes
* Delete old swisspass data if a new user is logged in
* Refresh SwissPass Mobile Card Fragment when SwissPass Mobile Card is activated
* Disable token force refresh on getUserInfo

## Version 3.0.1
_03.12.2020_
#### Bugfixes
* UserInfo Birthdate is now public
* Fixed a crash when SwissPassMobile fragment is closed while still loading

## Version 3.0.0
_27.10.2020_
#### Features
* Switch to OIDC
* Refactored all errorCodes. See RequestListener for details.
* Added SwisspassMobile Cardview.
* Added a flag to activate/deactivate automatic brightness adjustment for SwissPassMobile
* Javadoc is updated.
* ACTIVATION_LIMIT_REACHED AccountStatus removed
* Added SwisspassInvalid callback notification to SwisspassMobileFragments

## Version 2.3.6
_29.01.2020_
#### Bugfixes
* SwissPassMobile crash due to context lost.
* S-number url.

## Version 2.3.5
_23.01.2020_
#### Bugfixes
* SwissPassMobile crash after activation.

## Version 2.3.4
_15.01.2020_
#### Bugfixes
* SwissPassMobile crash.

## Version 2.3.3
_09.01.2020_
#### Bugfixes
* Improved UI

## Version 2.3.2
_07.01.2020_
#### Bugfixes
* Improved UI

## Version 2.3.1
_13.12.2019_
#### Bugfixes
* Dependencies in pom.xml.

## Version 2.3.0
_15.11.2019_
#### Features
* Min Android 5 API level.
* Android dark mode support.
* Support for Swisspass Plus Partner Services: QR und 2D Barcode.
* Dependencies and Proguard settings are updated.
* Documentation language is changed to english.
#### Bugfixes
* Null pointer exception in Swisspass Mobile update process.

## Version 2.2.1
_04.09.2019_
#### Bugfixes
* Versionsnummer bei Registrierung.

## Version 2.2.0
_28.05.2019_
#### Features
* Android Workmanager 1.0.
* AndroidX migration.
* Neue Token Format.
* Die Tor Customtab Browser ist blacklisted
* Swisspass Mobile Animation ist schneller und die Sterne sind grösser als vorher.
#### Bugfixes
* JsonIOException

## Version 2.1.11
_09.05.2019_
#### Bugfixes
* Swisspass Mobile null pointer Exception.

## Version 2.1.10
_03.04.2019_
#### Features
* Neue Fehlermeldung: SPC_ERROR_INVALID_MEDIUM_ID, die kommt wenn Medium Id Konflikt existiert.
#### Bugfixes
* Der MS Edge-Browser hat ein Problem mit Deeplinks und kann darum nicht als In-App Browser für
  das Login verwendet werden, er wird darum vom SDK für die Verwendung als Custom Tabs gesperrt.

## Version 2.1.9
_18.01.2019_
#### Features
* Weniger Info Level Logs.
* Fehler in Jpeg Bilddatei sind bevor decoding behebt.
#### Bugfixes
* Swisspass Mobile Daten werden nachdem Login gelöscht.
* Nullpointer Exception in SwissPass Mobile

## Version 2.1.8
_18.12.2018_
#### Bugfixes
* Keystore runtime Exception auf pre-Android M.

## Version 2.1.7
_12.12.2018_
#### Bugfixes
* Keystore runtime Exception auf pre-Android M.
* Swisspass Mobile Fragment öffnet sich schneller.

## Version 2.1.6
_27.11.2018_
#### Bugfixes
* Swisspass Mobile Fragment öffnet sich schneller.
* Speicherung des Access Token Prefix. 

## Version 2.1.5
_26.11.2018_
#### Bugfixes
* Falls in einer TokenResponse kein AccessToken verfügbar war, wurde eine NullPointerException geworfen.

## Version 2.1.4
_23.11.2018_
#### Features
* Code refactoring

## Version 2.1.3
_22.11.2018_
#### Bugfixes
* Alte SwissPass-Daten waren noch vorhanden beim Login eines anderen Users.

## Version 2.1.2
_12.11.2018_
#### Bugfixes
* Support Androidx Customtab.  

## Version 2.1.1
_11.11.2018_
#### Features
* Löschen 'Impl' postfix von Klassennamen. 
#### Bugfixes
* Updater muss public Klasse sein. 
* Proguard update. 

## Version 2.1.0
_09.11.2018_
#### Features
* Der `Client` wurde in einen `SwissPassLoginClient` und in einen `SwissPassMobileClient` aufgetrennt. Der `SwissPassMobileClient` benötigt zur Initialisierung einen `TokenProvider`, z.B. den `SwissPassLoginClient`.
* Android Target Version 28, min Android API Level 18.
* Android Workmanager anstatt Evernote Library. 

## Version 2.0.10
_15.08.2018_
#### Features
* Bluetooth-Permissions wurde entfernt, da sie für das Auslesen des Gerätenamens (Bluetooth-Name) nicht mehr nötig sind. Dieser wird nun über `android.provider.Settings.Secure` ausgelesen.
* Die Library Retrofit wurde als Dependency entfernt und mit der Library OkHttp (Version 3.11.0) ersetzt.
#### Bugfixes
* Anzeigesprache nach Initialisierung des SDKs nur noch Englisch.

## Version 2.0.9
_06.07.2018_
#### Bugfixes
* Token Metadata Update. 

## Version 2.0.8
_05.07.2018_
#### Bugfixes
* Token Metadata Update.

## Version 2.0.7
_29.06.2018_
#### Bugfixes
* NullPointerException.

## Version 2.0.6
_20.06.2018_
#### Features
* Validierung der Benutzerdaten beim Login-Vorgang wurde ausgebaut. Dadurch konnte die Performance von `requestLogin()` deutlich gesteigert werden.

## Version 2.0.5
_19.06.2018_
#### Features
* Die Funktion `openSwissPass()` kann neu auch das SwissPass-Kontaktformular öffnen.
#### Bugfixes
* SwissPass Mobile Konto Zustand `ACTIVATION_POSSIBLE`.

## Version 2.0.4
_14.06.2018_
#### Features
* 60 Sekunden Request Timeout.
* AGB Screen Refresh Button.
#### Bugfixes
* Android v4 Support Library Fragments.

## Version 2.0.3
_31.05.2018_
#### Features
* Die Funktion `openSwissPass()` kann neu auch die sogenannten SwissPass- und Abos-Infoseiten öffnen.
#### Bugfixes
* KeyStore Probleme auf diversen Geräte.
* SwissPass AGB Screen Back Button.

## Version 2.0.2
_15.05.2018_
#### Features
* Progressbar bei SwissPass Mobile Aktivierung.
#### Bugfixes
* SwissPass Mobile Deaktivierung.

## Version 2.0.1
_02.05.2018_
#### Features
* SwissPass Mobile.
* Die Warnung, dass das Gerät gerooted ist, wird nicht mehr angezeigt.

## Version 1.8.0
_13.02.2018_
#### Features
* Nur Info und Error Logging Levels.
#### Bugfixes
* KeyStore Exception Handling.

## Version 1.7.11
_01.12.2017_
#### Bugfixes
* Registration ist möglich nur wenn der User ausgeloggt ist.

## Version 1.7.10
_03.11.2017_
#### Bugfixes
* Speichern von Token.

## Version 1.7.9
_02.11.2017_
#### Bugfixes
* OAuth 2.0 konformes Verhalten beim Token Refresh.

## Version 1.7.8
_31.10.2017_
#### Bugfixes
* Verbessertes Exception Handling.

## Version 1.7.7
_13.10.2017_
#### Features
* Kompiliert mit target Android Oreo.
#### Bugfixes
* KeyStore initialisierung mit Arabische Sprache.
* Cancel Callback kommt nicht immer im Firefox wenn man Back Button drückt.

## Version 1.7.6
_22.09.2017_
#### Bugfixes
* UserInfo Feld `lastDataUpdate` verursacht manchmal Abstürze.

## Version 1.7.5
_21.09.2017_
#### Features
* `BrowserNotFoundException` wurde entfernt.

## Version 1.7.4
_20.09.2017_
#### Features
* Samsung Browser Version muss mindestens 5.xxx sein.
* Die Chrome Browser Version 53.xxx ist nicht mehr blacklisted.
* `BrowserNotFoundException` ist möglich bei der Initialisierung des OAuthClient, wenn das Gerät kein Browser hat.
* Neu Fehlermeldung `RequestListener.SPC_ERROR_NO_WEB_BROWSER_FOUND`, wenn das Gerät keinen Browser während einem Schnittstellen Aufruf hat.
* Die Übersetzungen sind aktualisiert worden.
* Die Proguard Settings sind aktualisiert worden.
#### Bugfixes
* Android 4.1 und 4.2 KeyStore Bugfix. In Debug Modus werden die Tokens auf 4.1 und 4.2 nicht gespeichtert.
* Doppelte Verwendung von Refresh-Token.

## Version 1.7.3
_04.09.2017_
#### Bugfixes
* `UserInfo` in `UserInfoResponse`.

## Version 1.7.2
_01.09.2017_
#### Features
* API Funktion Parameter Änderungen.
#### Bugfixes
* Android 4.1 und 4.2 KeyStore Bugfix.

## Version 1.7.1
_28.08.2017_
#### Bugfixes
* Abstürze auf alten Android Geräte, wenn default Browser geöffnet wird.

## Version 1.7.0
_25.08.2017_
#### Features
* Die Funktion `isLoggedIn()` wurde ersatzlos gestrichen.
* Neue Funktion `isKeyStoreAvailable()` prüft, ob das Gerät einen KeyStore hat und die Token gespeichert werden können.
* Man kann neu auch andere Browser verwenden, die Chrome Custom Tabs nicht unterstützen.
* Aktualisierte Übersetzungen.
#### Bugfixes
* Keystore-Zugriff.

## Version 1.6.10
_07.08.2017_
#### Bugfixes
* Bugfix "alle Geräte löschen"

## Version 1.6.9
_28.07.2017_
#### Bugfixes
* Verbesserte Exception handling.

## Version v1.6.8
_25.07.2017_
#### Bugfixes
* KeyStore verwendet `KeyPairGeneratorSpec`, wenn API Level 18-22 ist und `KeyGenParameterSpec`, wenn API Level höher als 22 ist.
* Die Funktion `requestLogout()` löscht auf dem Gerät gespeicherte Daten erst nach der erfolgreichen Logout-Bestätigung des SwissPass.
* Info Dialog ist immer in UI Thread gezeigt werden.

## Version 1.6.7
_07.07.2017_
#### Bugfixes
* Bei mehreren Apps mit verschiedenen Benutzern auf einem Handy werden beim Absprung auf die Seiten von swisspass.ch die Daten des korrekten Benutzers angezeigt.

## Version 1.6.6
_04.07.2017_
##### Bugfixes
* Registrierung via Login-Screen

## Version 1.6.5
_27.06.2017_
#### Bugfixes
* Nach dem Token revoke sollte Fehler `INVALID_TOKEN` für weitere API calls kommen.
* Abstürze bei re-auth mit Fingerprint.

## Version 1.6.4
_23.06.2017_
#### Bugfixes
* Unterschied zwischen abgebrochener Registration und erfolgreicher Registration.
* Nach einem Chrome Browser Update werden Requests weiter verarbeitet, falls der User die Aktualisierung durchgeführt hat, ansonsten werden sie abgebrochen.

## Version 1.6.3
_22.06.2017_
#### Bugfixes
* Systemsprache des Geräts wird an Swisspass.ch übermittelt.

## Version 1.6.2
_21.06.2017_
#### Bugfixes
* Access Token muss gültig sein, bevor re-auth HTTP Request gesendet wird.

## Version 1.6.1
_19.06.2017_
#### Bugfixes
* Custom Deserializer für Userinfo "gender" Parameter.

## Version 1.6.0
_16.06.2017_
#### Features
* Die Library unterstützt SBB interne Access Architektur.
* Die Übersetzungen sind aktualisiert worden.
* Die Library funktioniert mit Android developer option "dont keep activities".
* Die Library hat eine Custom-Dialog für den Fingerprint.
* Die Userinfo-Klasse ist erweitert worden mit den Feld `lastDataUpdate`.

## Version 1.5.0
_18.05.2017_
#### Features

* Die Chrome Browser Version muss mindestens 48.xxx sein. Version 53.xxx wird wegen einem Bug nicht akzeptiert.
* Man kann neu auch andere Browser verwenden, welche die Chrome Custom Tabs unterstützen.
* Neue Animation, wenn sich die Custom Tabs öffnen/schliessen.
* Die Library verwendet keinen Waitspinner mehr. Falls dieser nötig ist, muss dies von der Client App dargestellt werden. Mindestens für den Login-Request wird dieser empfohlen.
* Die Userinfo-Klasse wurde erweitert mit den Feldern `authenEmail` und `roles`.
* Nach dem Login wird Userinfo gecheckt. Hat der User seine Profile nicht komplett ausgefüllt, wird das SwissPass-Konto geöffnet, wo er seine Profile ausfüllen kann.
* Die Settings-Klasse hat einen neuen, vereinfachten Constructor.
* Die Verwendung von Logback logging ist optional. Die Client App kann die SID Library Info Logs mit Logback sehen.

#### Bugfixes
* Beim Logout wird das refresh token nicht geprüft.
* Fehler bei Token Refresh: Die App bekommt einen `invalid_Token`-Fehler. Die App muss in diesem Fall erneut ein Login ausführen.

## Version 1.4.0
_15.03.2017_
#### Features

* Support für die Webseite, auf welcher der Kunde seine SwissPass-Karte mit dem Konto verbinden kann.
* Support für Login Data management Webseite.
* Ein erfolgreicher Aufruf von `requestRegistration()` startet nicht mehr automatisch einen Login-Prozess.
* Verwendung von Chrome wird nicht unterstützt, nur Customtabs. Der Benutzer wird via SDK informiert und er kann dann einen Link in den Store direkt zum Download öffnen.
* Verbesserungen am API - die Klassennamen sind umbenennt.
* UserInfo-Klasse.

#### Bugfixes

* Request reauthentication ohne Bildschirmsperre - weisser Screen.
* Chrome Custom Tabs dürfen nicht automatisch geschlossen werden.

## Version 1.3.0
_21.02.2017_
#### Features

* Neue Funktion `requestRegistration()`.
* Fehler `SPC_ERROR_CANCELLED` in Callback, falls User das Login abbricht.
* Die SDK hat neue externe Abhängigkeiten.
* RequestToken führt nicht mehr automatisch ein Login durch.
* Nach Verwendung der Chrome Custom Tabs wird dieser geschlossen.
* Javadoc wurde angepasst.
* Die SDK zeigt einen Spinner, bevor Chrome Custom Tab geöffnet wird.
* Chrome als Standalone-Browser wird nicht mehr unterstützt.
* Die Warnung, dass das Gerät gerooted ist, wird immer im UI Thread aufgerufen
* Es gibt einen neuen SSO-Endpoint in der Settings-Klasse.

## Version 1.2.0
_30.01.2017_
#### Features

* Die Funktion `requestAuthentication()` verwendet nun zur Verifikation entweder die verfügbare Device Authentication oder dann eine Passwortüberprüfung auf SwissPass.
* Die SDK hat verbesserte Performance

#### Issues
* Der Rücksprung in die Login-Maske nach einer Registrierung eines neuen Benutzerkontos funktioniert für mobile Apps noch nicht

## Version 1.1.0
_10.01.2017_
#### Features

* Die Funktion `requestAuthentication()` verwendet nun zur Verifikation den Screenlock des Gerätes, falls keine Fingerprint vorhanden ist. Die Signatur der Methode wurde entsprechend angepasst.
* Wenn Chrome v48+ nicht installiert ist, wird der Browser Chrome als Fallback verwendet.

## Version 1.0.0
_02.12.2016_
#### Features

* 1FA basierend auf OAuth 2.0 (Authorization Code Grant) und dem SwissPass
* Logout zum Abmelden des Benutzers
* Eingeloggt-bleiben basierend auf dem Refresh-Token
* Abfrage von Benutzer-Attributen beim SwissPass UserInfo-Endpoint

#### Issues

* Das erneute Authentifizieren eines angemeldeten Benutzers via StepUpEndpointURL steht noch nicht zur Verfügung
* Das Token-Management via TokenManagementEndpointURL steht auf dem SwissPass noch nicht zur Verfügung
* Das Benutzerkonto-Management via AccountManagementEndpointURL steht auf dem SwissPass noch nicht zur Verfügung
* Der Rücksprung in die Login-Maske nach einer Registrierung eines neuen Benutzerkontos funktioniert für mobile Apps noch nicht
