plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
}

dependencies {
    implementation(kotlin("stdlib"))
}

/**
 * Configuring the html multimodule task
 * Run ./gradlew :parentProject:dokkaHtmlMultimodule dokkaHtml
 */
tasks.dokkaHtmlMultimodule {
    documentationFileName = "Module.md"
}

