package pang.pangserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PangServerApplication

fun main(args: Array<String>) {
    runApplication<PangServerApplication>(*args)
}
