package com.example.composeplayground.playground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.example.composeplayground.playground.tools.Playground
import com.example.composeplayground.playground.tools.recomposeHighlighter


@Composable
@Preview
fun OffsetPreview() {
    Playground {
        val mutableState = remember {
            mutableStateOf(0)
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Tile(
                tileState = TileState(
                    text = "Text",
                    offsetProvider = {
                        mutableState.value
                    }
                ),
                onClick = {
                    mutableState.value = mutableState.value + 10
                }
            )
        }
    }
}

private data class TileState(
    val text: String,
    val offsetProvider: () -> Int,
)

@Composable
private fun Tile(
    tileState: TileState,
    onClick: () -> Unit
) = Box(
    modifier = Modifier
        .offset {
            IntOffset(
                x = 0,
                y = tileState.offsetProvider()
            )
        }
        .recomposeHighlighter()
) {
    Button(
        onClick = onClick
    ) {
        Text(text = tileState.text)
    }
}