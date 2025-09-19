package com.sargis.khlopuzyan.advancedandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.advancedandroid.overview.EffectHandlerTestScreen
import com.sargis.khlopuzyan.advancedandroid.savedStateHandle.MyViewModel
import com.sargis.khlopuzyan.advancedandroid.ui.MainNavigation
import com.sargis.khlopuzyan.advancedandroid.ui.theme.AdvancedAndroidTheme
import com.sargis.khlopuzyan.advancedandroid.workManager.PhotoViewModel

class MainActivity : ComponentActivity() {
    //    private lateinit var workManager: WorkManager
    private val viewModel by viewModels<PhotoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        workManager = WorkManager.getInstance(applicationContext)

//        val factory = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
//                    @Suppress("UNCHECKED_CAST")
//                    return MyViewModel(SavedStateHandle()) as T // Pass a SavedStateHandle
//                }
//                throw IllegalArgumentException("Unknown ViewModel class")
//            }
//        }
//
//        val viewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            AdvancedAndroidTheme {

//                val viewModel = viewModel<PhotoViewModel>()
//                val viewModel = viewModel<PhotoViewModel>(
//                    factory = object : ViewModelProvider.Factory {
//                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                            return MyViewModel(SavedStateHandle()) as T
//                        }
//                    }
//                )

                /**
                val workerResult = viewModel.workId?.let { id ->
                workManager.getWorkInfoByIdLiveData(id).observeAsState().value
                //                    workManager.getWorkInfoByIdFlow(id).collectAsStateWithLifecycle(this).value
                }

                LaunchedEffect(key1 = workerResult?.outputData) {
                if (workerResult?.outputData != null) {
                val filePath =
                workerResult.outputData.getString(PhotoCompressionWorker.KEY_RESULT_PATH)
                filePath?.let {
                val bitmap = BitmapFactory.decodeFile(it)
                viewModel.updateCompressedBitmap(bitmap)
                }
                }
                }

                Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                viewModel.uncompressedUri?.let {
                Text("Uncompressed photo")
                AsyncImage(model = it, contentDescription = null)
                Spacer(modifier = Modifier.height(16.dp))
                }

                viewModel.compressedBitmap?.let {
                Text("Uncompressed photo")
                Image(bitmap = it.asImageBitmap(), contentDescription = null)
                }
                }
                 */

//                MainNavigation()
                EffectHandlerTestScreen()
            }
        }
//        finish()
    }

    override fun onStart() {
//        finish()
        Log.e("LOG_TAG", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e("LOG_TAG", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("LOG_TAG", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("LOG_TAG", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("LOG_TAG", "onDestroy")
        super.onDestroy()
    }

    /**
    override fun onNewIntent(intent: Intent) {
    super.onNewIntent(intent)

    println("LOG_TAG MainActivity -> onNewIntent")

    val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
    } else {
    intent.getParcelableExtra(Intent.EXTRA_STREAM)
    } ?: return

    viewModel.updateUncompressedUri(uri)

    val request = OneTimeWorkRequestBuilder<PhotoCompressionWorker>()
    .setInputData(
    workDataOf(
    PhotoCompressionWorker.KEY_CONTENT_URI to uri.toString(),
    PhotoCompressionWorker.KEY_COMPRESSION_THRESHOLD to 1024 * 20L
    )
    )
    //            .setConstraints(
    //                Constraints(requiresStorageNotLow = true)
    //            )
    .build()

    viewModel.updateWorkId(request.id)

    workManager.enqueue(request)
    }*/
}