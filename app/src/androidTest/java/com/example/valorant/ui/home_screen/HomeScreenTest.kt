package com.example.valorant.ui.home_screen

import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.data.di.RoomModule
import com.example.valorant.*
import com.example.valorant.main_activity.MainActivity
import com.example.valorant.main_activity.components.AppBar
import com.example.valorant.navigation.Navigation
import com.example.valorant.navigation.Screen
import com.example.valorant.R
import com.example.valorant.main_activity.components.navigationList
import com.example.valorant.ui.theme.BackGround
import com.example.valorant.ui.theme.ValorantTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.launch
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(RoomModule::class)
class HomeScreenTest{

@get:Rule(order = 0)
val hiltRule = HiltAndroidRule(this)


@get:Rule(order = 1)
val composeRule = createAndroidComposeRule<MainActivity>()

    lateinit var drawerState : DrawerState
    lateinit var navController : NavHostController



    @Before
    fun setup() {

        hiltRule.inject()
        composeRule.activity.setContent {
            ValorantTheme {
                navController = rememberNavController()
                    drawerState = rememberDrawerState(DrawerValue.Closed)
                    val scope = rememberCoroutineScope()


                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    val topBarState = rememberSaveable { (mutableStateOf(true)) }

                    when (navBackStackEntry?.destination?.route) {


                        Screen.WeaponDetailsScreen.route + "/{weaponId}" -> {

                            topBarState.value = false
                        }

                        Screen.AgentDetailsScreen.route + "/{agentId}" -> {
                            topBarState.value = false
                        }
                        else -> topBarState.value = true
                    }



                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            Column(
                                modifier = Modifier
                                    .width(200.dp)
                                    .fillMaxSize()
                                    .paint(
                                        painter = painterResource(id = R.drawable.navigation_drawer_background),
                                        contentScale = ContentScale.FillBounds
                                    )
                            ) {
                                drawerHeader()
                                drawerBody(items =
                                navigationList,
                                    onItemClick = {
                                        navController.navigate(route = it.id) {
                                            popUpTo(Screen.HomeScreen.route)
                                            launchSingleTop = true
                                        }
                                        scope.launch { drawerState.close() }
                                    }
                                )
                            }
                        }, content = {
                            Scaffold(
                                topBar = {
                                    AnimatedVisibility(
                                        visible = topBarState.value,
                                        enter = slideInVertically(initialOffsetY = { -it }),
                                        exit = slideOutVertically(targetOffsetY = { -it }),
                                        content = {
                                            AppBar(onNavigationIconClick = {
                                                scope.launch { drawerState.apply { if (drawerState.isClosed) open() else close() } }

                                            })
                                        }
                                    )


                                }, content = {
                                    Box(
                                        modifier = Modifier
                                            .padding(
                                                if (topBarState.value) it else {
                                                    PaddingValues(0.dp)
                                                }
                                            )
                                            .background(BackGround)
                                    ) {
                                        Navigation(navController = navController)

                                    }
                                })


                        }
                    )


            }


        }
    }

        @Test
        fun appNavHost_verifyGoToSongsButton() {

            composeRule.onNodeWithTag("Nav").assertIsDisplayed()
            composeRule.onNodeWithTag("Nav").assertHasClickAction()
            composeRule.onNodeWithTag("Nav").performClick()
            composeRule.waitUntil {
                drawerState.isOpen
            }
            assertTrue(drawerState.isOpen)




        }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun valorantendtoendtest(){

        composeRule.onNodeWithTag("myLazyColumn").assertIsDisplayed()
        composeRule.waitUntilExactlyOneExists(hasText("Odin"), timeoutMillis = 5000)
        composeRule.onNodeWithTag("myLazyColumn").onChildren().get(0).performClick()
        val route = navController.currentDestination?.route
        assertEquals(route, Screen.WeaponDetailsScreen.route + "/{weaponId}")



    }


    }

