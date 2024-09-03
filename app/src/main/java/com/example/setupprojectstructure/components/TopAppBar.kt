package com.example.setupprojectstructure.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.setupprojectstructure.R
import com.lightspark.composeqr.QrCodeView

@Composable
fun TopBar(){
    var isDialogOpen by remember { mutableStateOf(false) }
   Row (modifier = Modifier
       .fillMaxWidth()
       .height(70.dp),
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically){
       Box(
           modifier = Modifier
               .weight(1f)
       ) {
           Row (modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween) {
               Box(modifier = Modifier
                   .size(50.dp)
                   .clip(CircleShape)
               ){
                    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "profile User",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize())
               }
               Box(modifier = Modifier){
                  Column {
                      Text(text = "Hello, Chin Kosal", fontSize = 16.sp , color = Color.White)
                      Text(text = "View Profile", fontSize = 14.sp,  color = Color.White)
                  }
               }
           }
       }
       Box(modifier = Modifier
           .weight(1f)
           .background(Color.Transparent)){
           Row (modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.End) {
               Box(
                   modifier = Modifier
                       .clip(CircleShape)
                       .size(25.dp)
               ) {
                   // notification
                   Image(
                       painter = painterResource(id = R.drawable.ic_notification),
                       contentDescription = null,
                       modifier = Modifier.size(25.dp) 
                   )
               }
               Spacer(modifier = Modifier.width(5.dp))
               Box(modifier = Modifier
                   .size(25.dp)
                   .clip(CircleShape)
                   .background(Color.Yellow)
                   .clickable { isDialogOpen = true }){
                   // QR code
                    Image(painter = painterResource(id = R.drawable.ic_bk), contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
               }
           }
       }
   }

    // call alert dialog QR code
    if (isDialogOpen) {
        AlertQRCode(onDismiss = {
            isDialogOpen = false
        }
        )
    }
}


