import com.android.build.gradle.LibraryExtension
import tqthai.demo.shoppingapp.configureBuildType
import tqthai.demo.shoppingapp.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class MyLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureBuildType(this)
                buildFeatures {
                    buildConfig = true
                }
            }
        }

    }
}