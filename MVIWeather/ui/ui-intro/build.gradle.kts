plugins {
    id("com.android.library")
    id("app-plugins")
    kotlin("kapt")
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    implementation(AppDeps.AndroidX.Fragment.FRAGMENT_KTX)
    // UI
    implementation(AppDeps.AndroidX.AppCompat.APPCOMPAT)
    implementation(AppDeps.AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)
    implementation(AppDeps.Google.Material.MATERIAL)

    // Base
    implementation(uiModule("base"))
    implementation(androidCoreModule("binding"))
    implementation(androidCoreModule("adapter"))

    // ViewModel + LiveData
//    implementation(AppDeps.AndroidX.LifeCycle.LIVEDATA_CORE)
    implementation(AppDeps.AndroidX.LifeCycle.RUNTIME)
    implementation(AppDeps.AndroidX.LifeCycle.COMMON_JAVA8)
    implementation(AppDeps.AndroidX.LifeCycle.LIVEDATA_KTX)
    implementation(AppDeps.AndroidX.LifeCycle.VIEWMODEL_KTX)

    // Koin
    implementation(AppDeps.Koin.CORE)
    implementation(AppDeps.Koin.ANDROIDX_VIEWMODEL)
}