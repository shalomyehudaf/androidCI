pluginManagement {
    repositories {
        // prefer the plugin portal first for alias/plugin lookups, then Google's Maven and Maven Central
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    // Ensure plugin ids map to the correct artifact coordinates when using the plugins DSL / version catalogs
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application", "com.android.library", "com.android.test" -> {
                    useModule("com.android.tools.build:gradle:${requested.version}")
                }
                // Kotlin plugins (covers org.jetbrains.kotlin.* aliases)
                "org.jetbrains.kotlin.jvm", "org.jetbrains.kotlin.android", "org.jetbrains.kotlin.kapt",
                "org.jetbrains.kotlin.plugin.serialization", "org.jetbrains.kotlin.multiplatform" -> {
                    useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
                }
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CalculatorApp"
include(":app")
