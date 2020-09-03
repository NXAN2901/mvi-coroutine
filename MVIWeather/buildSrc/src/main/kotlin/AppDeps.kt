object AppDeps {
    object AndroidX {
        object Core {
            private const val VERSION = "1.2.0"
            const val KTX = "androidx.core:core-ktx$VERSION"
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
            const val COMMON_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:$VERSION"
            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel:$VERSION"
            const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
            const val LIVEDATA_CORE = "androidx.lifecycle:lifecycle-livedata-core:$VERSION"
            const val LIVEDATA_CORE_KTX = "androidx.lifecycle:lifecycle-livedata-core-ktx:$VERSION"
            const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:$VERSION"
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
}