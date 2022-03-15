@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package com.jetpack.navigationanimation.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavBackStackEntry
import com.jetpack.navigationanimation.Duration
import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(ExperimentalAnimationApi::class)
object DefaultTransitions : DestinationStyle.Animated {

    var tabRoutes: List<String>? = null

    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition =
        slideLeft()

    override fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition =
        slideRight()
}

@OptIn(ExperimentalAnimationApi::class)
private fun AnimatedContentScope<NavBackStackEntry>.slideLeft(): EnterTransition =
    slideIntoContainer(
        AnimatedContentScope.SlideDirection.Left,
        animationSpec = tween(durationMillis = Duration.ScreenTransition)
    ) + fadeIn(animationSpec = tween(durationMillis = Duration.ScreenTransition))

@OptIn(ExperimentalAnimationApi::class)
private fun AnimatedContentScope<NavBackStackEntry>.slideRight(): EnterTransition =
    slideIntoContainer(
        AnimatedContentScope.SlideDirection.Right,
        animationSpec = tween(durationMillis = Duration.ScreenTransition)
    ) + fadeIn(animationSpec = tween(durationMillis = Duration.ScreenTransition))
