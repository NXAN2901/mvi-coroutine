plugins {
    id("com.android.library")
    id("app-plugins")
    kotlin("kapt")
}

dependencies {

    api(AppDeps.Koin.CORE)
    api(AppDeps.Kotlinx.Coroutines.CORE)

    api(coreModule("domain"))
    api(coreModule("dispatchers"))
    api(coreModule("usecase"))
    api(coreModule("result"))
    api(remoteRepoModule("weather"))
}