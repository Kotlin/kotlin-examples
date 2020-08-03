pluginManagement {
    plugins {
        kotlin("jvm") version "1.4.0-rc"
        id("org.jetbrains.dokka") version ("1.4.0-rc-24")
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

