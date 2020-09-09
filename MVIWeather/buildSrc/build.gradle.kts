plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

gradlePlugin {
    plugins {
        register("app-plugins") {
            id = "app-plugins"
            implementationClass = "AppPlugins"
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.28.1-alpha")
    implementation("com.android.tools.build:gradle:4.0.1")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0")
    implementation(kotlin("gradle-plugin", "1.3.50"))
    implementation(kotlin("android-extensions"))

//    implementation("org.jacoco:org.jacoco.core:0.8.4")
}