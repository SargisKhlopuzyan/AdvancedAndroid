package com.sargis.khlopuzyan.advancedandroid.overview

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.advancedandroid.effectHandlers_3.suspended_effect_handler.showToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


@Composable
fun EffectHandlerTestScreen() {

    var counter by remember {
        mutableIntStateOf(0)
    }

    var buttonState by remember {
        mutableStateOf(true)
    }

    var childComponentState by remember {
        mutableStateOf(true)
    }

    val context = LocalContext.current

    //TODO*1 - LaunchedEffect
    LaunchedEffect(key1 = true) {
        context.showToast("$counter")
    }

    //TODO*3 - DisposableEffect
    DisposableEffect(key1 = true) {
//        registerReceiver
        onDispose {
//            unregisterReceiver
        }
    }

    /**
     * SideEffect is a function used in Jetpack Compose’s declarative structure to perform non-interactive tasks.
     * It does not make any changes to the UI but prevents performance issues and makes the application run faster.
     * */
    //TODO*4 - SideEffect
    SideEffect {
        Log.e("sideeffect", "Count is $counter")
    }


    //TODO*6
    val buttonText by remember {
        //TODO*6 - derivedStateOf
        derivedStateOf {
            if (counter > 5) {
                "Counter is greater then 5 ($counter)"
            } else {
                "Counter is less then 5 ($counter)"
            }
        }
    }


    Column {
        Spacer(modifier = Modifier.height(64.dp))

        Button(
            onClick = {
                counter++
            }
        ) {
            Text(text = "Increment Count'")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (buttonState) {
            Box {
                //TODO*2 - rememberCoroutineScope
                val coroutineScope = rememberCoroutineScope()
                Button(
                    onClick = {
                        coroutineScope.launch {
                            var i = 0
                            while (i <= 55 && this.isActive) {
                                println("LOG-$i")
                                i++
                                delay(1000)
                            }
                            counter++
                        }
                    }
                ) {
                    Text(text = "Click Me'")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(
            onClick = {
                buttonState = !buttonState
            }
        ) {
            Text(text = "Change First Button State'")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                childComponentState = !childComponentState
            }
        ) {
            Text(text = "Change Child Component State'")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ChildComponent("Counter : $counter")

        Text(text = "$counter")

    }
}

@Composable
fun ChildComponent(title: String) {

    var text by remember {
        mutableStateOf(title)
    }

    //TODO*5 - rememberUpdatedState
    val updatedData by rememberUpdatedState(title)

    SideEffect {
        println("ChildComponent -> text: $text")
        println("ChildComponent -> updatedData: $updatedData")
    }

    Column {
        Text(text)
        Text(updatedData)
    }
}

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun produceStateDemo(countUpTo: Int): State<Int> {
    //TODO*7 - produceState (** produce state like flow)
    return produceState(initialValue = 0) {
        while (value < countUpTo) {
            delay(1000)
            value++
        }
    }
}

@Composable
fun snapShotFlowDemo() {
    var count by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(count) {
        //TODO*7 - snapShotFlow (***Converts state to flow)
        val flow = snapshotFlow {
            count
        }

        flow.mapNotNull {
            it
        }.distinctUntilChanged().collect {
            println("In SnapShotFlow -> value: $it")
        }
    }
}

