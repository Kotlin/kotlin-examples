@file:Suppress("UNUSED_VARIABLE")

import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform") version "1.4.0-rc"
    id("org.jetbrains.dokka") version "1.4.0-rc"
}

repositories {
    jcenter()
}

group = "org.test"
version = "1.0-SNAPSHOT"

kotlin {
    jvm() // Create a JVM target with the default name "jvm"
    linuxX64("linux")
    macosX64("macos")
    js()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8-1.4.0-rc")
            }
        }
    }
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        register("commonMain") {
            sourceRoot { path = "src/commonMain/kotlin" }
        }

        register("jsMain") {
            dependsOn("commonMain")
            sourceRoot { path = "src/jsMain/kotlin" }
        }

        register("jvmMain") {
            dependsOn("commonMain")
            sourceRoot { path = "src/jvmMain/kotlin" }
        }

        register("linuxMain") {
            dependsOn("commonMain")
            sourceRoot { path = "src/linuxMain/kotlin" }
        }

        register("macosMain") {
            dependsOn("commonMain")
            sourceRoot { path = "src/macosMain/kotlin" }
        }

        /*
        Create custom source set (not known to the Kotlin Gradle Plugin)
         */
        register("customSourceSet") {
            this.jdkVersion = 9
            this.displayName = "Custom JDK 10 Source Set"
            this.sourceRoot {
                this.path = "src/customJdk10/kotlin"
            }
        }
    }
}
