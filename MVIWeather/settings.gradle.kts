rootProject.name = "MVIWeather"
include(
        ":app",
        ":android-core:android-core-adapter",
        ":android-core:android-core-binding",

        ":weather-stack:use-case",

        ":core:core-dispatchers",
        ":core:core-domain",
        ":core:core-usecase",
        ":core:core-result",

        ":ui:ui-splash",
        ":ui:ui-base",
        ":ui:ui-intro",
        ":ui:ui-home"
)
