package com.jcortezstudio.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.palette.graphics.Palette
import com.jcortezstudio.pokedex.R
import com.jcortezstudio.pokedex.data.models.PokemonFactoryItem
import com.jcortezstudio.pokedex.ui.theme.Shapes
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.BitmapPalette

typealias SelectionAction = () -> Unit

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonCard(
    pokemon: PokemonFactoryItem,
    selected: SelectionAction
) {
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .padding(dimensionResource(id = R.dimen.card_min_padding)),
        onClick = selected,
        shape = Shapes.medium
    ) {
        Column(
            modifier = Modifier.wrapContentWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#${pokemon.number}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.card_min_padding)),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5
            )
            PokeImage(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.pokemon_image_size)),
                url = pokemon.image
            )
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.card_min_padding)),
                textAlign = TextAlign.Center,
            )
        }

    }
}