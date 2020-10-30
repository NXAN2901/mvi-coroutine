import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("app-plugins")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

val openWeatherUrl: String by project
// Secret properties file contains some secrets key (ex: AppID for OpenWeatherAPI ...)
// Change secretsProperties["APP_ID"] with your OpenWeatherAPI AppID
val secretsPropertiesFile = rootProject.file("secrets.properties")
val secretsProperties = Properties()
secretsProperties.load(FileInputStream(secretsPropertiesFile))

android {
    defaultConfig {
        buildConfigField("String", "APP_ID", "\"${secretsProperties["APP_ID"]}\"")
        buildConfigField("String", "WEATHER_BASE_URL", "\"${openWeatherUrl}\"")
    }
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

    // Core Module
    implementation(remoteRepoModule("weather"))
    implementation(coreModule("dispatchers"))
    implementation(coreModule("data"))

    // UseCase module
    implementation(useCaseModule("weather"))

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
    implementation(AppDeps.Square.Retrofit.Converters.GSON)
    // Moshi
    implementation(AppDeps.Square.Moshi.MOSHI)
    implementation(AppDeps.Square.Moshi.ADAPTERS)
}