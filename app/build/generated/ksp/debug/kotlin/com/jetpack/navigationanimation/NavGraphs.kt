package com.jetpack.navigationanimation

import com.jetpack.navigationanimation.destinations.*
import com.ramcosta.composedestinations.spec.*

/**
 * Class generated if any Composable is annotated with `@Destination`.
 * It aggregates all [TypedDestination]s in their [NavGraph]s.
 */
object NavGraphs {

    val root = NavGraph(
        route = "root",
        startRoute = S1Destination,
        destinations = listOf(
            LoginDestination,
			S1Destination,
			S2Destination,
			S3Destination,
			S4Destination
        )
    )
}