package com.example.composeplayground.playground

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.playground.tools.Playground
import com.example.composeplayground.playground.tools.recomposeHighlighter

data class ParentState(
    val count: Int,
    val childState: ChildStateImpl,
)

interface ChildState {
    val zero: Int
}

data class ChildStateImpl(
     override val zero: Int
) : ChildState

@Preview
@Composable
private fun ChildRecompositionPreview() {
    Playground {

        val parentState = remember {
            mutableStateOf(
                ParentState(
                    count = 0,
                    childState = ChildStateImpl(0),
                )
            )
        }

        Parent(
            state = parentState.value,
            onClick = {
                val oldState = parentState.value
                parentState.value = ParentState(
                    count = oldState.count + 1,
                    childState = ChildStateImpl(0),
                )
            }
        )
    }
}

@Composable
private fun Parent(
    state: ParentState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.recomposeHighlighter()
    ) {
        Button(onClick = onClick) {
            Text(text = state.count.toString())
        }
        Child(
            state = state.childState,
//            modifier = Modifier.recomposeHighlighter()
        )
    }
}

@Composable
private fun Child(
    state: ChildState,
//    modifier: Modifier = Modifier,
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.recomposeHighlighter()
) {

    Log.v("paod", "Recomposition")

    Text(
        text = "Count:",
        modifier = Modifier.recomposeHighlighter()
    )
//    Text(
//        text = state.count.toString(),
//        modifier = Modifier.recomposeHighlighter()
//    )
    Text(
        text = "Size: ${state.zero}",
        modifier = Modifier.recomposeHighlighter()
    )
}