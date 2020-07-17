pluginManagement {
    plugins {
        kotlin("jvm") version "1.4-M3"
        id("org.jetbrains.dokka") version ("1.4-mc-1")
    }
    repositories {
        jcenter()
        mavenCentral()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://dl.bintray.com/kotlin/kotlin-dev")
    }
}

include(":parentProject")
include(":parentProject:childProjectA")
include(":parentProject:childProjectB")

rootProject.name = "dokka-multimodule-example"

