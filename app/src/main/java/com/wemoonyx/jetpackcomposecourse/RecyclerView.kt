package com.wemoonyx.jetpackcomposecourse

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wemoonyx.jetpackcomposecourse.model.SuperHero

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("David", "Daniella", "Vanessa")
    LazyColumn {
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(getSuperHeroes()) {
            ItemHero(superHero = it) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SuperHeroView() {
    val context = LocalContext.current

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) {
            ItemHero(superHero = it) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier.width(200.dp),
        onClick = { onItemSelected(superHero) }) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = superHero.superHeroName,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "Logan", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}