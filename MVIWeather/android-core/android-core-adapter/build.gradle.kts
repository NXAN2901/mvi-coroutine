plugins {
    id("com.android.library")
    id("app-plugins")
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
}