plugins {
  id("org.jetbrains.kotlin.jvm") version "1.3.72"
  application
  id("org.openjfx.javafxplugin") version "0.0.8"
}

repositories {
  jcenter()
  maven("https://jitpack.io")
}

dependencies {
  // Align versions of all Kotlin components
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
//  implementation("no.tornado:tornadofx:1.7.20")
  implementation("com.github.edvin:tornadofx2:master")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  testImplementation("org.jetbrains.kotlin:kotlin-test")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.2")
  testImplementation("org.skyscreamer:jsonassert:1.5.0")
  testImplementation("org.testfx:testfx-core:4.0.16-alpha")
  testImplementation("com.google.jimfs:jimfs:1.1")
}

application {
  // Define the main class for the application.
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

javafx {
  version = "13"
  modules("javafx.base", "javafx.graphics", "javafx.controls", "javafx.web")
}