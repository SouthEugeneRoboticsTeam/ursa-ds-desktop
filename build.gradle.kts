import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "org.sert2521.mini-segway-ds"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile(fileTree("libs") {
        include("*.jar")
    })
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
