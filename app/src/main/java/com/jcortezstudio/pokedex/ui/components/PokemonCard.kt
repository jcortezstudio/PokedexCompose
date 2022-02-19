package com.jcortezstudio.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.palette.graphics.Palette
import com.jcortezstudio.pokedex.R
import com.jcortezstudio.pokedex.data.models.PokemonFactoryItem
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.BitmapPalette

typealias SelectionAction = () -> Unit

@Composable
fun PokemonCard(
    pokemon: PokemonFactoryItem,
    selected: SelectionAction
) {
    var palette by remember { mutableStateOf<Palette?>(null) }
    Card(
        elevation = 4.dp,
        backgroundColor = Color(palette?.dominantSwatch?.rgb ?: 0),
        modifier = Modifier
            .padding(6.dp)
            .height(180.dp)
            .fillMaxWidth()
            .clickable { selected() },
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                imageModel = pokemon.image,
                bitmapPalette = BitmapPalette(
                    useCache = true
                ) {
                    palette = it
                },
                modifier = Modifier
                    .size(120.dp)
                    .padding(0.dp, 0.dp, 10.dp, 0.dp),
                circularReveal = CircularReveal(),
                loading = {
                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val indicator = createRef()
                        CircularProgressIndicator(
                            modifier = Modifier.constrainAs(indicator) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                        )
                    }
                },
                failure = {
                    Image(
                        painter = painterResource(id = R.drawable.no_pokemon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .padding(0.dp, 0.dp, 10.dp, 0.dp)
                    )
                }
            )
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
                textAlign = TextAlign.Center
            )
        }

    }
}