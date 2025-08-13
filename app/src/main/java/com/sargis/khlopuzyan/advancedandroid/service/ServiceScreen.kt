package com.sargis.khlopuzyan.advancedandroid.service

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

//val foregroundServicePermission = arrayOf(
//    Manifest.permission.FOREGROUND_SERVICE,
//)

val foregroundServiceAndNotificationPermissions = listOf(
    Manifest.permission.FOREGROUND_SERVICE,
    Manifest.permission.POST_NOTIFICATIONS,
)

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ServiceScreen() {
    val context = LocalContext.current

//    val permissionsState = rememberPermissionState(Manifest.permission.FOREGROUND_SERVICE)
    val permissionsState = rememberMultiplePermissionsState(
        foregroundServiceAndNotificationPermissions
    )

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver { source: LifecycleOwner, event: Event ->
            if (event == Event.ON_RESUME && !permissionsState.isPermanentlyDenied()) {
//                permissionsState.launchPermissionRequest()
                permissionsState.launchMultiplePermissionRequest()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (permissionsState.allPermissionsGranted) {
                Button(
                    modifier = Modifier
                        .wrapContentSize(),
                    onClick = {
                        val intent = Intent(context, RunningService::class.java)
                        intent.setAction(Action.START.name)
                        context.startService(intent)
                    }
                ) {
                    Text("Start Foreground Service")
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    modifier = Modifier
                        .wrapContentSize(),
                    onClick = {
                        val intent = Intent(context, RunningService::class.java)
                        intent.setAction(Action.STOP.name)
//                        context.stopService(intent)
                        context.startService(intent)
                    }
                ) {
                    Text("Stop Foreground Service")
                }
            } else {
                permissionsState.permissions.forEach { perm ->
                    when (perm.permission) {
                        Manifest.permission.FOREGROUND_SERVICE -> {
                            when {
                                perm.status.isGranted -> {
                                    Text("Foreground service permission is granted")
                                    println("LOG_TAG foreground service permission is granted")
                                }

                                perm.status.shouldShowRationale -> {
                                    Text("Foreground service permission needed")
                                    println("LOG_TAG foreground service permission needed")
                                }

                                perm.isPermanentlyDenied() -> {
                                    Text("Foreground service permission is permanently denied. You can enable it in app settings")
                                    println("LOG_TAG foreground service permission is permanently denied. You can enable it in app settings")
                                }
                            }
                        }

                        Manifest.permission.POST_NOTIFICATIONS -> {
                            when {
                                perm.status.isGranted -> {
                                    Text("Post notification permission is granted")
                                    println("LOG_TAG post notification permission is granted")
                                }

                                perm.status.shouldShowRationale -> {
                                    Text("Post notification permission needed")
                                    println("LOG_TAG post notification permission needed")
                                }

                                perm.isPermanentlyDenied() -> {
                                    Text("Post notification permission is permanently denied. You can enable it in app settings")
                                    println("LOG_TAG post notification permission is permanently denied. You can enable it in app settings")
                                }
                            }
                        }
                    }
                }

                if (permissionsState.isPermanentlyDenied()) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        modifier = Modifier
                            .wrapContentSize(),
                        onClick = {
                            val intent =
                                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                                    data = Uri.fromParts(
                                        "package",
                                        "com.sargis.khlopuzyan.advancedandroid",
                                        null
                                    )
                                }
                            context.startActivity(intent)
                        }
                    ) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "Set permissions from Settings"
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        modifier = Modifier
                            .wrapContentSize(),
                        onClick = {
//                        permissionsState.launchPermissionRequest()
                            permissionsState.launchMultiplePermissionRequest()
                        }
                    ) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "Request Permissions"
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
fun PermissionState.isPermanentlyDenied() =
    !this.status.isGranted && !this.status.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
fun MultiplePermissionsState.isPermanentlyDenied() =
    !this.allPermissionsGranted && !this.shouldShowRationale
