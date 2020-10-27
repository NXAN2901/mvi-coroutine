plugins {
    id("com.android.library")
    id("app-plugins")
}

dependencies {
    implementation(AppDeps.Koin.CORE)
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    api(androidCoreModule("datastore"))

    implementation(useCaseModule("weather"))

    // WorkManager
    implementation(AppDeps.Arch.WorkManager.WORK_KTX)


}