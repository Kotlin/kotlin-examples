subprojects {
    repositories {
        mavenCentral()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-dev")
    }

    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation(kotlin("test-junit"))
    }
}

