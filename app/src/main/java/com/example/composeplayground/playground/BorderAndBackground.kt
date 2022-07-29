package com.example.composeplayground.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.playground.tools.Playground


// Using a both a Border and a Background modifiers causes
// some ugly pixels to show up on the edges.
// Issues described here https://issuetracker.google.com/issues/228985905?pli=1

@Preview
@Composable
fun BorderAndBackgroundPreview() {
    Playground {
        val shape = RoundedCornerShape(8.dp)
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(
                    width = 2.dp,
                    color = Color.White,
                    shape = shape
                )
                .background(
                    color = Color.Red,
                    shape = shape
                )
        )
    }
}
