package com.busra.selfcareapp.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.ButtonComponent
import com.busra.selfcareapp.components.FloatingActionButtonComponent
import com.busra.selfcareapp.components.UserInformationTopBar
import com.busra.selfcareapp.data.HomeViewModel
import com.busra.selfcareapp.data.SignUpViewModel
import com.busra.selfcareapp.data.datastore.UserSettingsManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
//    context
    val context = LocalContext.current
    var scope = rememberCoroutineScope()
    val dataStore = UserSettingsManager(context)
    val userName = FirebaseAuth.getInstance().currentUser?.email?.substringBefore("@")

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cream))
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.cream))
            .padding(top = 10.dp)) {
            if (userName != null) {
                UserInformationTopBar(userName = userName, onMenuButtonClick = {
                    homeViewModel.logout()
                    scope.launch {
                        dataStore.setCheckboxValue(false)
                    }
                },
                    onNotificationButtonClick = {})
            }
            FloatingActionButtonComponent()

        }

        


    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}