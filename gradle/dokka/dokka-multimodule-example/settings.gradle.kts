pluginManagement {
    plugins {
        kotlin("jvm") version "1.4.0-rc"
        id("org.jetbrains.dokka") version ("1.4.0-rc")
    }
    repositories {
        jcenter()
        mavenCentral()
    }
}

include(":parentProject")
include(":parentProject:childProjectA")
include(":parentProject:childProjectB")

rootProject.name = "dokka-multimodule-example"

