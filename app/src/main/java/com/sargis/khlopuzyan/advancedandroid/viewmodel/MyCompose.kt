package com.sargis.khlopuzyan.advancedandroid.viewmodel

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyCompose() {

//    val myViewModel: MyViewModel = MyViewModel()
//    val myViewModel: MyViewModel = viewModel<MyViewModel>()
    val myViewModel: MyViewModel = viewModel<MyViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MyViewModel(generateRandomColor()) as T
            }
        }
    )

    val color = myViewModel.backgroundColor

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
                    myViewModel.changeBackgroundColor()
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