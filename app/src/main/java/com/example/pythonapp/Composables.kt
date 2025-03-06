package com.example.pythonapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun StudyScreen(navController: NavController) {
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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(770.dp)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppHeader()
        themes.forEach { theme ->
            ThemeCard(theme = theme, navController = navController)
        }
    }
}

@Composable
fun AppHeader() {
    Text(
        text = "Learn Python",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun ThemeCard(theme: Theme, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = theme.title, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
            Text(text = theme.description, fontSize = 16.sp)
            Button(onClick = { navController.navigate("themeDetail/${theme.title}") }) {
                Text(text = stringResource(id = R.string.button))
            }
        }
    }
}

@Composable
fun AccountInfoScreen(profilePictureRes: Int, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppHeader()
        Image(
            painter = painterResource(id = profilePictureRes),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.user), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.achievements), fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(8.dp))
        AchievementsRow(context)
    }
}

@Composable
fun AchievementsRow(context: Context) {
    val firstLessonUnlocked = isAchievementUnlocked(context, "first_lesson_completed")
    val allLessonsUnlocked = isAchievementUnlocked(context, "all_lessons_completed")
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(500.dp)){
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            if (firstLessonUnlocked)
                AchievementCard(icon = R.drawable.first_lesson, text = stringResource(id = R.string.achievement_first), description = "Finished first lesson")
            if (allLessonsUnlocked)
                AchievementCard(icon = R.drawable.trophey_icon, text = stringResource(id = R.string.achievement_second), description = "All lessons completed")
        }

    }
}

@Composable
fun AchievementCard(icon: Int, text: String, description: String){
    Card(modifier = Modifier
        .padding(5.dp)
        .size(100.dp)
        .padding(top = 5.dp, start = 5.dp), colors = CardDefaults.cardColors(
        containerColor = Color(0xFF90EE90))) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = description,
            modifier = Modifier
                .size(70.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 5.dp)
        )
        Text(text = text, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 5.dp, bottom = 5.dp))
    }
}

@Composable
fun ThemeDetailScreen(theme: Theme, navController: NavController) {
    val context = LocalContext.current
    var answer by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(765.dp)
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        Text(text = theme.title, fontSize = 32.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, modifier = Modifier
            .padding(top = 10.dp)
            .align(alignment = Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ){
            Text(text = theme.content, fontSize = 18.sp, modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = stringResource(id = R.string.question), fontSize = 18.sp, modifier = Modifier.padding(start = 8.dp, end = 8.dp), fontWeight = FontWeight.Bold)

        Text(text = "${theme.questionOne} ", fontSize = 18.sp, modifier = Modifier.padding(start = 8.dp, end = 8.dp))
        TextField(value = answer, onValueChange = { answer = it }, label = { Text(stringResource(id = R.string.answer)) }, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp)){
            Spacer(modifier = Modifier.width(180.dp))
            Button(onClick = {
                if (answer.lowercase().equals(theme.correctAnswerOne.lowercase(), ignoreCase = true)) {
                    Toast.makeText(context, context.getString(R.string.correct), Toast.LENGTH_SHORT).show()
                    saveAchievement(context, "${theme.title}_completed")
                    if (theme.title == "Hello, World!") {
                        saveAchievement(context, "first_lesson_completed")
                    }
                    if (checkAllLessonsCompleted(context)) saveAchievement(context, "all_lessons_completed")
                } else {
                    Toast.makeText(context, context.getString(R.string.wrong) + theme.correctAnswerOne, Toast.LENGTH_SHORT).show()
                }
            }) { Text(text = stringResource(id = R.string.button_check)) }
        }

        Text(text = "${theme.questionTwo} ", fontSize = 18.sp, modifier = Modifier.padding(start = 8.dp, end = 8.dp))
        TextField(value = answer, onValueChange = { answer = it }, label = { Text(stringResource(id = R.string.answer)) }, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp)){
            Spacer(modifier = Modifier.width(180.dp))
            Button(onClick = {
                if (answer.lowercase().equals(theme.correctAnswerTwo.lowercase(), ignoreCase = true)) {
                    Toast.makeText(context, context.getString(R.string.correct), Toast.LENGTH_SHORT).show()
                    saveAchievement(context, "${theme.title}_completed")
                    if (theme.title == "Hello, World!") {
                        saveAchievement(context, "first_lesson_completed")
                    }
                    if (checkAllLessonsCompleted(context)) saveAchievement(context, "all_lessons_completed")
                } else {
                    Toast.makeText(context, context.getString(R.string.wrong) + theme.correctAnswerTwo, Toast.LENGTH_SHORT).show()
                }
            }) { Text(text = stringResource(id = R.string.button_check)) }
        }

        Text(text = "${theme.questionThree} ", fontSize = 18.sp, modifier = Modifier.padding(start = 8.dp, end = 8.dp))
        TextField(value = answer, onValueChange = { answer = it }, label = { Text(stringResource(id = R.string.answer)) }, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp)){
            Button(onClick = { navController.popBackStack() }) { Text(text = stringResource(id = R.string.button_back)) }
            Spacer(modifier = Modifier.width(128.dp))
            Button(onClick = {
                if (answer.lowercase().equals(theme.correctAnswerThree.lowercase(), ignoreCase = true)) {
                    Toast.makeText(context, context.getString(R.string.correct), Toast.LENGTH_SHORT).show()
                    saveAchievement(context, "${theme.title}_completed")
                    if (theme.title == "Hello, World!") {
                        saveAchievement(context, "first_lesson_completed")
                    }
                    if (checkAllLessonsCompleted(context)) saveAchievement(context, "all_lessons_completed")
                } else {
                    Toast.makeText(context, context.getString(R.string.wrong) + theme.correctAnswerThree, Toast.LENGTH_SHORT).show()
                }
            }) { Text(text = stringResource(id = R.string.button_check)) }
        }
    }
}

fun saveAchievement(context: Context, key: String) {
    val prefs = context.getSharedPreferences("achievements", Context.MODE_PRIVATE)
    prefs.edit().putBoolean(key, true).apply()
}

fun isAchievementUnlocked(context: Context, key: String): Boolean {
    val prefs = context.getSharedPreferences("achievements", Context.MODE_PRIVATE)
    return prefs.getBoolean(key, false)
}

fun checkAllLessonsCompleted(context: Context): Boolean {
    val prefs = context.getSharedPreferences("achievements", Context.MODE_PRIVATE)
    val lessons = listOf("Hello, World!_completed", "Variables and Types_completed", "Lists_completed", "Basic Operators_completed", "Conditions_completed")
    return lessons.all { prefs.getBoolean(it, false) }
}