plugins {
    id("com.android.library")
    id("app-plugins")
    kotlin("kapt")
}

dependencies {
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    implementation(AppDeps.Kotlinx.Coroutines.ANDROID)

    implementation(AppDeps.Koin.CORE)
}