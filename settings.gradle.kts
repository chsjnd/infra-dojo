// 최상위 프로젝트 이름
rootProject.name = "dojo"

// Multi-Module Projects으로 구성하는 경우,
// Sub Module Porject들의 이름
include(
    "service-common",
    "microservices:microservice-interface",

    "microservices:product-composite-server:product-composite-web",
    "microservices:product-composite-server:product-composite-internal-api",
    "microservices:product-composite-server:product-composite-core",

    "microservices:product-server:product-web",
    "microservices:product-server:product-persistence",
    "microservices:product-server:product-core",

    "microservices:recommendation-server:recommendation-web",
    "microservices:recommendation-server:recommendation-persistence",
    "microservices:recommendation-server:recommendation-core",

    "microservices:review-server:review-web",
    "microservices:review-server:review-persistence",
    "microservices:review-server:review-core",
)

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
            }
        }
    }
}