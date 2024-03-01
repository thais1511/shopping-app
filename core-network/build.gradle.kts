import com.google.android.libraries.mapsplatform.secrets_gradle_plugin.SecretsPluginExtension

plugins {
    id("my-android-library")
    id("my-hilt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

secrets {
    defaultPropertiesFileName = "${project.projectDir}/release.properties"
}

android {
    namespace = "tqthai.demo.core.network"

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

}

dependencies {
    implementation(libs.android.core.ktx)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.okhttp3.okhttp)
    implementation(libs.okhttp3.loggin.interceptor)
    implementation(libs.coroutines.android)
    implementation(project(":app"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}