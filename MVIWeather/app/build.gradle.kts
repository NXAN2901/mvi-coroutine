plugins {
    id("com.android.application")
    id("app-plugins")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

android {
    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }
    }
}

dependencies {
    implementation(AppDeps.AndroidX.AppCompat.APPCOMPAT)
    implementation(AppDeps.AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)

    // UI module
    implementation(uiModule("splash"))
    implementation(uiModule("intro"))
    implementation(uiModule("home"))

    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)

    // Koin
    implementation(AppDeps.Koin.CORE)
    implementation(AppDeps.Koin.ANDROID)

    // Navigation
    implementation(AppDeps.AndroidX.Navigation.FRAGMENT_KTX)

    // Retrofit
    implementation(AppDeps.Square.OkHttp.OKHTTP)
    implementation(AppDeps.Square.OkHttp.LOGGING_INTERCEPTOR)
    implementation(AppDeps.Square.Retrofit.RETROFIT)
    implementation(AppDeps.Square.Retrofit.Converters.MOSHI)
    // Moshi
    implementation(AppDeps.Square.Moshi.MOSHI)
    implementation(AppDeps.Square.Moshi.ADAPTERS)
}