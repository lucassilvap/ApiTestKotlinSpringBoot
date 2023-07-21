package com.z.springkotln.resource

import com.z.springkotln.domain.Person
import org.springframework.http.ResponseEntity

interface PersonResource {

    fun findById(id:Long):ResponseEntity<Person>
    fun findAll():ResponseEntity<List<Person>>
    fun save(person:Person):ResponseEntity<Person>
    fun update(personUpdate:Person):ResponseEntity<Person>
    fun deleteById(id:Long):ResponseEntity<Unit>

}