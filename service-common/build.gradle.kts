tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    implementation("org.springframework:spring-context")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}