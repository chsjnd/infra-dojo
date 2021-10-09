tasks.getByName("bootRun") {
    enabled = true
}

tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:review-server:review-core"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}