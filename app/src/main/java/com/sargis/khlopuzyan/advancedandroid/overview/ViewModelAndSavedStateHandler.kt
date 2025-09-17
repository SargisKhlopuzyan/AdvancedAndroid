package com.sargis.khlopuzyan.advancedandroid.overview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.advancedandroid.savedStateHandle.MyViewModel
import com.sargis.khlopuzyan.advancedandroid.workManager.PhotoViewModel

//TODO-URL : https://www.youtube.com/watch?v=nNv1a0nmOfk

class MyViewModel(
    val param: String,
    val savedStateHandle: SavedStateHandle,
) : ViewModel() {
}

class MyActivity : ComponentActivity() {

    private val viewModel_v1 by viewModels<PhotoViewModel>()
//    private val viewModel_v2: MyViewModel = viewModel<MyViewModel>() // Error - Should be in Compose

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    // Pass a param and SavedStateHandle
                    return MyViewModel("AnyParam", SavedStateHandle()) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }

        val viewModel_v3 = ViewModelProvider(this, factory)[MyViewModel::class.java]
    }
}

class MyFragment : Fragment() {

    private val viewModel_v1: MyViewModel by viewModels<MyViewModel>()
//    private val viewModel_v2: MyViewModel = viewModel<MyViewModel>() // Error - Should be in Compose

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    // Pass a param and SavedStateHandle
                    return MyViewModel("AnyParam", SavedStateHandle()) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }

        var viewModel_v3: MyViewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]
        var viewModel_v4: MyViewModel = ViewModelProvider(this)[MyViewModel::class.java] // Without factory
        var viewModel_v5: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java) // Without factory
    }
}

@Composable
fun MyComposable() {
    val viewModel_v1: MyViewModel = viewModel<MyViewModel>()
    val viewModel_v2: MyViewModel = viewModel<MyViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    // Pass a param and SavedStateHandle
                    return MyViewModel("AnyParam", SavedStateHandle()) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    )
}