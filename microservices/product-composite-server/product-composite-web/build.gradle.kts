tasks.getByName("bootRun") {
    enabled = true
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":microservices:product-composite-server:product-composite-core"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}