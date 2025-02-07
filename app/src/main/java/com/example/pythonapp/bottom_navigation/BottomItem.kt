package com.example.pythonapp.bottom_navigation

import com.example.pythonapp.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String){
    data object ScreenStudy: BottomItem("Study", R.drawable.learn_icon, "study")
    data object ScreenAccount: BottomItem("Account", R.drawable.account_icon, "account")
}
