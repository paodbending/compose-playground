package com.example.composeplayground.playground.tools

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Playground(modifier: Modifier = Modifier.size(300.dp), content: @Composable () -> Unit) {
    Surface(
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}