package com.sargis.khlopuzyan.advancedandroid.savedStateHandle

import androidx.fragment.app.Fragment
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

class MyFragment : Fragment() {

        private lateinit var viewModel: MyViewModel
    //    private val viewModel1: MyViewModel = viewModel<MyViewModel>() // Error - Should be in Compose
//    private val viewModel: MyViewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return MyViewModel(SavedStateHandle()) as T // Pass a SavedStateHandle
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }

        viewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]
    }
}