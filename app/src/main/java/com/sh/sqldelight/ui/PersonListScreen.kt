package com.sh.sqldelight.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.koin.androidx.compose.koinViewModel

@Composable
fun PersonListScreen(
    viewModel: PersonListViewModel = koinViewModel()
) {

    val persons by viewModel.personList.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Person List") },
                navigationIcon = {
                    IconButton(onClick = viewModel::onClickAllDeletePerson) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                    }
                })
        }
    ) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Column(modifier = Modifier.fillMaxSize()) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    items(persons) { person ->

                        PersonItem(
                            person = person,
                            onClickItem = {
                                viewModel.getPersonById(person.id)
                            },
                            onClickDelete = {
                                viewModel.onClickDeletePerson(person.id)
                            },
                            modifier = Modifier.fillMaxWidth()
                        )

                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextField(
                        value = viewModel.firstNameText,
                        onValueChange = viewModel::onFirstNameChange,
                        placeholder = {
                            Text(
                                text = "First name"
                            )
                        },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    TextField(
                        value = viewModel.lastNameText,
                        onValueChange = viewModel::onLastNameChange,
                        placeholder = {
                            Text(
                                text = "Last name"
                            )
                        },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    IconButton(onClick = viewModel::onClickInsertPerson) {
                        Icon(imageVector = Icons.Default.Done, contentDescription = "Done")
                    }
                }

            }
            viewModel.personDetails?.let { details ->
                Dialog(onDismissRequest = viewModel::onPersonDetailsDialogDismiss) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "${details.firstName} ${details.lastName}")
                    }
                }
            }

        }

    }

}