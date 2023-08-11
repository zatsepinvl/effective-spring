package com.effective.spring

import org.quartz.Scheduler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class EffectiveSpringApplication

fun main(args: Array<String>) {
    val app = runApplication<EffectiveSpringApplication>(*args)

    val scheduler = app.getBean(Scheduler::class.java)
    println(scheduler)
}
