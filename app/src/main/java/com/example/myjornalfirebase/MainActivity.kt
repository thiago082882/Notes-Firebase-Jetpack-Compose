package com.example.myjornalfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myjornalfirebase.navigation.NavManager
import com.example.myjornalfirebase.ui.theme.MyJornalFirebaseTheme
import com.example.myjornalfirebase.viewModel.LoginViewModel
import com.example.myjornalfirebase.viewModel.NotesViewModel
import com.example.myjornalfirebase.views.login.TabsView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginViewModel : LoginViewModel by viewModels()
        val notesViewModel : NotesViewModel by viewModels()

        setContent {
            MyJornalFirebaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  NavManager(loginViewModel = loginViewModel, notesViewModel = notesViewModel)
                }
            }
        }
    }
}
