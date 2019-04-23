import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.3.30"))
    }
}

plugins {
    application
    kotlin("jvm") version "1.3.30"
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "io.github.wellingtoncosta"
version = "0.0.1"

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx")
}

application {
    mainClassName = "io.github.wellingtoncosta.javalin.sample.app.MainKt"
}

tasks.withType<Jar> {
    manifest {
        attributes(
            mapOf(
                "Main-Class" to application.mainClassName
            )
        )
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.javalin:javalin:2.8.0")
    implementation("org.jetbrains.exposed:exposed:0.12.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    implementation("org.koin:koin-core:1.0.2")
    implementation("com.zaxxer:HikariCP:3.3.0")
    implementation("org.slf4j:slf4j-simple:1.7.25")
    implementation("org.postgresql:postgresql:42.2.5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
