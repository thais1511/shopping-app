import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import tqthai.demo.shoppingapp.configureBuildType
import tqthai.demo.shoppingapp.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class MyApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<BaseAppModuleExtension> {
                configureKotlinAndroid(this)
                configureBuildType(this)
                buildFeatures {
                    buildConfig = true
                }
            }

        }
    }
}