tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:recommendation-server:recommendation-core"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}