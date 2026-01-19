package com.example.mynewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynewsapp.ui.screens.MainScreen
import com.example.mynewsapp.ui.screens.SplashScreen
import com.example.mynewsapp.ui.theme.MyNewsAppTheme
import com.example.mynewsapp.vm.NewsVm
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyNewsAppTheme {

                val navController = rememberNavController()
                val vm: NewsVm = hiltViewModel()

                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {

                    composable("splash") {
                        SplashScreen(navController)
                    }

                    composable("main") {
                        MainScreen(vm)
                    }
                }
            }
        }
    }
}
