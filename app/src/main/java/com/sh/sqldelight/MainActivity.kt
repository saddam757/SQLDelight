package com.sh.sqldelight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sh.sqldelight.ui.PersonListScreen
import com.sh.sqldelight.ui.theme.SQLDelightTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SQLDelightTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Person()
                }
            }
        }
    }
}

@Composable
fun Person() {
    PersonListScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SQLDelightTheme {
        Person()
    }
}