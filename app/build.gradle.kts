import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.hikari.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.allinone.universe"
        minSdk = 24
        targetSdk = 34
        versionCode = 466
        versionName = "1.0.0-alpha01"
        // CI injects the exact commit SHA the APK was built from, so the
        // in-app update checker can compare it against main's HEAD.
        val gitSha = System.getenv("GIT_SHA") ?: "unknown"
        buildConfigField("String", "GIT_SHA", "\"$gitSha\"")
        // The repository the build runs in (owner/name). The cloned-voice model for Dub audio is
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

    implementation(libs.core_ktx)
    implementation(libs.junit)
    androidTestImplementation(libs.androidx_test.ext.junit)
    androidTestImplementation(libs.espresso_core)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose_bom))
    implementation(libs.ui)
    implementation(libs.ui_graphics)
    implementation(libs.ui_tooling_preview)
    implementation(libs.material3)
    implementation(libs.androidx.credentials.playservices.playservices.auth)
    implementation(libs.play.services.auth)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.database.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.storage.ktx)
    implementation(libs.firebase.config.ktx)
    implementation(libs.firebase.messaging.ktx)
    implementation(libs.androidx.credentials.playservices.playservices.auth)
    implementation(libs.play.services.auth)
    implementation(libs.play.services.oss.licenses.plugin)
    implementation(libs.play.services.oss.licenses.ui.compose)
    implementation(libs.oss.licenses.plugin)
    implementation(libs.oss.licenses.ui.compose)
    implementation(libs.play.services.oss.licenses)
    implementation(libs.oss.licenses)
    implementation(libs.accompanist.permissions)
    implementation(libs.coil.compose)
    implementation(libs.gson)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.retrofit2.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material.material)
    implementation(libs.androidx.compose.material.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.firebase.analytics.ktx)
    implementation(libs.play.services.oss.licenses.ui)
    implementation(libs.play.services.oss.licenses)
    implementation(libs.oss.licenses.ui)
    implementation(libs.oss.licenses)
}
