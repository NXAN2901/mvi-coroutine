plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("app-plugins")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

android {
    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }
    }
}

dependencies {
    implementation(AppDeps.AndroidX.AppCompat.APPCOMPAT)
    implementation(AppDeps.AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)

    // UI module
    implementation(uiModule("splash"))
    implementation(uiModule("intro"))

    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)

    // Hilt
    implementation(AppDeps.AndroidX.Hilt.Core.ANDROID)
    kapt(AppDeps.AndroidX.Hilt.Core.ANDROID_COMPILER)

    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)
}