# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontwarn com.busra.selfcareapp.app.SelfCareAppKt
-dontwarn com.busra.selfcareapp.bottombar.BottomBarScreen
-dontwarn com.busra.selfcareapp.data.datastore.UserSettingsManager
-dontwarn com.busra.selfcareapp.data.roomdb.HabitDbModel
-dontwarn com.busra.selfcareapp.data.roomdb.HabitDao_Impl
-dontwarn com.busra.selfcareapp.data.roomdb.HabitDao
-dontwarn com.busra.selfcareapp.navigate.Screen
-dontwarn com.busra.selfcareapp.data.LoginUIEvent
-dontwarn com.busra.selfcareapp.data.SignUpUIEvent
