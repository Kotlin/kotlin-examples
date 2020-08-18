plugins {
    kotlin("jvm") version "1.4.0-rc"
    id("org.jetbrains.dokka") version ("1.4.0-rc")
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit"))

    // Will apply the plugin to all dokka tasks
    dokkaPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4.0-rc")

    // Will apply the plugin only to the `:dokkaHtml` task
    //dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4.0-rc")

    // Will apply the plugin only to the `:dokkaGfm` task
    //dokkaGfmPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4.0-rc")
}
