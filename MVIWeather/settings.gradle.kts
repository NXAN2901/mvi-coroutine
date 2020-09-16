rootProject.name = "MVIWeather"
include(
        ":app",
        ":android-core:android-core-adapter",
        ":android-core:android-core-binding",

        ":weather-stack:use-case",

        ":core:core-dispatchers",

        ":ui:ui-splash",
        ":ui:ui-base",
        ":ui:ui-intro",
        ":ui:ui-home"
)
