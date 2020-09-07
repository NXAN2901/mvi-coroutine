import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

fun Project.addHiltDependencies(configName: String = "implementation") {
    dependencies {
        add(configName, AppDeps.AndroidX.Hilt.Core.ANDROID)
        add(configName, AppDeps.AndroidX.Hilt.Core.ANDROID_COMPILER)
    }
}

fun Project.addHiltViewModelExtension(configName: String = "implementation") {
    dependencies {
        add(configName, AppDeps.AndroidX.Hilt.ViewModel.COMPILER)
        add(configName, AppDeps.AndroidX.Hilt.ViewModel.LIFECYCLE)
    }
}

fun DependencyHandler.coreModule(moduleNotation: String) = project(":core:core-$moduleNotation")
fun DependencyHandler.androidCoreModule(moduleNotation: String) = project(":android-core:android-core-$moduleNotation")
fun DependencyHandler.uiModule(moduleNotation: String) = project(":ui:$moduleNotation")