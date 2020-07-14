import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
}

dependencies {
    implementation(kotlin("stdlib"))
}

tasks.withType<DokkaTask> {
    dokkaSourceSets {
        configureEach {
            includes = listOf("Module.md")
        }
    }
}
