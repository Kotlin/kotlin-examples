import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

kotlin {
    targets {
        val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget

        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true) {
            iosTarget = ::iosArm64    // Real device
        } else {
            iosTarget = ::iosX64    // iOS emulator
        }

        iosTarget("iOS") {
            binaries {
                framework("SharedCode")
            }
        }

        jvm("android")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlin:kotlin-stdlib-common")
            }
        }
        val androidMain by getting {
            dependencies {
                api("org.jetbrains.kotlin:kotlin-stdlib")
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations.create("compileClasspath")

tasks.register<Sync>("packForXCode") {
    val frameworkDir = File(buildDir, "xcode-frameworks")

    val property = project.findProperty("XCODE_CONFIGURATION") as String?
    val mode = property?.toUpperCase() ?: "DEBUG"

    val target = kotlin.targets.getByName("iOS") as KotlinNativeTarget
    val framework = target.binaries.getFramework("SharedCode", mode)

    inputs.property("mode", mode)
    dependsOn(framework.linkTask)

    from(framework.outputFile.parentFile)
    into(frameworkDir)

    doLast {
        val file = File(frameworkDir, "gradlew")
        file.writeText("""
            #!/bin/bash
            export 'JAVA_HOME=${System.getProperty("java.home")}'
            cd '${rootProject.rootDir}'
            ./gradlew $@
        """.trimIndent())
        file.setExecutable(true)
    }
}
tasks.getByName("build").dependsOn("packForXCode")
