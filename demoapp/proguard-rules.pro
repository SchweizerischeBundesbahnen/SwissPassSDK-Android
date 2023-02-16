-keepclassmembers enum ch.sbb.spc.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class ch.sbb.spc.Token { *; }
-keep class ch.sbb.spc.UserInfoGender { *; }
-keep class ch.sbb.spc.SwissPassMobileSecurityElement { *; }
-keep class ch.sbb.spc.SwissPassMobileData { *; }
-keep class ch.sbb.spc.SwissPassMobileImage { *; }
-keep class ch.sbb.spc.UserInfo { *; }
-keep class ch.sbb.spc.SwissPassMobileClient { *; }
-keep class ch.sbb.spc.SwissPassMobileDataCard { *; }
-keep class ch.sbb.spc.DiscoveryRepository$DiscoveryData { *; }
-keep class ch.sbb.spc.Settings { *; }
-keep class ch.sbb.spc.SwissPassMobileUpdater { *; }
-keep class ch.sbb.spc.SwissPassMobileSettings { *; }
-keep class ch.sbb.spc.SwissPassLoginClient { *; }

-keepclassmembers,allowshrinking,allowobfuscation class  android.support.** {
    !static final <fields>;
}

#####################################################################
## Based on https://github.com/krschultz/android-proguard-snippets ##
#####################################################################


# Retrofit 2.X
## https://square.github.io/retrofit/ ##

-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-ignorewarnings

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# Rendescript
-keepclasseswithmembernames class * {
   native <methods>;
}

-keep class android.support.v8.renderscript.** { *; }

-keepclassmembers class * extends androidx.work.Worker {
    public <init>(android.content.Context,androidx.work.WorkerParameters);
}

# Okio
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**

# OkHttp
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Logback for Android
#
# Tested on the following *.gradle dependencies
#
#    compile 'org.slf4j:slf4j-api:1.7.7'
#    compile 'com.github.tony19:logback-android-core:1.1.1-3'
#    compile 'com.github.tony19:logback-android-classic:1.1.1-3'
#

-keep class ch.qos.** { *; }
-keep class org.slf4j.** { *; }
-keepattributes *Annotation*
-dontwarn ch.qos.logback.core.net.*

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

##---------------End: proguard configuration for Gson  ----------