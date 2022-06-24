package com.sh.sqldelight.data.repository

import com.sh.sqldelight.PersonDatabase
import com.sh.sqldelight.domain.repository.PersonDataSource
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import sqldelight.persondb.Person

class PersonDataSourceImpl(
    db: PersonDatabase
) : PersonDataSource {

    private val queries = db.personQueries

    override suspend fun getPersonById(id: Long): Person? {
        return withContext(Dispatchers.IO) {
            queries.getPersonById(id).executeAsOneOrNull()
        }
    }

    override fun getAllPerson(): Flow<List<Person>> {
        return queries.getAllPerson().asFlow().mapToList()
    }

    override suspend fun deleteAllPerson() {
        return withContext(Dispatchers.IO) {
            queries.deleteAllPerson()
        }
    }


    override suspend fun insertPerson(id: Long?, firstName: String, lastName: String) {
        return withContext(Dispatchers.IO) {
            queries.insertPerson(id, firstName, lastName)
        }
    }

    override suspend fun deletePersonById(id: Long) {
        return withContext(Dispatchers.IO) {
            queries.deletePersonById(id)
        }
    }


}