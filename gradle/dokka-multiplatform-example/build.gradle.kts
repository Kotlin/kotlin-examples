import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType


plugins {
    kotlin("multiplatform") version "1.3.50"
    id("org.jetbrains.dokka") version "0.10.0"
}

repositories {
    jcenter()
    mavenLocal()
}

group = "org.test"
version = "1.0-SNAPSHOT"

kotlin {
    jvm() // Create a JVM target with the default name "jvm"
    js()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val jsMain by getting {
            dependencies{
                implementation("org.jetbrains.kotlin:kotlin-stdlib-js")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0-RC2")
            }
        }
    }
}

tasks {
    val dokka by getting(DokkaTask::class) {
        outputDirectory = "$buildDir/dokka"
        outputFormat = "html"

        multiplatform {
            val js by creating {} // this platform uses autoconfiguration. Sources are fetched from kotlin-multiplatform plugin

            register("customName") { // or `val customName by creating {}`. The name is different than `jvm` in Kotlin plugin, so
                                           // sourceRoots, classpath, platform and targets must be passed explicitly
                targets = listOf("JVM")
                platform = "jvm"
                sourceRoot {
                    path = kotlin.sourceSets.getByName("jvmMain").kotlin.srcDirs.first().toString()
                }
                sourceRoot {
                    path = kotlin.sourceSets.getByName("commonMain").kotlin.srcDirs.first().toString()
                }

                // we don't use autoconfiguration for this platform so we need to pass the classpath manually
                // otherwise we'll end up with <ERROR CLASS> markers
                classpath = kotlin.targets
                    .filter { it.platformType == KotlinPlatformType.common || it.platformType == KotlinPlatformType.jvm }
                    .flatMap { it.compilations.getByName("main").compileDependencyFiles.files.map { file -> file.path } }
            }
            
            register("common") {} // or `val common by creating {}`, this platform uses autoconfiguration

            register("global") {  // or `val global by creating {}`, this is a special block for passing perPackageOptions,
                                        // externalDocumentationLinks and sourceLinks to all other platforms
                perPackageOption { // suppress a package on all platforms
                    prefix = "shouldbesuppressed"
                    suppress = true
                }
            }
        }
    }
}