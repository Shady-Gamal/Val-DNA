package com.example.valorant
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.example.valorant.ui.home_screen.HomeViewModel
import com.example.valorant.ui.theme.ValorantTheme
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent ={
                        Column(modifier = Modifier
                            .width(200.dp)
                            .fillMaxSize()
                            .paint(
                                painter = painterResource(id = R.drawable.navigation_drawer_background),
                                contentScale = ContentScale.FillBounds
                            )){
                            drawerHeader()
                            drawerBody(items =
                       navigationList,
                                onItemClick = {navController.navigate(route = it.id)
                                scope.launch { drawerState.close() }
                                }
                            )}
                }
                ) {
                    Column() {
                        AppBar(onNavigationIconClick = {
                            scope.launch { drawerState.apply { if (drawerState.isClosed) open() else close() } }
                        })
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}

