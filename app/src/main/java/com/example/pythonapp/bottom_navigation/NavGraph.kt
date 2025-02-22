package com.example.pythonapp.bottom_navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pythonapp.Theme
import com.example.pythonapp.ThemeDetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    navHostController: NavHostController
){
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