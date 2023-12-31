package com.example.myjornalfirebase.views.notes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.myjornalfirebase.viewModel.NotesViewModel

@Composable
fun EditNoteView(navController: NavController, notesViewModel: NotesViewModel,idDoc :String) {
    LaunchedEffect( Unit){
        notesViewModel.getNoteById(idDoc)
    }
    val state = notesViewModel.state
    Text(text = state.title)
}