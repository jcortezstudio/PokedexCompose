package com.jcortezstudio.pokedex.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jcortezstudio.pokedex.ui.theme.PokedexTheme

typealias NavigationAction = () -> Unit

@Composable
fun AppBar(
    title: String? = null,
    navigationIcon: ImageVector? = null,
    navigationAction: NavigationAction? = null
) {
    val titleText = title ?: "Pokédex"
    if (navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = { Text(text = titleText, color = MaterialTheme.colors.onPrimary) },
            navigationIcon = {
                IconButton(onClick = { navigationAction() }) {
                    Icon(imageVector = navigationIcon, contentDescription = null)
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {
        TopAppBar(
            title = { Text(text = titleText, color = MaterialTheme.colors.onPrimary) },
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    PokedexTheme {
        AppBar("Pokédex")
    }
}