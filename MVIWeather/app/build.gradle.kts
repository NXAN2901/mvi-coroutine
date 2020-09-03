plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("app-plugins")
    kotlin("kapt")
}

android {
    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }
    }

//    buildFeatures {
//        dataBinding = true
//    }
    dataBinding.isEnabled = true
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0-alpha02")

    implementation("androidx.fragment:fragment-ktx:1.2.5")

    implementation(AppDeps.AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.28.1-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.28.1-alpha")

    // Hilt ViewModel extension
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")

    implementation(coreModule("dispatchers"))

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.2.0")
    implementation("android.arch.lifecycle:common-java8:2.2.0")


}