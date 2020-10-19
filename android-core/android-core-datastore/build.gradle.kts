plugins {
    id("com.android.library")
    id("app-plugins")
}
dependencies {
    api(AppDeps.AndroidX.DataStore.CORE)
    api(AppDeps.AndroidX.DataStore.PREFERENCES)
}