import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")

    id("org.springframework.boot")
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

allprojects {
    group = "com.m3o1"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java.sourceCompatibility = JavaVersion.VERSION_11
    dependencies {
        val mockkVersion: String by project
        val kotestVersion: String by project
        testImplementation("org.junit.jupiter:junit-jupiter")
        testImplementation("io.mockk:mockk:$mockkVersion")
        testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
        testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.getByName("bootRun") {
        enabled = false
    }

    tasks.getByName("bootJar") {
        enabled = false
        version = System.getenv("VERSION") ?: project.version
    }

    tasks.getByName("jar") {
        version = project.version
        enabled = true
        sourceSets {
            main {
                resources {
                    setSrcDirs(listOf("src/main/kotlin", "src/main/java"))
                    setIncludes(listOf("**/*.kt", "**/*.java"))
                }
                resources {
                    setSrcDirs(listOf("src/main/resources"))
                    setIncludes(listOf("**/*.*"))
                }
            }
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

configure(subprojects - project(":service-common")) {
    dependencies {
        implementation(project(":service-common"))
    }
}

tasks.getByName("bootRun") {
    enabled = false
}

tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}


configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}