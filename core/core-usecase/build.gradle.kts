plugins {
    id("com.android.library")
    id("app-plugins")
}

dependencies {

    implementation(AppDeps.Koin.CORE)
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    implementation(coreModule("result"))
//    implementation(AppDeps.Kotlinx.Coroutines.CORE)
}