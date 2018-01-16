package com.jalgoarena

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableConfigurationProperties
open class JAlgoArenaAuthServer {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(JAlgoArenaAuthServer::class.java, *args)
        }
    }

    @Bean
    open fun authApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(apiKey())
    }

    private fun apiKey(): ApiKey {
        return ApiKey("authkey", "Authorization", "header")
    }
}


