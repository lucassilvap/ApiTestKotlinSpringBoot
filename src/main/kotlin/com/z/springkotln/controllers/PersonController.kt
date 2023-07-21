package com.z.springkotln.controllers

import com.z.springkotln.domain.Person
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @GetMapping
    fun hi(): Person {
        return Person(1, "Lucas", "Pessoa");
    }
}