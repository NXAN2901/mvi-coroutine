plugins {
    id("com.android.library")
    id("app-plugins")
//    kotlin("jvm")
}

dependencies {
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    implementation(AppDeps.Kotlinx.Coroutines.ANDROID)
}