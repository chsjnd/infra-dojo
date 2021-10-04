// 최상위 프로젝트 이름
rootProject.name = "dojo"

// Multi-Module Projects으로 구성하는 경우,
// Sub Module Porject들의 이름
include(
    "microservices:product-composite-server",
    "microservices:product-server",
    "microservices:recommendation-server",
    "microservices:review-server"
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