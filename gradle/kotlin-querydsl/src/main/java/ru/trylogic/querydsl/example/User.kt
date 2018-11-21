package ru.trylogic.querydsl.example

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
    val name: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int = 0)