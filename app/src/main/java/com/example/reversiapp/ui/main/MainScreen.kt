package com.example.reversiapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
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
        Board()
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
fun Board() {

}

@Composable
fun Cell() {

}
