tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    implementation(project(":microservices:product-composite-server:product-composite-core"))
    implementation(project(":microservices:product-composite-server:product-composite-web"))
}