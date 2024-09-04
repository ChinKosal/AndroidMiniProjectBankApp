package com.example.setupprojectstructure.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.setupprojectstructure.R
import com.example.setupprojectstructure.model.Card


@Composable
fun CardItem() {
    val cardsList = listOf(
        Card(
            iconCard = painterResource(id = R.drawable.ic_acc),
            cardName = "Account",
            descriptionCard = "Your balance"
        ),
        Card(
            iconCard = painterResource(id = R.drawable.ic_bills),
            cardName = "Pay bills",
            descriptionCard = "School, Shop, etc"
        ),
        Card(
            iconCard = painterResource(id = R.drawable.ic_transfer),
            cardName = "Transfer",
            descriptionCard = "Send money"
        ),
        Card(
            iconCard = painterResource(id = R.drawable.ic_fav),
            cardName = "Favorite",
            descriptionCard = "Users"
        ),
        Card(
            iconCard = painterResource(id = R.drawable.ic_scan),
            cardName = "Scan",
            descriptionCard = "Scan and Pay"
        ),
        Card(
            iconCard = painterResource(id = R.drawable.ic_service),
            cardName = "Service",
            descriptionCard = "Your balance"
        ),
    )
    val brush = Brush.horizontalGradient(listOf(Color.Magenta.copy(alpha = 0.4f), Color.Magenta.copy(alpha = 0.6f)))
    Box(
        modifier = Modifier
            .border(BorderStroke(3.dp, brush), shape = RoundedCornerShape(20.dp))
            .fillMaxWidth().height(220.dp)
            .padding(16.dp)
    ) {
       LazyVerticalGrid(columns = GridCells.Fixed(3),
           modifier = Modifier.fillMaxWidth() ,
           contentPadding = PaddingValues(0.dp),//padding
           horizontalArrangement = Arrangement.spacedBy(8.dp),
           verticalArrangement = Arrangement.spacedBy(8.dp),
           userScrollEnabled = false
       ) {
           items(cardsList) { card ->
               Card (modifier = Modifier
                   .fillMaxWidth().clip(RoundedCornerShape(16.dp))
                   .size(90.dp)) {
                   Column(
                       modifier = Modifier
                           .padding(0.dp)
                           .fillMaxSize()
                   ) {
                       Box(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(top = 10.dp, end = 10.dp),
                                contentAlignment = Alignment.TopEnd
                       ) {
                           Image(
                               painter = card.iconCard,
                               contentDescription = card.cardName,
                               modifier = Modifier.size(23.dp)
                           )
                       }
                      Column (modifier = Modifier.padding(horizontal = 10.dp, vertical = 0.dp)){
                          Text(
                              text = card.cardName,
                              fontSize = 14.sp,
                              fontWeight = FontWeight.SemiBold,
                          )
                          Text(
                              text = card.descriptionCard,
                              fontSize = 11.sp,
                          )
                      }
                   }
               }
           }
       }
    }
}

