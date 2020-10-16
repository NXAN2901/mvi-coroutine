plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("app-plugins")
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    implementation(AppDeps.AndroidX.Fragment.FRAGMENT_KTX)
    // UI
    implementation(AppDeps.AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)
    implementation(AppDeps.AndroidX.SwipeRefreshLayout.SWIPE_REFRESH_LAYOUT)

    // Base
    implementation(uiModule("base"))
    implementation(androidCoreModule("binding"))
    implementation(androidCoreModule("adapter"))

    // UseCase
    implementation(useCaseModule("weather"))
    implementation(coreModule("result"))
    implementation(coreModule("data"))

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

    // Koin
    implementation(AppDeps.Koin.CORE)
    implementation(AppDeps.Koin.ANDROIDX_VIEWMODEL)

    // FLow Binding
    implementation(AppDeps.IO.FlowBinding.MATERIAL)
}