package com.example.pythonapp.bottom_navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.pythonapp.AccountInfoScreen
import com.example.pythonapp.R
import com.example.pythonapp.StudyScreen

var list = listOf(R.drawable.learn_icon, R.drawable.account_icon)

@Composable
fun Screen1(navHostController: NavHostController){
    StudyScreen(navController = navHostController)
}

@ExperimentalMaterial3Api
@Composable
fun Screen2(){
    AccountInfoScreen(R.drawable.account_icon, "User", list)
}