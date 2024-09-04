package com.example.setupprojectstructure.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ActionDetailViewModel : ViewModel() {
    var isDialogOpen = mutableStateOf(false)

    fun openDialog() {
        isDialogOpen.value = true;
    }

    fun closeDialog() {
        isDialogOpen.value = false
    }

    var isBlurBackground = mutableStateOf(false)

    var selectedOption = mutableStateOf("Default")
}