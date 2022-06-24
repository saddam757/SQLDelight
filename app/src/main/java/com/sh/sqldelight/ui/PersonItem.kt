package com.sh.sqldelight.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import sqldelight.persondb.Person

@Composable
fun PersonItem(
    person: Person,
    onClickItem: () -> Unit = {},
    onClickDelete: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.clickable { onClickItem() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = person.firstName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        IconButton(onClick = onClickDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }

    }

}