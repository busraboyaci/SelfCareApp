package com.busra.selfcareapp.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.busra.selfcareapp.R
import com.busra.selfcareapp.bottombar.BottomBarScreen
import com.busra.selfcareapp.bottombar.BottomNavGraph
import com.busra.selfcareapp.components.UserInformationTopBar
import com.busra.selfcareapp.data.HomeViewModel
import com.busra.selfcareapp.data.datastore.UserSettingsManager
import com.busra.selfcareapp.navigate.ObserveScreenChanges
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
//    context
    val context = LocalContext.current
    var scope = rememberCoroutineScope()
    val dataStore = UserSettingsManager(context)
    val userName = FirebaseAuth.getInstance().currentUser?.email?.substringBefore("@")
    val contextForToast = LocalContext.current.applicationContext


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cream)),
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(50.dp),
                onClick = {
                    SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
                },
                backgroundColor = colorResource(id = R.color.primary),
                contentColor = colorResource(id = R.color.white)
            ) {
                Icon(Icons.Filled.Add, "float action button")
            }
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.cream))
                .padding(top = 10.dp)
        ) {
            if (userName != null) {
                UserInformationTopBar(userName = userName, onMenuButtonClick = {
                    homeViewModel.logout()
                    scope.launch {
                        dataStore.setCheckboxValue(false)
                    }
                },
                    onNotificationButtonClick = {})
            } else {
                UserInformationTopBar(userName = "userName", onMenuButtonClick = {
                    homeViewModel.logout()
                    scope.launch {
                        dataStore.setCheckboxValue(false)
                    }
                },
                    onNotificationButtonClick = {})
            }
//            ObserveScreenChanges()


        }


    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.primary),

        ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}