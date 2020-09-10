plugins {
    id("com.android.library")
    id("app-plugins")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    implementation(AppDeps.AndroidX.Fragment.FRAGMENT_KTX)
    implementation(AppDeps.AndroidX.Core.KTX)
    // UI
    implementation(AppDeps.AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)

    // Base
    implementation(uiModule("base"))
    implementation(androidCoreModule("binding"))

    // ViewModel + LiveData
    implementation(AppDeps.AndroidX.LifeCycle.LIVEDATA_CORE)
    implementation(AppDeps.AndroidX.LifeCycle.RUNTIME_KTX)
    implementation(AppDeps.AndroidX.LifeCycle.COMMON)
    implementation(AppDeps.AndroidX.LifeCycle.VIEWMODEL)
    implementation(AppDeps.AndroidX.LifeCycle.VIEWMODEL_KTX)

    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)
    implementation(AppDeps.AndroidX.Navigation.UI_KTX)
    implementation(AppDeps.AndroidX.Navigation.DYNAMIC_FEATURES_FRAGMENT)

    // Hilt core
    implementation(AppDeps.AndroidX.Hilt.Core.ANDROID)
    kapt(AppDeps.AndroidX.Hilt.Core.ANDROID_COMPILER)
    // Hilt view model
    implementation(AppDeps.AndroidX.Hilt.ViewModel.LIFECYCLE)
    kapt(AppDeps.AndroidX.Hilt.ViewModel.COMPILER)

}