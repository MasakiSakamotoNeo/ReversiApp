package com.example.reversiapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.reversiapp.data.Stone
import com.example.reversiapp.ui.Screen

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value
    MainContent(state) { event ->
        if (event == MainEvent.NavigateSettings) {
            navController.navigate(Screen.SettingsScreen.route)
        } else {
            viewModel.onEvent(event)
        }
    }
}

@Composable
fun MainContent(
    state: MainState,
    onEvent: (MainEvent) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = if (state.currentTurnColor == StoneColor.Black) "黒の番です。" else "白の番です。",
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Board(state, onEvent)
        Button(
            onClick = { onEvent(MainEvent.NavigateSettings) }
        ) {
            Text(text = "選択")
        }
        Button(
            onClick = { onEvent(MainEvent.FinishTurn) }
        ) {
            Text(text = "交代")
        }
    }
}

@Composable
fun Board(state: MainState, onEvent: (MainEvent) -> Unit) {
    Cell(
        stone = state.stonesData[0],
        onEvent = onEvent
    )
}

@Composable
fun Cell(stone: Stone, onEvent: (MainEvent) -> Unit) {
    Box(
        modifier = Modifier
            .size(90.dp)
            .background(color = Color.Green)
            .clickable { onEvent(MainEvent.OnTapCell(stone)) },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(
                    color = when (stone.colorName) {
                        StoneColor.Black -> Color.Black
                        StoneColor.White -> Color.White
                        StoneColor.None -> Color.Transparent
                    }
                )
        )
    }
}
