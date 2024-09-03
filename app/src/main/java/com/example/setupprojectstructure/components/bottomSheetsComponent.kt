package com.example.setupprojectstructure.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComponent(
    isSheetOpen: Boolean,
    onDismiss: () -> Unit,
    sheetContent: @Composable () -> Unit,mainContent: @Composable () -> Unit
) {
    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            modifier = Modifier.fillMaxSize()
        ) {
            sheetContent()
        }
    }

    mainContent()
}





