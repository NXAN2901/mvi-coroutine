plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
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
    implementation("com.android.tools.build:gradle:4.0.1")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0")
    implementation(kotlin("gradle-plugin", "1.4.10"))
    implementation(kotlin("android-extensions"))

//    implementation("org.jacoco:org.jacoco.core:0.8.4")
}