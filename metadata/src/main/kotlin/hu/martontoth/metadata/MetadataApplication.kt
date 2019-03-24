package hu.martontoth.metadata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MetadataApplication

fun main(args: Array<String>) {
    runApplication<MetadataApplication>(*args)
}
