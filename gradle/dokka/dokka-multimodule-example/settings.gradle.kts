pluginManagement {
    plugins {
        kotlin("jvm") version "1.4-M3"
        id("org.jetbrains.dokka") version ("1.4.0-M3-dev-80")
    }
    repositories {
        jcenter()
        mavenCentral()
        maven("https://dl.bintray.com/kotlin/kotlin-dev")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}

include(":parentProject")
include(":parentProject:childProjectA")
include(":parentProject:childProjectB")

rootProject.name = "dokka-multimodule-example"

