package com.example.composeplayground.playground

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.playground.tools.Playground


// Borders are always internal, and they do not influence size

@Preview
@Composable
private fun BordersPreview() {
    Playground {
        Box(
            modifier = Modifier
                .border(
                    width = (2).dp,
                    color = Color.Red,
                    shape = RectangleShape
                )
                .size(100.dp)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RectangleShape
                )
        )
    }
}