import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    id("org.graalvm.buildtools.native") version "0.9.23"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.effective"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springBootAdminVersion"] = "3.1.1"

dependencies {
    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Security
    // implementation("org.springframework.boot:spring-boot-starter-security")
    // Data JDBC
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    // Kotlin support
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")


    // Quartz
    implementation("org.springframework.boot:spring-boot-starter-quartz")
    // Admin
    implementation("de.codecentric:spring-boot-admin-starter-client")
    implementation("de.codecentric:spring-boot-admin-starter-server")
    // Actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    // Micrometer
    implementation("io.micrometer:micrometer-tracing-bridge-otel")

    // H2
    runtimeOnly("com.h2database:h2")
    // Prometheus
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    // JMX
    runtimeOnly("io.micrometer:micrometer-registry-jmx")

    // Annotation Processor
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // DevTools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Spring Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
    imports {
        mavenBom("de.codecentric:spring-boot-admin-dependencies:${property("springBootAdminVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
