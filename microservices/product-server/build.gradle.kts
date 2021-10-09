tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:product-server:product-core"))
    implementation(project(":microservices:product-server:product-web"))
}