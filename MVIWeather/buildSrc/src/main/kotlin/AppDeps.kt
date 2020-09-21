object AppDeps {
    object AndroidX {
        object Core {
            private const val VERSION = "1.2.0"
            const val KTX = "androidx.core:core-ktx:$VERSION"
        }

        object ConstraintLayout {
            private const val VERSION = "2.0.1"
            const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:$VERSION"
        }

        object AppCompat {
            private const val VERSION = "1.2.0"
            const val APPCOMPAT = "androidx.appcompat:appcompat:$VERSION"
        }

        object LifeCycle {
            private const val VERSION = "2.2.0"
            const val COMMON = "androidx.lifecycle:lifecycle-common:$VERSION"
            const val RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:$VERSION"
            const val RUNTIME = "androidx.lifecycle:lifecycle-runtime:$VERSION"
            const val COMMON_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:$VERSION"
            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel:$VERSION"
            const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
            const val LIVEDATA_CORE = "androidx.lifecycle:lifecycle-livedata-core:$VERSION"
            const val LIVEDATA_CORE_KTX = "androidx.lifecycle:lifecycle-livedata-core-ktx:$VERSION"
            const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:$VERSION"
        }

        object Navigation {
            private const val VERSION = "2.3.0"
            // JAVA
            const val FRAGMENT = "androidx.navigation:navigation-fragment:$VERSION"
            const val UI = "androidx.navigation:navigation-ui:$VERSION"
            // Kotlin
            const val FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:$VERSION"
            const val UI_KTX = "androidx.navigation:navigation-ui-ktx:$VERSION"

            const val RUNTIME = "androidx.navigation:navigation-runtime:$VERSION"
            const val RUNTIME_KTX = "androidx.navigation:navigation-runtime-ktx:$VERSION"
            const val DYNAMIC_FEATURES_FRAGMENT = "androidx.navigation:navigation-dynamic-features-fragment:$VERSION"
        }

        object Fragment {
            private const val VERSION = "1.3.0-alpha08"
            const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:$VERSION"
            const val FRAGMENT = "androidx.fragment:fragment:$VERSION"
        }

        object Hilt {
            private const val VERSION = "2.28.1-alpha"

            object Core {
                const val ANDROID = "com.google.dagger:hilt-android:$VERSION"
                const val ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:$VERSION"
            }

            object ViewModel {
                private const val VERSION = "1.0.0-alpha02"
                const val LIFECYCLE = "androidx.hilt:hilt-lifecycle-viewmodel:$VERSION"
                const val COMPILER = "androidx.hilt:hilt-compiler:$VERSION"
            }

        }

    }

    object Google {
        object Material {
            private const val VERSION = "1.3.0-alpha02"
            const val MATERIAL = "com.google.android.material:material:$VERSION"
        }
    }

    object Kotlinx {
        object Coroutines {
            private const val VERSION = SharedVersions.Kotlinx.COROUTINES
            const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
            const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
        }
    }

    object Square {
        object OkHttp {
            private const val VERSION = "4.4.0"
            const val OKHTTP = "com.squareup.okhttp3:okhttp:$VERSION"
            const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:$VERSION"
        }

        object Retrofit {
            private const val VERSION = "2.8.1"
            const val RETROFIT = "com.squareup.retrofit2:retrofit:$VERSION"

            object Converters {
                const val GSON = "com.squareup.retrofit2:converter-gson:$VERSION"
            }
        }
    }

    object Koin {
        private const val VERSION = "2.1.6"
        const val CORE = "org.koin:koin-core:$VERSION"
        const val ANDROID = "org.koin:koin-android:$VERSION"
        const val ANDROIDX_VIEWMODEL = "org.koin:koin-androidx-viewmodel:$VERSION"
    }

    object IO {
        object FlowBinding {
            private const val VERSION = "1.0.0-alpha04"
            const val CORE = "io.github.reactivecircus.flowbinding:flowbinding-appcompat:$VERSION"
            const val ANDROID = "io.github.reactivecircus.flowbinding:flowbinding-android:$VERSION"
            const val APPCOMPAT = "io.github.reactivecircus.flowbinding:flowbinding-appcompat:$VERSION"
            const val ACTIVITY = "io.github.reactivecircus.flowbinding:flowbinding-core:$VERSION"
            const val DRAWER_LAYOUT = "io.github.reactivecircus.flowbinding:flowbinding-drawerlayout:$VERSION"
            const val LIFECYCLE = "io.github.reactivecircus.flowbinding:flowbinding-lifecycle:$VERSION"
            const val NAVIGATION = "io.github.reactivecircus.flowbinding:flowbinding-navigation:$VERSION"
            const val PREFERENCE = "io.github.reactivecircus.flowbinding:flowbinding-preference:$VERSION"
            const val RECYCLERVIEW = "io.github.reactivecircus.flowbinding:flowbinding-recyclerview:$VERSION"
            const val SWIPE_REFRESH_LAYOUT = "io.github.reactivecircus.flowbinding:flowbinding-swiperefreshlayout:$VERSION"
            const val VIEWPAGER = "io.github.reactivecircus.flowbinding:flowbinding-viewpager:$VERSION"
            const val VIEWPAGER2 = "io.github.reactivecircus.flowbinding:flowbinding-viewpager2:$VERSION"
            const val MATERIAL = "io.github.reactivecircus.flowbinding:flowbinding-material:$VERSION"
        }
    }
}