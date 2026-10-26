# Keep platform-instantiated Android components and model names stable for any future relay adapter.
-keep public class * extends android.app.Activity
-keep public class * extends androidx.fragment.app.Fragment
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}
