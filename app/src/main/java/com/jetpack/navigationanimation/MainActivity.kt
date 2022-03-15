package com.jetpack.navigationanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.jetpack.navigationanimation.destinations.*
import com.jetpack.navigationanimation.ui.theme.NavigationAnimationTheme
import com.ramcosta.composedestinations.animations.utils.animatedComposable
import com.ramcosta.composedestinations.navigation.navigateTo

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAnimationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavAnimation()
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun NavAnimation() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = S1Destination.route
    ) {
        animatedComposable(S1Destination) { _, _ ->
            S1(
                onClick = { navController.navigateTo(direction = S2Destination) }
            )
        }
        animatedComposable(S2Destination) { _, _ ->
            S2(
                onClick = { navController.navigateTo(direction = S3Destination) },
                onToLoginClick = { navController.navigateTo(direction = LoginDestination) }
            )
        }
        animatedComposable(S3Destination) { _, _ ->
            S3(
                onClick = { navController.navigateTo(direction = S4Destination) }
            )
        }
        animatedComposable(LoginDestination) { _, _ ->
            Login(
                onLoginClick = {
                    navController.navigateTo(S1Destination) {
                        popUpTo(S1Destination.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}
























