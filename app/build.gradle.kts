import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.tx24.android.application")
    id("com.tx24.android.application.compose")
    id("com.tx24.android.hilt")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.tx24.spicyplayer"
    buildFeatures {
        buildConfig = true
    }
    //compileSdk = 33

    defaultConfig {
        applicationId = "com.tx24.spicyplayer"

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        debug {
            applicationIdSuffix = ".debug"
            resValue("string", "app_name", "Spicy Player.d")
        }
    }


    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    implementation(libs.core.ktx)
    implementation(libs.media3.session)
    implementation(libs.media3.exoplayer)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.timber)
    
    // Extracted from features
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.tooling)
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    implementation(libs.retrofit)
    implementation(libs.gson.converter)
    implementation(libs.okio)
    implementation(libs.datastore)
    implementation(libs.coil)
    implementation(libs.androidx.palette)
    implementation(libs.material)
    implementation(libs.drag.reorder)
    implementation(libs.jaudio.tagger)
    implementation(libs.glance)
    implementation(libs.glance.material)

    api(libs.accompanist.permissions)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}