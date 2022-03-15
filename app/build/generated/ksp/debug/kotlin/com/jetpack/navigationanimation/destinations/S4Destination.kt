package com.jetpack.navigationanimation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ramcosta.composedestinations.manualcomposablecalls.DestinationScope
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.navargs.DestinationsStringNavType
import com.ramcosta.composedestinations.spec.*
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.remember
import com.jetpack.navigationanimation.S4
import com.jetpack.navigationanimation.ui.DefaultTransitions

@OptIn(ExperimentalAnimationApi::class)
object S4Destination : DirectionDestination {
         
    operator fun invoke() = this
    
    override val routeId = "s4"

    override val route = routeId
    
	override val style = DefaultTransitions

    @Composable
    override fun DestinationScope<Unit>.Content(
		dependenciesContainerBuilder: @Composable DependenciesContainerBuilder<Unit>.() -> Unit
    ) {
		val dependencyContainer = remember { DestinationDependenciesContainer(this) }
		dependencyContainer.apply { dependenciesContainerBuilder() }

		S4(
			onClick = dependencyContainer.require()
		)
    }
    
}