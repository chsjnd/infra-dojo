tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:product-server:product-core"))
    implementation(project(":microservices:product-server:product-web"))
}