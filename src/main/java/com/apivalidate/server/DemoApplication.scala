package com.apivalidate.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class DemoApplication {}
object DemoApplication extends App {
  SpringApplication.run(classOf[DemoApplication])


}
