package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.launchedEffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LaunchedEffectScreen() {

    val launchedEffectViewModel = viewModel<LaunchedEffectViewModel>()

    LaunchedEffect(true) {
        launchedEffectViewModel.sharedFlow.collect {
            when(it) {
                is LaunchedEffectViewModel.ScreenEvents.Navigate -> {

                }
                is LaunchedEffectViewModel.ScreenEvents.ShowSnackbar -> {

                }
            }
        }
    }

}