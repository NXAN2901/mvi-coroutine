rootProject.name = "MVIWeather"
include(
        ":app",
        ":android-core:android-core-adapter",
        ":android-core:android-core-binding",
        ":android-core:android-core-datastore",

        ":weather-stack:use-case-weather",
        ":weather-stack:remote-repo-weather",

        ":core:core-dispatchers",
        ":core:core-domain",
        ":core:core-usecase",
        ":core:core-result",
        ":core:core-data",

        ":ui:ui-splash",
        ":ui:ui-base",
        ":ui:ui-intro",
        ":ui:ui-home"
)
