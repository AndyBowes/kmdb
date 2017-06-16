package co.jfactory

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KmdbApplication

fun main(args: Array<String>) {
    SpringApplication.run(KmdbApplication::class.java, *args)
}
