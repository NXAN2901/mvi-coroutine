plugins {
    id("com.android.application")
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

    // Koin
    implementation(AppDeps.Koin.CORE)
    implementation(AppDeps.Koin.ANDROID)

    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)
}