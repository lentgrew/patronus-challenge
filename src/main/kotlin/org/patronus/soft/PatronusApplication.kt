package org.patronus.soft

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing


@ConfigurationPropertiesScan
@EnableJpaAuditing
@SpringBootApplication
class PatronusApplication

fun main(args: Array<String>) {
    runApplication<PatronusApplication>(*args)
}