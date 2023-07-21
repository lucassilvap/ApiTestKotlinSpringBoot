package com.z.springkotln.service

import com.z.springkotln.dao.PersonDao
import com.z.springkotln.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonServiceImp(@Autowired private val personDao: PersonDao):PersonService {

    override fun findById(id: Long): Person? = this.findPersonById(id)

    override fun findAll(): List<Person> = this.personDao.findAll();

    override fun save(person: Person): Person {
        return this.saveOrUpdate(person)
    }

    override fun update(person: Person): Person {
        var person = this.findPersonById(person.id) ?: throw IllegalStateException("not found")
        return this.saveOrUpdate(person)
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }

    private fun findPersonById(id:Long):Person?=this.personDao.findByIdOrNull(id)

    private fun saveOrUpdate(person:Person):Person= this.personDao.save(person)
}