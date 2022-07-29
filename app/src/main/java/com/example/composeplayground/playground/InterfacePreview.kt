package com.example.composeplayground.playground

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.playground.tools.Playground
import com.example.composeplayground.playground.tools.recomposeHighlighter

@Stable
private data class State(
    val count: Int,
    val innerState: InnerState = InnerState(0)
)

@Stable
private data class InnerState(
    var count: Int
)

@Preview
@Composable
fun InterfacePreview() {

    val mutableState = remember {
        mutableStateOf(State(0))
    }

    Playground {
        Comp(
            state = mutableState.value,
            onClick = {
                mutableState.value = State(
                    mutableState.value.count
                )
            }
        )
    }
}

@Composable
private fun Comp(
    state: State,
    onClick: () -> Unit
) = Column(
    modifier = Modifier.recomposeHighlighter(),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(text = state.count.toString())
    Button(onClick = onClick) {
        Text(text = "Recompose")
    }
}