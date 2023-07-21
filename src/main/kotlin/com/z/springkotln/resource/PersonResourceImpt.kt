package com.z.springkotln.resource

import com.z.springkotln.domain.Person
import com.z.springkotln.resource.PersonResourceImpt.Companion.BASE_PERSON_URL
import com.z.springkotln.service.PersonService
import org.aspectj.weaver.patterns.PerObject
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value=[BASE_PERSON_URL])
class PersonResourceImpt(private val personService: PersonService):PersonResource {


    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<Person> {
        val Person = personService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Person);
    }

    @GetMapping
    override fun findAll(): ResponseEntity<List<Person>> {
        return ResponseEntity.ok(personService.findAll())
    }

    @PostMapping
    override fun save(@RequestBody person: Person): ResponseEntity<Person> {
       var Person = personService.save(person);
        return ResponseEntity.status(HttpStatus.OK).body(Person);
    }

    @PutMapping
    override fun update(@RequestBody personUpdate: Person): ResponseEntity<Person> {
        return ResponseEntity.ok(personService.update(personUpdate))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        personService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}