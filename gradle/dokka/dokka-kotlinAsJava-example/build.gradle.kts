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

    // Will apply the plugin to all dokka tasks
    dokkaPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4-M3-dev-94")

    // Will apply the plugin only to the `:dokkaHtml` task
    //dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4-M3-dev-94")

    // Will apply the plugin only to the `:dokkaGfm` task
    //dokkaGfmPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4-M3-dev-94")
}
