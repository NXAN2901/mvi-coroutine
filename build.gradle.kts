allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

tasks.register<Delete>("clean") {
    delete(buildDir)
}

apply(from = "gradle/projectDependencyGraph.gradle")