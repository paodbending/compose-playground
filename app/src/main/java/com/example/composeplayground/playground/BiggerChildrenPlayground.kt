package com.example.composeplayground.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.playground.tools.Playground


@Composable
private fun Parent() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .border(
                width = 2.dp,
                color = Color.Red,
                shape = RectangleShape
            ),
        contentAlignment = Alignment.Center,
    ) {
        BiggerChildren()
    }
}

@Composable
private fun BiggerChildren() {
    Box(
        modifier = Modifier
//            .size(150.dp)
            .requiredSize(150.dp)
            .border(
                width = 2.dp,
                color = Color.Blue,
                shape = RectangleShape
            )
            .background(color = Color.Cyan)
    )
}


@Preview
@Composable
fun BiggerChildrenPreview() {
    Playground {
        Parent()
    }
}