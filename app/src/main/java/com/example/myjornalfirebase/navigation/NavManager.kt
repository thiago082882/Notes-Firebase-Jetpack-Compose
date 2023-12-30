package com.example.myjornalfirebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjornalfirebase.viewModel.LoginViewModel
import com.example.myjornalfirebase.viewModel.NotesViewModel
import com.example.myjornalfirebase.views.login.BlankView
import com.example.myjornalfirebase.views.login.TabsView
import com.example.myjornalfirebase.views.notes.AddNotesView
import com.example.myjornalfirebase.views.notes.HomeView

@Composable
fun NavManager(loginViewModel: LoginViewModel,notesViewModel: NotesViewModel) {
    
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Blank" ){

        composable("Blank"){
           BlankView(navController)
        }

        composable("Login"){
            TabsView(navController,loginViewModel)
        }
        composable("Home"){
            HomeView(navController,notesViewModel)
        }

        composable("AddNoteView"){
            AddNotesView(navController = navController, notesViewModel = notesViewModel)
        }
    }

}