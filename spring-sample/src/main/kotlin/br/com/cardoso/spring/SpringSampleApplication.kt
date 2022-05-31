package br.com.cardoso.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration
import org.springframework.boot.runApplication
@SpringBootApplication(exclude = [SpringDataWebAutoConfiguration::class], proxyBeanMethods = false)
class SpringSampleApplication
fun main(args: Array<String>) {
    runApplication<SpringSampleApplication>(*args)
}
