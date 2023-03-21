plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'

}

android {
    namespace 'com.example.tenexapp'
    compileSdk 33

    defaultConfig {
        applicationId "com.example.tenexapp"
        minSdk 24
        targetSdk 33
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
    buildFeatures {
        compose true
    }
    composeOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        kotlinCompilerExtensionVersion '1.2.0'
    }
    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
}

dependencies {


    def  nav_version = "2.5.3"

    implementation("androidx.navigation:navigation-compose:2.5.3")

    implementation "androidx.navigation:navigation-compose:2.6.0-alpha07"

    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:okhttp:3.14.9'
    // retrofit

    implementation 'com.squareup.retrofit2:retrofit:2.9.0'

// GSON

    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

// coroutine

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2'



    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.0'
    implementation 'androidx.activity:activity-compose:1.6.1'
    implementation "androidx.compose.ui:ui:1.3.3"
    implementation "androidx.compose.ui:ui-tooling-preview:1.3.3"
    implementation 'androidx.compose.material:material:1.3.1'
    testImplementation 'junit:junit:4.13.2'
    implementation "android.arch.persistence.room:runtime:1.1.1"
    annotationProcessor "android.arch.persistence.room:compiler:1.1.1"
    implementation("io.coil-kt:coil-compose:1.3.1")
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:1.3.3"
    debugImplementation "androidx.compose.ui:ui-tooling:1.3.3"
    debugImplementation "androidx.compose.ui:ui-test-manifest:1.3.3"

    def moshiVersion = "1.10.0"
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    def lifecycle_version = "1.1.1"

    implementation "android.arch.lifecycle:extensions:1.1.1"
    annotationProcessor "android.arch.lifecycle:compiler:1.1.1"

    //room
    def room_version = "1.1.1"
    implementation "android.arch.persistence.room:runtime:1.1.1"
    annotationProcessor "android.arch.persistence.room:compiler:1.1.1"
    testImplementation "android.arch.persistence.room:testing:1.1.1"
}
