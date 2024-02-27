plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("myApplicationConventionPlugin") {
            id = "my-android-application"
            implementationClass = "MyApplicationConventionPlugin"
        }
        register("myLibraryConventionPlugin") {
            id = "my-android-library"
            implementationClass = "MyLibraryConventionPlugin"
        }
        register("myHiltConventionPlugin") {
            id = "my-hilt"
            implementationClass = "MyHiltConventionPlugin"
        }
    }
}