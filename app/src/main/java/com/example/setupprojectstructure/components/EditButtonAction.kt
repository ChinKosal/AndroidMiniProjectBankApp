package com.example.setupprojectstructure.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.setupprojectstructure.R
import com.example.setupprojectstructure.components.buttonComponent.ButtonComponent
import com.example.setupprojectstructure.model.CardSheets

@Composable
fun EditButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0D47A1)),
        horizontalArrangement = Arrangement.Center
    ) {
        ButtonComponent(name = "Edit Home", onClick = onClick)
    }
}


@Composable
fun BottomSheetsEditHome() {
    var isSheetOpen by remember { mutableStateOf(false) }
    val items = listOf("Themes", "Dark Mode", "Language")
    var selectedChipIndex by remember { mutableIntStateOf(0) }

    val cardSheetsItems = listOf(
        CardSheets (
            image = painterResource(id = R.drawable.add1)
        ),
        CardSheets (
            image = painterResource(id = R.drawable.add2)
        ),
        CardSheets (
            image = painterResource(id = R.drawable.add3)
        )

    )

    BottomSheetComponent(
        isSheetOpen = isSheetOpen,
        onDismiss = { isSheetOpen = false },
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Appearance",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    ChipGroup(
                        items = items,
                        selectedChipIndex = selectedChipIndex,
                        onChipSelected = { index ->
                            selectedChipIndex = index
                        }
                    )
                }
            }
            LazyVerticalGrid(columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 16.dp),
                contentPadding = PaddingValues(0.dp),//padding
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                userScrollEnabled = false) {
                items(cardSheetsItems){cardSheets ->
                    Card (modifier = Modifier
                        .fillMaxWidth()
                        .size(170.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .size(90.dp)) {
                        Image(painter = cardSheets.image, contentDescription = "", contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize())
                    }
                }
            }
            
            Row (modifier = Modifier.fillMaxWidth().padding(bottom = 30.dp , end = 20.dp), horizontalArrangement = Arrangement.End) {
                Button(onClick = { isSheetOpen = false }) {
                    Text(text = "Save")
                }
            }
        },
        mainContent = {
            EditButton(
                onClick = {
                    isSheetOpen = true
                }
            )
        }
    )
}






