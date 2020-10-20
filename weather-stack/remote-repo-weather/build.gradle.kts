plugins {
    id("com.android.library")
    id("app-plugins")
}

dependencies {
    implementation(AppDeps.Square.Retrofit.Converters.GSON)
    implementation(AppDeps.Square.Retrofit.RETROFIT)
    implementation(coreModule("domain"))

    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    implementation(AppDeps.Koin.CORE)

    // Test
    testImplementation(TestDeps.KotlinX.COROUTINES_TEST)
    testImplementation(TestDeps.IO.MockK.UNIT)
}