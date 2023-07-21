package com.z.springkotln.dao

import com.z.springkotln.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao: JpaRepository<Person, Long> {

}