package jko.springdatajpapaging

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book(

    @Id @GeneratedValue
    val id: Long,

    val name: String
)
