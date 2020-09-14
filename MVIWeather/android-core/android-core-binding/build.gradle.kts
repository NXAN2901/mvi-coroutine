plugins {
    id("com.android.library")
    id("app-plugins")
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    implementation(AppDeps.AndroidX.AppCompat.APPCOMPAT)
    implementation(AppDeps.AndroidX.Fragment.FRAGMENT)
    implementation(AppDeps.AndroidX.LifeCycle.COMMON)
    implementation(AppDeps.AndroidX.LifeCycle.COMMON_JAVA8)
    implementation(AppDeps.AndroidX.LifeCycle.LIVEDATA_CORE)
    implementation(AppDeps.AndroidX.LifeCycle.LIVEDATA_CORE_KTX)
}