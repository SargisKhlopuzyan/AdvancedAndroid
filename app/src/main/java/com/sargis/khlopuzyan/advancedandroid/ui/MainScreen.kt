package com.sargis.khlopuzyan.advancedandroid.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Advanced Android")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(132, 192, 196, 255)
                )
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                LazyGridItem(
                    text = "Effect handler",
                    onClick = {
                        navController.navigate(MainScreens.EffectHandler.route)
                    }
                )
            }

            item {
                LazyGridItem(
                    text = "Thread Handler Looper ThreadPool",
                    onClick = {
                        navController.navigate(MainScreens.ThreadHandlerLooperThreadPool.route)
                    }
                )
            }

            item {
                LazyGridItem(
                    text = "Continuation",
                    onClick = {
                        navController.navigate(MainScreens.Continuation.route)
                    }
                )
            }
        }
    }
}


@Composable
private fun LazyGridItem(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(132, 192, 196, 255)),
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        onClick = onClick
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController())
}