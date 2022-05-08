package br.com.dnassuncao.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.mealzapp.model.response.MealResponse
import coil.compose.AsyncImage

@Composable
fun MealDetailsScreen(meal: MealResponse?) {

    var isExpended by remember { mutableStateOf(false) }
    val imageSizeDp: Dp by animateDpAsState(
        targetValue = if (isExpended) 200.dp else 100.dp
    )

    Column {
        Row {
            Card {
                AsyncImage(
                    model = meal?.imageUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(imageSizeDp)
                        .padding(8.dp)
                )
            }
            Text(
                text = meal?.name ?: "default name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(
            modifier = Modifier
                .padding(16.dp),
            onClick = { isExpended = !isExpended }) {
            Text("Change state of meal profile picture")
        }
    }

}