plugins {
    id("com.android.library")
    id("app-plugins")
    kotlin("kapt")
}

dependencies {
    implementation(AppDeps.AndroidX.Hilt.Core.ANDROID)
    kapt(AppDeps.AndroidX.Hilt.Core.ANDROID_COMPILER)
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    implementation(AppDeps.Kotlinx.Coroutines.ANDROID)
}