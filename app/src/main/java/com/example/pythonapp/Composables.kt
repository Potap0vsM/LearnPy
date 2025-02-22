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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun StudyScreen(navController: NavController) {
    val themes = listOf(
        Theme(
            title = "Hello, World!",
            description = "Brief introduction to python",
            content = "The \"Hello, World!\" program is a simple script that displays the text \"Hello, World!\" on the screen. " +
                    "It's often the first program written when learning a new language, " +
                    "serving as an introduction to Python's syntax and the print() function.",
            question = "What function will help you output information?",
            correctAnswer = "print()"
        ),
        Theme(
            title = "Variables and Types",
            description = "What type of information can you use?",
            content = "In Python, variables are used to store data values and do not require explicit declaration. " +
                    "Python supports various data types, including integers, floats, and strings. For example:\n" +
                    "\n" +
                    "myint = 7\n" +
                    "myfloat = 7.0\n" +
                    "mystring = 'hello'\n" +
                    "\n" +
                    "Here, myint is an integer, myfloat is a float, and mystring is a string. " +
                    "You can perform operations like addition on numbers and concatenation on strings.",
            question = "What would be type of this character sequence: '81928'",
            correctAnswer = "String"
        ),
        Theme(
            title = "Lists",
            description = "How to store a lot of data in one line of code",
            content = "Lists in Python are ordered collections that can hold multiple items, which can be of different types. " +
                    "Lists are defined using square brackets:\n" +
                    "\n" +
                    "mylist = [1, 2, 3]\n" +
                    "You can access list items by index, starting at 0:\n" +
                    "\n" +
                    "print(mylist[0])  # Output: 1\n" +
                    "\n" +
                    "Lists are mutable, meaning you can change their content, such as adding new elements using the append() method:\n" +
                    "\n" +
                    "mylist.append(4)",
            question = "What function you will use to add something to a existing list?",
            correctAnswer = "append()"
        ),
        Theme(
            title = "Basic Operators",
            description = "Introduction to operators and math",
            content = "Python provides various operators for arithmetic and logical operations. " +
                    "Arithmetic operators include + (addition), - (subtraction), * (multiplication), / (division), and % (modulus), which returns the remainder of a division:\n" +
                    "\n" +
                    "remainder = 10 % 3  # remainder is 1\n" +
                    "\n" +
                    "Comparison operators like == (equal to), != (not equal to), > (greater than), and < (less than) are used to compare values.",
            question = "Which operator returns the integer remainder of the division.",
            correctAnswer = "%"
        ),
        Theme(
            title = "Conditions",
            description = "if-else conditions and some more operators",
            content = "Conditional statements allow you to execute code blocks based on certain conditions using if, elif, and else. " +
                    "The in operator checks if a value exists within a sequence, such as a list:\n" +
                    "\n" +
                    "name = \"Alice\"\n" +
                    "names = [\"Bob\", \"Charlie\", \"Alice\"]\n" +
                    "if name in names:\n" +
                    "    print(\"Found!\")\n" +
                    "\n" +
                    "This will output \"Found!\" because \"Alice\" is in the names list.",
            question = "Which operator would you use to know if your name is in a list of random names?",
            correctAnswer = "in"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                Text(text = "Start topic")
            }
        }
    }
}

@Composable
fun AccountInfoScreen(profilePictureRes: Int, userName: String, context: Context) {
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
        Text(text = userName, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Achievements", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
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
                AchievementCard(icon = R.drawable.first_lesson, text = "Starting strong!", description = "Finished first lesson")
            if (allLessonsUnlocked)
                AchievementCard(icon = R.drawable.trophey_icon, text = "Finished all!", description = "All lessons completed")
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
                .padding(top = 5.dp, bottom = 10.dp))
    }
}

@Composable
fun ThemeDetailScreen(theme: Theme, navController: NavController) {
    val context = LocalContext.current
    var answer by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
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
        Text(text = "Question:", fontSize = 18.sp, modifier = Modifier.padding(start = 8.dp, end = 8.dp), fontWeight = FontWeight.Bold)
        Text(text = "${theme.question} ", fontSize = 18.sp, modifier = Modifier.padding(start = 8.dp, end = 8.dp))
        TextField(value = answer, onValueChange = { answer = it }, label = { Text("Your answer") }, modifier = Modifier.fillMaxWidth().padding(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp)){
            Button(onClick = { navController.popBackStack() }) { Text(text = "Back") }
            Spacer(modifier = Modifier.width(128.dp))
            Button(onClick = {
                if (answer.equals(theme.correctAnswer, ignoreCase = true)) {
                    Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
                    saveAchievement(context, "${theme.title}_completed")
                    if (theme.title == "Hello, World!") {
                        saveAchievement(context, "first_lesson_completed")
                    }
                    if (checkAllLessonsCompleted(context)) saveAchievement(context, "all_lessons_completed")
                } else {
                    Toast.makeText(context, "Incorrect, try again.", Toast.LENGTH_SHORT).show()
                }
            }) { Text(text = "Check Answer") }
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