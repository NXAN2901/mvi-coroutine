import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.tools.build.jetifier.core.utils.Log
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AppPlugins : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("kotlin-android")
        target.plugins.apply("kotlin-android-extensions")

        // Common Android Build Settings
        val androidExtensions = target.extensions.getByName("android")
        if (androidExtensions is BaseExtension) {
            androidExtensions.apply {
                compileSdkVersion(29)
                defaultConfig {
                    targetSdkVersion(29)
                    minSdkVersion(23)
                    versionCode = 1
                    versionName = "1.0.0"

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                // Common proguard
                val proguardFile = "proguard-rule.pro"
                when (this) {
                    is LibraryExtension -> defaultConfig {
                        consumerProguardFiles(proguardFile)
                    }
                    is AppExtension -> buildTypes {
                        getByName("release") {
                            isMinifyEnabled = true
                            isShrinkResources = true
                            proguardFile {
                                getDefaultProguardFile("proguard-android-optimize.txt")
                                proguardFile
                            }
                        }
                    }
                }

                // Enable Java 8
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                target.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        jvmTarget = "1.8"
                        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
                    }
                }

                // Add Dependencies for all module
                target.dependencies.apply {
                    add("implementation", "org.jetbrains.kotlin:kotlin-stdlib:1.4.0")
                    add("implementation", "androidx.core:core-ktx:1.3.1")

                    // test
                    add("testImplementation", "junit:junit:4.13")
                    add("androidTestImplementation", "androidx.test.ext:junit:1.1.1")
                    add("androidTestImplementation", "androidx.test.espresso:espresso-core:3.2.0")
                }
            }
        }
    }
}