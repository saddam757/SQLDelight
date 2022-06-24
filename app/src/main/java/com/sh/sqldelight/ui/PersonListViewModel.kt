package com.sh.sqldelight.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sh.sqldelight.domain.repository.PersonDataSource
import kotlinx.coroutines.launch
import sqldelight.persondb.Person

class PersonListViewModel(
    private val personDataSource: PersonDataSource
) : ViewModel() {

    val personList = personDataSource.getAllPerson()

    var personDetails by mutableStateOf<Person?>(null)
        private set

    var firstNameText by mutableStateOf("")
        private set

    var lastNameText by mutableStateOf("")

    fun onClickInsertPerson() {

        if (firstNameText.isBlank() || lastNameText.isBlank()) {
            return
        }

        viewModelScope.launch {

            personDataSource.insertPerson(firstName = firstNameText, lastName = lastNameText)

            firstNameText = ""
            lastNameText = ""
        }
    }

    fun onClickDeletePerson(id: Long) {
        viewModelScope.launch {
            personDataSource.deletePersonById(id)
        }
    }

    fun onClickAllDeletePerson() {
        viewModelScope.launch {
            personDataSource.deleteAllPerson()
        }
    }

    fun getPersonById(id: Long) {

        viewModelScope.launch {
            personDetails = personDataSource.getPersonById(id)
        }

    }

    fun onFirstNameChange(name: String) {

        firstNameText = name
    }

    fun onLastNameChange(name: String) {

        lastNameText = name
    }

    fun onPersonDetailsDialogDismiss() {
        personDetails = null
    }
}