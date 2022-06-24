package com.sh.sqldelight.domain.repository

import kotlinx.coroutines.flow.Flow
import sqldelight.persondb.Person

interface PersonDataSource {

    suspend fun getPersonById(id: Long): Person?

    fun getAllPerson(): Flow<List<Person>>

    suspend fun deleteAllPerson()

    suspend fun insertPerson(id: Long? = null, firstName: String, lastName: String)

    suspend fun deletePersonById(id: Long)


}