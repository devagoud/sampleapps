package com.kotlin.demo.deomapplications.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.kotlin.demo.deomapplications.domain")
@EntityScan("com.kotlin.demo.deomapplications.domain")
@ComponentScan(value = "com.kotlin.demo.deomapplications")
class DeomapplicationsApplication:SpringBootServletInitializer()

    fun main(args: Array<String>) {
        runApplication<DeomapplicationsApplication>(*args)
    }

class BootConfig:SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder?): SpringApplicationBuilder {
        return SpringApplicationBuilder().sources(DeomapplicationsApplication::class.java)
    }
}

