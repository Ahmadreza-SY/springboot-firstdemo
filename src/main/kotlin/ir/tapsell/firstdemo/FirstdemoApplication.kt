package ir.tapsell.firstdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FirstdemoApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(FirstdemoApplication::class.java, *args)
}
