package com.jcortezstudio.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.jcortezstudio.pokedex.R
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PokeImage(modifier: Modifier, url: String) {
    GlideImage(
        imageModel = url,
        modifier = modifier,
        circularReveal = CircularReveal(),
        loading = {
            ConstraintLayout(
                modifier = androidx.compose.ui.Modifier.fillMaxSize()
            ) {
                val indicator = createRef()
                CircularProgressIndicator(
                    modifier = androidx.compose.ui.Modifier.constrainAs(indicator) {
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
                modifier = androidx.compose.ui.Modifier
                    .size(dimensionResource(id = R.dimen.pokemon_image_size))
            )
        }
    )
}