package com.jetpack.navigationanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.jetpack.navigationanimation.destinations.*
import com.jetpack.navigationanimation.ui.theme.NavigationAnimationTheme
import com.ramcosta.composedestinations.spec.Route

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAnimationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    WanApp()
                }
            }
        }
    }
}

@Suppress("EXPERIMENTAL_IS_NOT_ENABLED")
@OptIn(ExperimentalComposeUiApi::class)
enum class WanTabs(
    val title: String,
    @DrawableRes val icon: Int,
    val destination: Route
) {
    ONE("1", R.drawable.ic_tab_one_black_24dp, S1Destination),
    TWO("2", R.drawable.ic_square_black_24dp, S2Destination),
    THREE("3", R.drawable.ic_wechat_black_24dp, S3Destination),
    FOUR("4", R.drawable.ic_knowledge_system_black_24dp, S4Destination),
}

@ExperimentalAnimationApi
@Composable
fun WanApp() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberAnimatedNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            val tabRoutes = remember {
                WanTabs.values().map { it.destination.route }
            }
            if (navController.currentBackStackEntryAsState().value?.destination?.route
                in tabRoutes
            ) {
                BottomAppBar(modifier = Modifier.height(56.dp)) {
                    HomeBottomNavigation(navController)
                }
            }
        },
    ) {
        AppNavigation(
            navController = navController,
        )
    }
}

@Composable
fun HomeBottomNavigation(
    navController: NavController
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        ?: WanTabs.ONE.destination.route

    BottomNavigation {
        WanTabs.values().forEach { tab ->
            val selected = currentRoute == tab.destination.route

            BottomNavigationItem(
                icon = { Icon(painter = painterResource(tab.icon), contentDescription = tab.title) },
                label = { Text(tab.title) },
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(tab.destination.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = LocalContentColor.current,
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}
