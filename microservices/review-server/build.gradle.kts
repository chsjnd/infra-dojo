tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:review-server:review-core"))
    implementation(project(":microservices:review-server:review-web"))
}