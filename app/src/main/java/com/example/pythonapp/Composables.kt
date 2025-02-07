package com.example.pythonapp

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun StudyScreen(navController: NavController) {
    val themes = listOf(
        Theme(
            title = "Hello, World!",
            content = ".",
            question = "What function will help you output information?",
            correctAnswer = "print()"
        ),
        Theme(
            title = "Variables and Types",
            content = ".",
            question = "What would be type of this character sequence: '81928'",
            correctAnswer = "String'"
        ),
        Theme(
            title = "Lists",
            content = ".",
            question = "What function you will use to add something to a existing list?",
            correctAnswer = "append()"
        ),
        Theme(
            title = "Basic Operators",
            content = ".",
            question = "Which operator returns the integer remainder of the division.",
            correctAnswer = "%"
        ),
        Theme(
            title = "Conditions",
            content = ".",
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
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = theme.title, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
            Button(onClick = { navController.navigate("themeDetail/${theme.title}") }) {
                Text(text = "Start topic")
            }
        }
    }
}

@Composable
fun AccountInfoScreen(
    profilePictureRes: Int,
    userName: String,
    achievements: List<Int>
) {
    MaterialTheme{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppHeader()
            // Profile Picture
            Image(
                painter = painterResource(id = profilePictureRes),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // User Name
            Text(
                text = userName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Achievements Gallery
            Text(
                text = "Achievements",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(achievements) { achievementRes ->
                    Image(
                        painter = painterResource(id = achievementRes),
                        contentDescription = "Achievement Icon",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.LightGray),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ThemeDetailScreen(theme: Theme, navController: NavController) {
    var answer by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = theme.title, fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = theme.content, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Вопрос: ${theme.question}", fontSize = 18.sp)

        TextField(
            value = answer,
            onValueChange = { answer = it },
            label = { Text("Your answer") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (answer.equals(theme.correctAnswer, ignoreCase = true)) {
                Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Incorrect, try once again!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Check")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}