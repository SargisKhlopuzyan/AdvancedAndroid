package com.sargis.khlopuzyan.advancedandroid.viewmodel.v2

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyActivity : ComponentActivity() {
    val factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass is MyViewModel && modelClass == null) {
                return MyViewModel("Sargis") as T
            }
            return super.create(modelClass)
        }
    }
    val vmp = ViewModelProvider(this, factory)
    val myViewModel: MyViewModel = vmp.get(MyViewModel::class.java)
}

class MyViewModel(
    val name: String,
) : ViewModel() {

}