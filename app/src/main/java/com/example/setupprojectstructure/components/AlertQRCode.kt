package com.example.setupprojectstructure.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.setupprojectstructure.R
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
                QrCodeView(
                    data = "https://github.com/lightsparkdev/compose-qr-code",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(top = 60.dp)
                        .align(Alignment.Center)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize().padding(top = 108.dp, start = 40.dp)
                ) {
                    Text(
                        text = "Scan $",
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
}
    }