https://zakaria5729.github.io/android-dependency-list/  - website
https://github.com/zakaria5729/android-dependency-list  - github


List of all (almost) important dependencies and their resources for android development (Java and Kotlin)
URL: https://zakaria5729.github.io/android-dependency-list/

1.Architecture
Data Binding
Lifecycles
LiveData
Navigation
Room
ViewModel
WorkManager


2.Foundation
AppCompat
Android KTX
Multidex


3.UI
Animation & transitions
Fragment
Emoji
Palette


4.Behavior
Preference
Slices


5.Firebase
Firebase Core
Realtime Database
Cloud Firestore
Authentication
Cloud Storage
Cloud Messaging
Cloud Functions
Crashlytics
ML Kit


6.Library
Retrofit
Fast Android Networking
Gson
Moshi
Glide
Picasso
RxJava
RxKotlin
RxAndroid
Dagger
Lottie
ButterKnife
Mockito
Espresso





                             1.Architecture
(1)Data Binding
Data Binding Library Part of Android Jetpack. 
The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources
in your app using a declarative format rather than programmatically.

Java and Kotlin
android {
    
    dataBinding {
        enabled = true
    }
}



(2)Lifecycles
Most of the app components that are defined in the Android Framework have lifecycles attached to them. 
Lifecycles are managed by the operating system or the framework code running in your process.
They are core to how Android works and your application must respect them.


dependencies {
    def lifecycle_version = "2.0.0"

    implementation  "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
    kapt  "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
}


(3)LiveData
LiveData is part of the Lifecycle library which was designed to help you solve common Android Lifecycle challenges and to make your apps more maintainable and testable.
LiveData is a lifecycle-aware observable. LiveData makes it easy to keep what’s showing on screen in sync with the data.


dependencies {
    def lifecycle_version = "2.0.0"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"

    // alternatively - just LiveData
    implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"

    // optional - ReactiveStreams support for LiveData
    implementation "androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version"

    // optional - Test helpers for LiveData
    testImplementation "androidx.arch.core:core-testing:$lifecycle_version"
}









(4.)ViewModel
ViewModel Overview Part of Android Jetpack. The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
The ViewModel class allows data to survive configuration changes such as screen rotations.

dependencies {
    def lifecycle_version = "2.0.0"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"

    // alternatively - just ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
}






(5.)Navigation
Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. Android Jetpack’s Navigation component helps you implement navigation,
from simple button clicks to more complex patterns, such as app bars and the navigation drawer.

dependencies {
    def nav_version = "2.1.0-alpha02"

    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
}





(6).Paging
Paging library is a Part of Android Jetpack. The Paging Library helps you load and display small chunks of data at a time.

dependencies {
    def paging_version = "2.1.0"

    implementation "androidx.paging:paging-runtime-ktx:$paging_version"

    // alternatively - without Android dependencies for testing
    testImplementation "androidx.paging:paging-common-ktx:$paging_version"

    // optional - RxJava support
    implementation "androidx.paging:paging-rxjava2-ktx:$paging_version"
}





Room
Room Persistence Library Part of Android Jetpack. The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
The library helps you create a cache of your app’s data on a device that’s running your app.


dependencies {
    def room_version = "2.1.0-alpha06"

    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:$room_version"

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation "androidx.room:room-guava:$room_version"

    // Test helpers
    testImplementation "androidx.room:room-testing:$room_version"
}










WorkManager
WorkManager is an Android Jetpack library that runs deferrable, guaranteed background work when the work’s constraints are satisfied.
WorkManager is the current best practice for many types of background work.


dependencies {
    def work_version = "2.0.1"

    implementation "androidx.work:work-runtime-ktx:$work_version"

    // optional - Test helpers
    androidTestImplementation "androidx.work:work-testing:$work_version"
}










                                                           Behavior
Preference
Preference components and attributes Part of Android Jetpack.
This topic describes some of the most commonly-used Preference components and attributes used when building a settings screen.




dependencies {
    implementation 'androidx.preference:preference-ktx:1.0.0'
}






Slices

Slices display rich content and actions on components, appearing as part of search results in the Google search app.
They can display a variety of content types, such as text, images, and actions.



dependencies {
    implementation 'androidx.slice:slice-builders-ktx:1.0.0-alpha3'
    implementation 'androidx.annotation:annotation:1.0.0-alpha3'
}








                                           Foundation
AppCompat

AppCompat library Part of Android Jetpack. AppCompat is a set of support libraries which can be used to
make the apps developed with newer versions work with older versions. Note:The appcompat library has migrated into the AndroidX library, 
which is an Android Jetpack component.

Java and Kotlin

dependencies {
    implementation "androidx.appcompat:appcompat:1.0.2"
}






Android KTX

Android KTX is a set of Kotlin extensions that is part of the Android Jetpack family. 
Android KTX does not add any new features to the existing Android APIs.

Kotlin

dependencies {
    implementation "implementation 'androidx.core:core-ktx:1.0.1"
}



Multidex
Dex is short for Dalvik Executable, which is what Google’s virtual machine processor (Dalvik) uses to handle Android Applications. 
MultiDex integration in Android Studio allows Android Developers the ability to compile and execute a code-base with over 65,536 methods!


Note: Therefore, if your minSdkVersion is 21 or higher, you do not need the multidex support library.

dependencies {
    implementation "com.android.support:multidex:1.0.3"
}




                     UI

Emoji
Google emoji images are used on stock Android devices (such as Pixel phones), Gmail Web Interface, Google Hangouts, and ChromeOS.
Apps such as WhatsApp and Facebook use their own emoji images, while Signal and Telegram for Android use Apple emoji images.



dependencies {
    implementation "com.android.support:support-emoji:28.0.0"
}



Fragment

Android Fragments is a “reusable self contained portions of a user interface” in an Android Activity used for creating dynamic
and flexible user interface.Fragments has it’s own life cycle
but it always be embedded with an activity so that the fragments life cycle is directly affected by the host activity’s life cycle.




dependencies {
    implementation "androidx.fragment:fragment-ktx:1.1.0-alpha06"
}



Animation & transitions

Android’s Animation & transition framework allows you 
to animate all kinds of motion in your UI by simply providing the starting layout and the ending layout.

dependencies {
    implementation "androidx.dynamicanimation:dynamicanimation-ktx:1.0.0-alpha02" //dynamic animation
    implementation "androidx.transition:transition:1.1.0-beta01"
}






Palette

Palette is a new API for Android that allows you to extract and make use of colors in an image. It also has a support library in order
for older versions of Android to make use of Palette. All you need is an image bitmap and the Palette library, and you’re good to go.




dependencies {
    implementation 'com.android.support:palette-v7:28.0.0'
}




                                                                               Firebase
Firebase Core

Firebase is a mobile platform that helps you quickly develop high-quality apps,
grow your user base, and earn more money. Firebase is made up of complementary features that you can mix-and-match to fit your needs,
with Google Analytics for Firebase at the core.

Java and Kotlin



dependencies {
    implementation "com.google.firebase:firebase-core:16.0.8"
}





Realtime Database
The Firebase Realtime Database is a cloud-hosted database. When you build cross-platform apps with our iOS, 
Android, and JavaScript SDKs, all of your clients share one Realtime Database instance and automatically receive updates with the newest data.

Java and Kotlin
dependencies {
    implementation "com.google.firebase:firebase-database:16.1.0"
}




Cloud Firestore
Use our flexible, scalable NoSQL cloud database to store and sync data for client- and server-side development. Cloud Firestore is a flexible, scalable database for mobile, web, and server development from Firebase and Google Cloud Platform.

Java and Kotlin
dependencies {
    implementation "com.google.firebase:firebase-firestore:18.2.0"
}









Authentication
Firebase Authentication provides backend services, easy-to-use SDKs, and ready-made UI libraries 
to authenticate users to your app. It supports authentication using passwords, phone numbers, popular federated 
identity providers like Google, Facebook and Twitter, and more.

Java and Kotlin
dependencies {
    implementation "com.google.firebase:firebase-auth:16.2.1"
}






Cloud Storage
Firebase Cloud Storage is a powerful, simple, and cost-effective object storage service.
It includes Google security to file uploads and downloads for your Firebase apps. Cloud Storage allows us to store 
images, audio, video, or other user-generated content.

Java and Kotlin
dependencies {
    implementation "com.google.firebase:firebase-storage:16.1.0"
}










Cloud Messaging
Firebase Cloud Messaging (FCM) is a cross-platform messaging solution that lets you reliably deliver messages at no cost.
Using FCM, you can notify a client app that new email or other data is available to sync.

Java and Kotlin
dependencies {
    implementation "com.google.firebase:firebase-messaging:17.6.0"
}



Cloud Functions
Cloud Functions for Firebase lets you create functions that are triggered by Firebase products, such as changes to data in the Realtime Database, uploads to Cloud Storage, new user sign ups via Authentication, and conversion events in Analytics.

Java and Kotlin
dependencies {
    implementation "https://firebase.google.com/docs/functions/"
}





Crashlytics
Firebase Crashlytics is a lightweight, realtime crash reporter that helps you track, prioritise, and fix stability issues to improve your app quality.

Java and Kotlin
dependencies {
    implementation "com.crashlytics.sdk.android:crashlytics:2.9.9"
    implementation "com.google.firebase:firebase-crash:16.2.1" //Crash Reporting
}







ML Kit
Firebase ML Kit was introduced to us at Google I/O ‘18. It is a mobile SDK that enables Android and iOS app developers to have advanced machine learning capabilities into their apps with ease.

Java and Kotlin
dependencies {
    //Vision APIs
    implementation "com.google.firebase:firebase-ml-vision:19.0.3"

    //Image Labeling Model
    implementation "com.google.firebase:firebase-ml-vision-image-label-model:17.0.2"

    //Face Detection Model
    implementation "com.google.firebase:firebase-ml-vision-face-model:17.0.2"

    //Natural Language APIs
    implementation "com.google.firebase:firebase-ml-natural-language:18.2.0"

    //Language Identification Model
    implementation "com.google.firebase:firebase-ml-natural-language-language-id-model:18.0.3"

    //Smart Reply Model
    implementation "com.google.firebase:firebase-ml-natural-language-smart-reply-model:18.0.0"

    //Custom Model APIs
    implementation "com.google.firebase:firebase-ml-model-interpreter:18.0.0"
}


  
                                                               📗 Library
Retrofit
Retrofit is a REST Client for Android and Java by Square. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice. In Retrofit you configure which converter is used for the data serialization.

Java and Kotlin
dependencies {
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
}






Gson
Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.

Java and Kotlin
dependencies {
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
}




Moshi
Another excellent and super-easy library from Square. 
Moshi is an open source library, which helps you to parse JSON to model class (Java Objects) and vice versa.

Java and Kotlin
dependencies {
    implementation 'com.squareup.retrofit2:converter-moshi:2.5.0'
}






Glide
Glide is an Image Loader Library for Android developed by bumptech and is a library that is recommended by Google.
It has been used in many Google open source 
projects including Google I/O 2014 official application. It provides animated GIF support and handles image loading/caching.



dependencies {
    kapt "android.arch.lifecycle:compiler:1.0.0"
    kapt 'com.github.bumptech.glide:compiler:4.9.0'
}






Picasso
Picasso is an image library for Android. It’s created and maintained by Square,
and caters to image loading and processing. It simplifies the process of displaying images from external locations.

Java and Kotlin
dependencies {
    implementation 'com.squareup.picasso:picasso:2.71828'
}



RxJava
If you’re an Android developer, chances are you’ve heard of RxJava. It’s one of the most discussed libraries for enabling Reactive Programming in Android development. It’s touted as the go-to framework for simplifying concurrency/asynchronous tasks inherent in mobile programming.

Java
dependencies {
    implementation 'io.reactivex.rxjava2:rxjava:2.2.0'
}














RxKotlin
RxKotlin/RxJava provides an easy and efficient way to handle asynchronous stream of data in programs running on Java Virtual Machine (JVM). Some examples of asynchronous events can be Network Requests, Touch Input Events etc. Rx in RxKotlin stands for Reactive Extensions.

Kotlin
dependencies {
    implementation 'io.reactivex.rxjava2:rxkotlin:x.y.z'
}
// Building with JitPack
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.ReactiveX:RxKotlin:2.x-SNAPSHOT'
}







RxAndroid
It’s one of the most discussed libraries for enabling Reactive Programming in Android development. It’s touted as the go-to framework for simplifying concurrency/asynchronous tasks inherent in mobile programming.

Java and Kotlin
dependencies {
    implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'
}





Dagger
Dagger is a fully static, compile-time dependency injection framework for both Java and Android.
It is an adaptation of an earlier version created by Square and now maintained by Google.
Dagger aims to address many of the development and performance issues that have plagued reflection-based solutions.

dependencies {
    implementation 'com.google.dagger:dagger-android:2.x'
    implementation 'com.google.dagger:dagger-android-support:2.x' // if you use the support libraries
    kapt 'com.google.dagger:dagger-android-processor:2.x'
}


Lottie
Lottie is a library for Android, iOS, Web, and Windows that parses Adobe After Effects animations exported as 
json with Bodymovin and renders them natively on mobile and on the web.

Java and Kotlin
dependencies {
      implementation "com.airbnb.android:lottie:2.8.0"
}
   


Butterknife
Butterknife is a light weight library to inject views into Android components. It uses annotation processing.
The @BindView annotation allow to 
inject views and performs the cast to the correct type for you. Butterknife also allows to unbind again, via the Unbinder object.


dependencies {
    implementation 'com.jakewharton:butterknife:10.1.0'
    kapt 'com.jakewharton:butterknife-compiler:10.1.0'
}















Mockito
Mockito is a popular mock framework which can be used in conjunction with JUnit. Mockito allows you to create and configure mock objects. Using Mockito simplifies the development of tests for classes with external dependencies significantly.

Java and Kotlin
dependencies {
    testImplementation 'org.mockito:mockito-inline:2.8.47'
}


Espresso
The Espresso test framework. Espresso is a testing framework for Android to make it easy to write reliable user interface tests. The framework also ensures that your activity is started before the tests run.

Java and Kotlin
dependencies {
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test:rules:1.0.2'
}









