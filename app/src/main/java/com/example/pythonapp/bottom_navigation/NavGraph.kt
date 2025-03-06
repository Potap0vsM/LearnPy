package com.example.pythonapp.bottom_navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pythonapp.R
import com.example.pythonapp.Theme
import com.example.pythonapp.ThemeDetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    navHostController: NavHostController
){
    val themes = listOf(
        Theme(
            title = stringResource(id = R.string.first_topic),
            description = stringResource(id = R.string.first_descrip),
            content = stringResource(id = R.string.first_content),
            questionOne = stringResource(id = R.string.first_question_one),
            questionTwo = stringResource(id = R.string.first_question_two),
            questionThree = stringResource(id = R.string.first_question_three),
            correctAnswerOne = "print()",
            correctAnswerTwo = "Hello, World!",
            correctAnswerThree = "syntax error"
        ),
        Theme(
            title = stringResource(id = R.string.second_topic),
            description = stringResource(id = R.string.second_descrip),
            content = stringResource(id = R.string.second_content),
            questionOne = stringResource(id = R.string.second_question_one),
            questionTwo = stringResource(id = R.string.second_question_two),
            questionThree = stringResource(id = R.string.second_question_three),
            correctAnswerOne = "String",
            correctAnswerTwo = "Float",
            correctAnswerThree = "Boolean"
        ),
        Theme(
            title = stringResource(id = R.string.third_topic),
            description = stringResource(id = R.string.third_descrip),
            content = stringResource(id = R.string.third_content),
            questionOne = stringResource(id = R.string.third_question_one),
            questionTwo = stringResource(id = R.string.third_question_two),
            questionThree = stringResource(id = R.string.third_question_three),
            correctAnswerOne = "append()",
            correctAnswerTwo = "3",
            correctAnswerThree = "remove()"
        ),
        Theme(
            title = stringResource(id = R.string.fourth_topic),
            description = stringResource(id = R.string.fourth_descrip),
            content = stringResource(id = R.string.fourth_content),
            questionOne = stringResource(id = R.string.fourth_question_one),
            questionTwo = stringResource(id = R.string.fourth_question_two),
            questionThree = stringResource(id = R.string.fourth_question_three),
            correctAnswerOne = "%",
            correctAnswerTwo = "True",
            correctAnswerThree = "9"
        ),
        Theme(
            title = stringResource(id = R.string.fifth_topic),
            description = stringResource(id = R.string.fifth_descrip),
            content = stringResource(id = R.string.fifth_content),
            questionOne = stringResource(id = R.string.fifth_question_one),
            questionTwo = stringResource(id = R.string.fifth_question_two),
            questionThree = stringResource(id = R.string.fifth_question_three),
            correctAnswerOne = "in",
            correctAnswerTwo = "'Found!'",
            correctAnswerThree = "Nothing"
        )
    )
    NavHost(navController = navHostController, startDestination = "study") {
        composable("study"){
            Screen1(navHostController)
        }
        composable("account"){
            Screen2()
        }
        composable("themeDetail/{themeTitle}") { backStackEntry ->
            val themeTitle = backStackEntry.arguments?.getString("themeTitle")
            val theme = themes.find { it.title == themeTitle }
            if (theme != null) {
                ThemeDetailScreen(theme, navHostController)
            }
        }
    }
}