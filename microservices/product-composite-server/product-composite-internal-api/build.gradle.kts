dependencies {
    api(project(":microservices:microservice-interface"))
    implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-context")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}