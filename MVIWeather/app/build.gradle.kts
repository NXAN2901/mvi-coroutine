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
    implementation(AppDeps.AndroidX.Fragment.FRAGMENT)

    // UI module
//    implementation(uiModule("splash"))
//    implementation(uiModule("intro"))

    implementation(commonModule("android"))

    // Hilt
    implementation(AppDeps.AndroidX.Hilt.Core.ANDROID)
    kapt(AppDeps.AndroidX.Hilt.Core.ANDROID_COMPILER)

    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)
    implementation(AppDeps.AndroidX.Navigation.UI_KTX)
    implementation(AppDeps.AndroidX.Navigation.DYNAMIC_FEATURES_FRAGMENT)
}