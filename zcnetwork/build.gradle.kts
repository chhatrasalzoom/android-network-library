plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "2.0.20"
}

android {
    namespace = "com.zoomcar.zcnetwork"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.okhttp)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.koltinx.serilization)
    implementation(libs.jackson.core)
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.json)
}