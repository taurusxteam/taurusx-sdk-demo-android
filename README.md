# TaurusX SDK Android Demo

This is a comprehensive sample project demonstrating how to integrate TaurusX Advertising SDK on Android platform with various ad types and complete implementation examples.

## 📱 Project Overview

This project demonstrates how to integrate TaurusX Advertising SDK in Android applications, including complete implementations of the following ad types:

- **Banner Ads** - 320x50 and 300x250 (MREC) sizes
- **Interstitial Ads** - Full-screen display advertisements
- **Rewarded Video Ads** - Users watch complete videos to earn rewards
- **Native Ads** - Custom-styled native advertisements
- **App Open Ads** - Displayed when the application starts
- **Instream Video Ads** - Video ads integrated into content streams

## 🚀 Quick Start

### Requirements

- Android Studio 4.0+
- Android SDK API 19+ (minSdkVersion)
- Android SDK API 34+ (targetSdkVersion)
- Java 17
- Gradle 7.0+ (for newer projects)

### Installation Steps


1. **Add Repository**
   
   For Gradle versions below 7.0, add to `project-level build.gradle`:
   ```gradle
   allprojects {
       repositories {
           maven { url "https://bitbucket.org/sdkcenter/sdkcenter/raw/release" }
       }
   }
   ```
   
   For Gradle 7.0+, add to `settings.gradle`:
   ```gradle
   dependencyResolutionManagement {
       repositories {
           maven {
               url "https://bitbucket.org/sdkcenter/sdkcenter/raw/release"
           }
       }
   }
   ```

2. **Add SDK Dependency**
   
   In your `app/build.gradle`:
   ```gradle
   implementation "com.taurusx.tax:ads:1.7.2"
   ```

3. **Configure App ID and Ad Unit IDs**
   
   Open `app/src/main/java/com/taurusx/demo/Constants.java` and replace with your own IDs:
   ```java
   public final static String APPID = "YOUR_APP_ID";
   public final static String BANNERID = "YOUR_BANNER_AD_UNIT_ID";
   public final static String MRECID = "YOUR_MREC_AD_UNIT_ID";
   public final static String NATIVEID = "YOUR_NATIVE_AD_UNIT_ID";
   public final static String INTERSTITIALID = "YOUR_INTERSTITIAL_AD_UNIT_ID";
   public final static String REWARDID = "YOUR_REWARDED_AD_UNIT_ID";
   public final static String SPLASHID = "YOUR_APP_OPEN_AD_UNIT_ID";
   ```

4. **Build and Run**
   ```bash
   ./gradlew assembleDebug
   ```


## 📁 Project Structure

```
app/src/main/java/com/taurusx/demo/
├── MainActivity.java          # Main interface with navigation
├── Constants.java             # Configuration constants (App ID, Ad Unit IDs)
├── BannerActivity.java        # Banner ad implementation
├── InterstialActivity.java    # Interstitial ad implementation
├── RewardAdActivity.java      # Rewarded video ad implementation
├── NativeActivity.java        # Native ad implementation
├── SplashActivity.java        # App open ad implementation
└── App.java                   # Application class
```


## 📚 Documentation and Resources

- **[TaurusX SDK Official Documentation](https://publisher.taurusx.com/knowledge/zh/sdk/taurusx.html)** - Complete SDK integration guide

## 🤝 Technical Support

For technical support and questions:
- Visit the [TaurusX Publisher Platform](https://publisher.taurusx.com/)
- Contact TaurusX technical support team
- Check the official documentation for detailed integration guides

---

## ⚠️ Important Notes

Before using in production environment, please ensure:

1. **Replace with your own App ID and Ad Unit IDs** from the TaurusX publisher platform
2. **Update the application package name** in `AndroidManifest.xml` and `build.gradle` to match your app's package name