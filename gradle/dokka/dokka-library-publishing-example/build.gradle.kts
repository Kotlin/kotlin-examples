plugins {
    kotlin("jvm") version "1.4.0-rc"
    id("org.jetbrains.dokka") version ("1.4.0-rc")
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://dl.bintray.com/kotlin/kotlin-dev")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit"))
}

val dokkaJavadocJar by tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.get().getOutputDirectoryAsFile())
    archiveClassifier.set("javadoc")
}

val dokkaHtmlJar by tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.get().getOutputDirectoryAsFile())
    archiveClassifier.set("html-doc")
}

publishing {
    publications {
        register<MavenPublication>("library") {
            from(components["java"])
            version = "1.0.0"
            groupId = "demo"
            artifactId = "dokka-library-publishing-example"
            artifact(dokkaJavadocJar)
            artifact(dokkaHtmlJar)
        }
    }
}




