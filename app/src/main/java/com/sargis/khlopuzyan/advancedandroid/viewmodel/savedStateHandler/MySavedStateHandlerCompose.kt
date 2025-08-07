package com.sargis.khlopuzyan.advancedandroid.viewmodel.savedStateHandler

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.advancedandroid.viewmodel.generateRandomColor

@Composable
fun MySavedStateHandlerCompose() {

//    val mySavedStateHandleViewModel: MySavedStateHandleViewModel = MySavedStateHandleViewModel()
//    val mySavedStateHandleViewModel: MySavedStateHandleViewModel = viewModel<MySavedStateHandleViewModel>()
    val mySavedStateHandleViewModel: MySavedStateHandleViewModel =
        viewModel<MySavedStateHandleViewModel>(
            factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MySavedStateHandleViewModel(
                        defaultColor = generateRandomColor(),
                        savedStateHandle = SavedStateHandle()
                    ) as T
                }
            }
        )

    val color by mySavedStateHandleViewModel.backgroundColor.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .wrapContentSize(),
                onClick = {
                    mySavedStateHandleViewModel.changeBackgroundColor()
                }
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Change background color"
                )
            }
        }
    }
}