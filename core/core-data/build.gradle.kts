import com.google.protobuf.gradle.*

plugins {
    id("com.android.library")
    id("app-plugins")
    id("com.google.protobuf").version("0.8.12")
}

dependencies {
    implementation(AppDeps.Koin.CORE)
    implementation(AppDeps.Kotlinx.Coroutines.CORE)
    api(androidCoreModule("datastore"))
    api(coreModule("usecase"))
    api("com.google.protobuf:protobuf-javalite:3.11.0")

    implementation(useCaseModule("weather"))

    // WorkManager
    implementation(AppDeps.Arch.WorkManager.WORK_KTX)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.10.0"
    }

    // Generates the java Protobuf-lite code for the Protobufs in this project. See
    // https://github.com/google/protobuf-gradle-plugin#customizing-protobuf-compilation
    // for more information.
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}