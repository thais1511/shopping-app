pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ShoppingApp"
include(":app")
include(":core-network")
include(":core-localstorage")
include(":core-data")
include(":core-common")
include(":core-model")
include(":core-designSystem")
include(":core-theme")
