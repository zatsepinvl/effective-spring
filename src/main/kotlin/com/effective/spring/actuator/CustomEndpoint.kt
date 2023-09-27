package com.effective.spring.actuator

import org.springframework.boot.actuate.endpoint.annotation.Endpoint
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation
import org.springframework.stereotype.Component

@Component
@Endpoint(id = "custom")
class CustomEndpoint {

    @ReadOperation
    fun operation(): String {
        return "read"
    }

    @WriteOperation
    fun writeOperation() {
        println("write")
    }
}