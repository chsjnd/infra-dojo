tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:review-server:review-core"))
    implementation(project(":microservices:review-server:review-web"))
}