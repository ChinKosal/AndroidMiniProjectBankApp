package com.example.setupprojectstructure.model

import androidx.compose.ui.graphics.painter.Painter

data class Card(
    val iconCard: Painter,
    val cardName: String = "",
    val descriptionCard: String = ""
)

