package com.example.myjornalfirebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myjornalfirebase.viewModel.LoginViewModel
import com.example.myjornalfirebase.viewModel.NotesViewModel
import com.example.myjornalfirebase.views.login.BlankView
import com.example.myjornalfirebase.views.login.TabsView
import com.example.myjornalfirebase.views.notes.AddNotesView
import com.example.myjornalfirebase.views.notes.EditNoteView
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

        composable("EditNoteView/{idDoc}", arguments = listOf(
            navArgument("idDoc"){ type = NavType.StringType }
        )){
            val idDoc = it.arguments?.getString("idDoc") ?: ""
           EditNoteView(navController = navController, notesViewModel = notesViewModel, idDoc =idDoc )
        }
    }

}