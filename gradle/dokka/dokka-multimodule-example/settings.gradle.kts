pluginManagement {
    plugins {
        kotlin("jvm") version "1.4.20"
        id("org.jetbrains.dokka") version ("1.4.20")
    }
    repositories {
        gradlePluginPortal()
        jcenter()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")
    }
}

include(":parentProject")
include(":parentProject:childProjectA")
include(":parentProject:childProjectB")

rootProject.name = "dokka-multimodule-example"

