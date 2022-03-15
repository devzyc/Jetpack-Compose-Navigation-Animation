package com.jetpack.navigationanimation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.jetpack.navigationanimation.destinations.*
import com.ramcosta.composedestinations.animations.utils.animatedComposable
import com.ramcosta.composedestinations.navigation.navigateTo

/**
 * @author devzyc
 */
@ExperimentalAnimationApi
@Composable
fun AppNavigation(
    navController: NavHostController
) {
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
        animatedComposable(S4Destination) { _, _ ->
            S4(
                onClick = { navController.navigateTo(direction = S1Destination) }
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