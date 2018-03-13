package org.jetbrains.kotlin.demo.controller

import org.jetbrains.kotlin.demo.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

  val counter = AtomicLong()

  @GetMapping("/greeting-from-package")
  fun greeting() =
      Greeting(counter.incrementAndGet(), "Hello from a package")

}