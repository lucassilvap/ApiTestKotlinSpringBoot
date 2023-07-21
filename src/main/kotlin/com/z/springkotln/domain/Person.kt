package com.z.springkotln.domain

import jakarta.persistence.*

@Entity
class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id:Long,
    val name:String="",
    val lastName:String?=null) {
}