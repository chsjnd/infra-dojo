tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:recommendation-server:recommendation-core"))
    implementation(project(":microservices:recommendation-server:recommendation-web"))
}