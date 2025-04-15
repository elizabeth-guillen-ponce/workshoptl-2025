plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //Google Services
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.example.workshop_tl"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.workshop_tl"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation( "com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //Koin
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.coroutines)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)

    //Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}