package com.example.myjornalfirebase.views.notes

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myjornalfirebase.viewModel.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteView(navController: NavController, notesViewModel: NotesViewModel, idDoc: String) {
    LaunchedEffect(Unit) {
        notesViewModel.getNoteById(idDoc)
    }
    val state = notesViewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Edit Note") },
                navigationIcon = {
                    IconButton(onClick = {

                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }

                },
                actions = {
                    IconButton(onClick = {
                        notesViewModel.deleteNote(idDoc) {
                            navController.popBackStack()
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription ="Delete" )
                    }
                    IconButton(onClick = {
                        notesViewModel.updateNote(idDoc) {
     navController.popBackStack()
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },

                )

        }
    ) { pad ->
        Column(
            modifier = Modifier
                .padding(pad)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally


        ) {

            OutlinedTextField(
                value = state.title,
                onValueChange = {
                    notesViewModel.onValue(it, "title")
                },
                label = { Text(text = "Title") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            )

            OutlinedTextField(
                value = state.note,
                onValueChange = {
                    notesViewModel.onValue(it, "note")
                },
                label = { Text(text = "Note") },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            )
        }


    }
}
