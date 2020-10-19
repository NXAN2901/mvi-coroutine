plugins {
    id("com.android.library")
    id("app-plugins")
    id("androidx.navigation.safeargs")
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    implementation(AppDeps.AndroidX.Fragment.FRAGMENT_KTX)
    implementation(androidCoreModule("binding"))

    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)
    implementation(AppDeps.AndroidX.Navigation.UI_KTX)
    implementation(AppDeps.AndroidX.Navigation.DYNAMIC_FEATURES_FRAGMENT)
}