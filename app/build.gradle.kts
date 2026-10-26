import java.io.File
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val localSigning = Properties().apply {
    val file = rootProject.file("keystore.properties")
    if (file.isFile) file.inputStream().use(::load)
}
fun configuredValue(environmentName: String, localName: String): String? =
    System.getenv(environmentName)?.takeIf(String::isNotBlank)
        ?: localSigning.getProperty(localName)?.takeIf(String::isNotBlank)

val signingStorePath = configuredValue("ANDROID_KEYSTORE_PATH", "storeFile")
val signingStorePassword = configuredValue("ANDROID_KEYSTORE_PASSWORD", "storePassword")
val signingAlias = configuredValue("ANDROID_KEY_ALIAS", "keyAlias")
val signingKeyPassword = configuredValue("ANDROID_KEY_PASSWORD", "keyPassword")
val signingValues = listOf(signingStorePath, signingStorePassword, signingAlias, signingKeyPassword)
val releaseSigningConfigured = signingValues.all { value ->
    !value.isNullOrBlank() && !value.contains("REPLACE_ME") && !value.contains("path/to/")
} && signingStorePath?.let { file ->
    val candidate = rootProject.file(file)
    candidate.isFile || File(file).isFile
} == true

android {
    namespace = "com.fedos.musenumberfive"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fedos.musenumberfive"
        minSdk = 26
        targetSdk = 34
        versionCode = 2
        versionName = "0.2.0"
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            if (releaseSigningConfigured) {
                signingConfig = signingConfigs.create("configuredRelease") {
                    storeFile = signingStorePath?.let { path ->
                        val candidate = rootProject.file(path)
                        if (candidate.isFile) candidate else File(path)
                    }
                    storePassword = signingStorePassword
                    keyAlias = signingAlias
                    keyPassword = signingKeyPassword
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = false
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.fragment:fragment-ktx:1.7.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.webkit:webkit:1.9.0")
}
