package es.crisvega.lazyverticalgrid

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun LazyVertical(modifier: Modifier) {
    val context = LocalContext.current
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(180.dp),
//        GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(getGaleria()) {
            ItemGaleria(it) {
                Toast.makeText(context, it.nombre, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemGaleria(model: Imagen, function: (Imagen) -> Unit) {
    Card(
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .padding(8.dp)
            .clickable { function(model) }
    ) {
        Row {
            Column {
                Image(modifier = Modifier.height(100.dp),
                    painter = rememberAsyncImagePainter(
                        model = model.url,
                        placeholder = painterResource(R.drawable.ic_launcher_background),
                        error = painterResource(R.drawable.ic_launcher_foreground)
                    ),
                    contentDescription = ""
                )
            }
            Column(modifier = Modifier.padding(15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = model.nombre,
                    fontSize = 10.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

fun getGaleria(): List<Imagen> {
    return listOf(
        Imagen(
            "Pikachu",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/025.png"
        ),
        Imagen(
            "Charizard",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/006.png"
        ),
        Imagen(
            "Lucario",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/448.png"
        ),
        Imagen(
            "Mewtwo",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/150.png"
        ),
        Imagen(
            "Greninja",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/658.png"
        ),
        Imagen(
            "Jinx",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/124.png"
        ),
        Imagen("Slowpoke","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/080.png"),
        Imagen("Gyarados","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/130.png"),
        Imagen("Dragonite","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/149.png"),
        Imagen("Mew","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/151.png"),
        Imagen("Jolteon","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/135.png"),
        Imagen("Flareon","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/136.png"),
        Imagen("Espeon","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/196.png"),
        Imagen("Umbreon","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/197.png"),
        Imagen("Sylveon","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/198.png"),
        Imagen("Clefairy","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/035.png"),
        Imagen("Jiglipuff","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/039.png"),
        Imagen("Ninetales","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/097.png"),
        Imagen("Vaporeon","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/134.png"),
        Imagen("Jolteon","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/135.png"),
    )
}