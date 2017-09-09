import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val KOTLIN_VER = "1.1.4-3"
val VERTX_VER = "3.4.2"
val MAIN_VERTICLE = "org.example.vertxwebservices.Server"
val MAIN_CLASS = "io.vertx.core.Launcher"
val WATCH_FOR_CHANGE = "src/**/*.kt"
val WATCHER_ACTION = "./gradlew classes"

group = "org.example"
version = "0.1-SNAPSHOT"

plugins {
    kotlin(module = "jvm", version = "1.1.4-3")
    application
}

application { mainClassName = MAIN_CLASS }

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:$KOTLIN_VER")
    compile("io.vertx:vertx-core:$VERTX_VER")
    compile("io.vertx:vertx-lang-kotlin:$VERTX_VER")
    compile("io.vertx:vertx-web:$VERTX_VER")
}

val run: JavaExec by tasks
val compileKotlin: KotlinCompile by tasks

run.args(
    "run",
    MAIN_VERTICLE,
    "--redeploy=$WATCH_FOR_CHANGE",
    "--launcher-class=$MAIN_CLASS",
    "--on-redeploy=$WATCHER_ACTION"
)

with(compileKotlin) {
    kotlinOptions.jvmTarget = "1.8"
    doLast { println("Finished compiling.") }
}
