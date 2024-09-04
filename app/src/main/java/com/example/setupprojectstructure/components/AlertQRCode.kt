package com.example.setupprojectstructure.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.setupprojectstructure.R
import com.example.setupprojectstructure.viewModel.ActionDetailViewModel
import com.lightspark.composeqr.QrCodeView

// alert dialog for QR code
@Composable
fun AlertQRCode(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Dialog(onDismissRequest = onDismiss) {
            Box(modifier = Modifier.size(400.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.qrbg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
               Box(modifier = Modifier.align(Alignment.Center),
                   contentAlignment = Alignment.Center){
                   QrCodeView(
                       data = "https://link.payway.com.kh/aba?id=A1431CA78757&code=660071&acc=003955435&dynamic=true",
                       modifier = Modifier
                           .size(200.dp)
                           .padding(top = 60.dp)
                   )
                   Image(painter = painterResource(id = R.drawable.money), contentDescription = "moneyIcon",
                       modifier = Modifier.padding(top = 110.dp).size(40.dp))
               }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 108.dp, start = 46.dp)
                ) {
                    Text(
                        text = "0 $",
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}