pluginManagement {
    plugins {
        kotlin("jvm") version "1.4-M3"
        id("org.jetbrains.dokka") version ("1.4.0-M3-dev-69")
    }
    repositories {
        jcenter()
        mavenCentral()
        maven("https://dl.bintray.com/kotlin/kotlin-dev")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}

rootProject.name = "dokka-multimodule-example"

