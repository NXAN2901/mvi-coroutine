object TestDeps {
    object Junit {
        private const val VERSION = "1.3.0-alpha08"
        const val FRAGMENT_ISOLATION = "androidx.fragment:fragment-testing:$VERSION"
    }

    object KotlinX {
        private const val VERSION = SharedVersions.KotlinX.COROUTINES
        const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$VERSION"
    }

    object IO {
        object MockK {
            private const val VERSION = "1.10.2"
            const val UNIT = "io.mockk:mockk:$VERSION"
            const val INSTRUMENTED = "io.mockk:mockk-android:$VERSION"
            const val COMMON_MULTI_PLATFORMS = "io.mockk:mockk-common:$VERSION"
        }
    }

}