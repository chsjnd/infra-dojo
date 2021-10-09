tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:recommendation-server:recommendation-core"))
    implementation(project(":microservices:recommendation-server:recommendation-web"))
}