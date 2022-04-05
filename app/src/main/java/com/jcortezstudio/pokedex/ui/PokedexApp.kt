package com.jcortezstudio.pokedex.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jcortezstudio.pokedex.ui.theme.PokedexTheme

@Composable
fun PokedexApp(content: @Composable () -> Unit) {
    PokedexTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}