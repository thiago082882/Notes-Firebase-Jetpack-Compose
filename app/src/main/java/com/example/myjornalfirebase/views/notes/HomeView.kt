package com.example.myjornalfirebase.views.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myjornalfirebase.components.CardNote
import com.example.myjornalfirebase.viewModel.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, notesViewModel: NotesViewModel) {

    LaunchedEffect(Unit){
        notesViewModel.fetchNotes()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My Notes")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        notesViewModel.signOut()
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "")
                        
                    }
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate("AddNoteView")
                    }) {

                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    }
                }

                )
        }
    ) {
        Column(
            modifier = Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           val dates by notesViewModel.notesData.collectAsState()

            LazyColumn{
                items(dates){ item->
                  CardNote(title = item.title, note = item.note, date =item.date ) {

                      navController.navigate("EditNoteView/${item.idDoc}")
                      
                  }
                }
            }
        }
    }
}