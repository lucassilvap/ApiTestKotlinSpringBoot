package com.z.springkotln.service

import com.z.springkotln.domain.Person

interface PersonService {
    fun findById(id:Long):Person?
    fun findAll():List<Person>
    fun save(addPersonRequest: Person):Person
    fun update(updatePersonRequest: Person): Person
    fun deleteById(id:Long)
}