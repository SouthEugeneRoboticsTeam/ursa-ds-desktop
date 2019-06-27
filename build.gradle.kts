import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.31"
    application
}

group = "org.sert2521.mini-segway-ds"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    //compile("org.openjfx", "javafx", "11", ext = "pom")
    compile("no.tornado", "tornadofx", "1.7.19")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "org.sert2521.minisegwayds.MainKt"
}
