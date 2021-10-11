package org.sid.echallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2

class EChallengeApplication

fun main(args: Array<String>) {
    runApplication<EChallengeApplication>(*args)
}
