package com.tweetsycompose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tweetsycompose.app.screens.CategoryScreen
import com.tweetsycompose.app.screens.DetailScreen
import com.tweetsycompose.app.screens.OtherCustomScreen
import com.tweetsycompose.app.ui.theme.TweetsyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TweetsyComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(title = {
                        Text(text = "Tweesty")
                    }, Modifier.background(Color.Black))
                }) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        App()
                    }
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {

        composable(route = "category") {
            CategoryScreen {
                navController.navigate("detailScreen/${it}")
            }
        }

        composable(route = "detailScreen/{category}", arguments = listOf(navArgument("category") {
            type = NavType.StringType
        })) {
            val category = it.arguments!!.getString("category")
            DetailScreen(category){
                navController.navigate("OtherScreen")
            }
        }

        composable(route = "OtherScreen"){
            OtherCustomScreen()
        }
    }
}