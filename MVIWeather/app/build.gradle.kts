plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("app-plugins")
    kotlin("kapt")
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
    implementation(AppDeps.AndroidX.Fragment.FRAGMENT)

    // UI module
    implementation(uiModule("splash"))

    // Hilt
    implementation(AppDeps.AndroidX.Hilt.Core.ANDROID)
    kapt(AppDeps.AndroidX.Hilt.Core.ANDROID_COMPILER)

    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)
    implementation(AppDeps.AndroidX.Navigation.UI_KTX)
}