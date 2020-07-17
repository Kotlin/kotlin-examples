import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm") version "1.4-M3"
    id("org.jetbrains.dokka") version ("1.4-M3-dev-94")
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-dev")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit"))
}

tasks.withType<DokkaTask> {
    dokkaSourceSets {
        register("main") {
            moduleDisplayName = "Dokka Gradle Example"
            includes = listOf("Module.md")
            sourceLink {
                path = "src/main/kotlin"
                url = "https://github.com/Kotlin/kotlin-examples/tree/master/" +
                        "gradle/dokka/dokka-gradle-example/src/main/kotlin"
                lineSuffix = "#L"
            }
        }
    }
}
