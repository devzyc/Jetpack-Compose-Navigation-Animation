package com.jetpack.navigationanimation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jetpack.navigationanimation.ui.DefaultTransitions
import com.ramcosta.composedestinations.annotation.Destination

/**
 * @author devzyc
 */
@Composable
@Destination(
    start = true,
    style = DefaultTransitions::class
)
fun S1(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onClick) {
            Text("1")
        }
    }
}