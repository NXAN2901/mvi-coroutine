plugins {
    id("com.android.library")
    id("app-plugins")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

dependencies {
    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)
    implementation(AppDeps.AndroidX.Navigation.UI_KTX)
    implementation(AppDeps.AndroidX.Navigation.DYNAMIC_FEATURES_FRAGMENT)

    implementation(uiModule("splash"))
    implementation(uiModule("intro"))
}
