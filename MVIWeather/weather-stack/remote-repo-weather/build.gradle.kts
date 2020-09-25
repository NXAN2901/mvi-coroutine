plugins {
    id("com.android.library")
    id("app-plugins")
}

dependencies {
    implementation(AppDeps.Square.Retrofit.RETROFIT)
    implementation(AppDeps.Square.Retrofit.Converters.MOSHI)
    implementation(AppDeps.Square.Retrofit.Converters.GSON)
    implementation(AppDeps.Square.Moshi.KOTLIN)
    implementation(AppDeps.Square.Moshi.ADAPTERS)
    implementation(coreModule("domain"))
}