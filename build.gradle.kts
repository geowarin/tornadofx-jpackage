import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.github.siordache-forks:javafx-gradle-plugin:0.0.9-rc1")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    application
//  id("org.openjfx.javafxplugin") version "0.0.8"
    id("org.beryx.jlink") version "2.19.0"
}

apply<org.openjfx.gradle.JavaFXPlugin>()

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileJava.destinationDir = compileKotlin.destinationDir

repositories {
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    implementation("com.github.edvin:tornadofx2:master")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testImplementation("org.testfx:testfx-core:4.0.16-alpha")
}

application {
    mainClassName = "com.example.demo.app.MyAppKt"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "13"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "13"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

configure<org.openjfx.gradle.JavaFXOptions> {
    version = "14"
    modules("javafx.base", "javafx.graphics", "javafx.controls", "javafx.web", "javafx.swing", "javafx.fxml")
}

//javafx {
//  version = "14"
//  modules("javafx.base", "javafx.graphics", "javafx.controls", "javafx.web", "javafx.swing", "javafx.fxml")
//}

jlink {
    launcher {
        name = "hello"
    }
    imageZip.set(project.file("${project.buildDir}/image-zip/hello-image.zip"))
}