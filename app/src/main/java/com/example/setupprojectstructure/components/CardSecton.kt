package com.example.setupprojectstructure.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.setupprojectstructure.R

@Composable
fun CardSection(){
    val brush = Brush.horizontalGradient(listOf(Color.Magenta.copy(alpha = 0.6f), Color.Magenta.copy(alpha = 0.4f)))
    var showBackground by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .border(BorderStroke(3.dp, brush), shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(145.dp)
    ) {
        Column (modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround) {
            Box(modifier = Modifier){
              Column {
                  Row(modifier = Modifier.fillMaxWidth()) {
                      Box(
                          modifier = Modifier
                              .clip(RoundedCornerShape(10.dp))
                              .background(Color.Cyan.copy(alpha = 0.2f))
                              .padding(horizontal = 10.dp, vertical = 2.dp)
                      ) {

                          Text(text = "10,0000.00 ៛", fontSize = 14.sp, color = Color.White,
                              modifier = if (showBackground) Modifier.blur(radius = 10.dp).padding(end = 10.dp) else Modifier
                                  .padding(end = 10.dp))
                      }
                      Spacer(modifier = Modifier.width(5.dp))
                      Box(
                          modifier = Modifier
                              .clip(RoundedCornerShape(8.dp))
                              .background(Color.Cyan.copy(alpha = 0.2f))
                              .size(30.dp)
                              .padding(horizontal = 5.dp, vertical = 5.dp)) {
                          Image(
                              painter = painterResource(id = R.drawable.eye2),
                              contentDescription = "",
                              modifier = Modifier.fillMaxSize().clickable { showBackground = !showBackground },
                              contentScale = ContentScale.Crop
                          )
                      }
                  }
                 Row (modifier = Modifier
                     .fillMaxWidth()
                     .padding(top = 8.dp)){
                     Box(modifier = Modifier
                         .clip(RoundedCornerShape(10.dp))
                         .background(Color.Cyan.copy(alpha = 0.2f))
                         .padding(horizontal = 10.dp, vertical = 0.dp)
                     ) {
                         Text(text = "Default",fontSize = 12.sp, color = Color.White)
                     }
                     Spacer(modifier = Modifier.width(2.dp))
                     Box(modifier = Modifier
                         .clip(RoundedCornerShape(10.dp))
                         .background(Color.Transparent)
                         .padding(horizontal = 10.dp, vertical = 2.dp)
                     ) {
                         Text(text = "Saving", fontSize = 12.sp, color = Color.White)
                     }
                 }
              }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)) {
                Box(modifier = Modifier
                    .background(Color.Transparent)
                    .padding(vertical = 2.dp)
                ) {
                    Row (modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                      Box(modifier = Modifier.size(18.dp)){
                          Image(painter = painterResource(id = R.drawable.ic_receive), contentDescription = "",
                              modifier = Modifier.fillMaxSize(),
                              contentScale = ContentScale.Crop)
                      }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Receive money", fontSize = 12.sp, color = Color.White)


                        Spacer(modifier = Modifier.width(10.dp))
                        Box(modifier = Modifier.size(18.dp)){
                            Image(painter = painterResource(id = R.drawable.ic_pay), contentDescription = "",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Send money", fontSize = 12.sp, color = Color.White)
                    }
                }
            }
        }
    }
}