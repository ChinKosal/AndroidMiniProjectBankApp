package com.example.setupprojectstructure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.scatterSetOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.setupprojectstructure.components.BottomSheetsEditHome
import com.example.setupprojectstructure.components.CardItem
import com.example.setupprojectstructure.components.CardSection
import com.example.setupprojectstructure.components.EditButton
import com.example.setupprojectstructure.components.SwiperSection
import com.example.setupprojectstructure.components.TopBar
import com.example.setupprojectstructure.ui.theme.SetUpProjectStructureTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetUpProjectStructureTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xFF0D47A1)
                ) {
                    // Call the home screen composable
                    homeScreen()
                }
            }
        }
    }

    // function for system color
    @Composable
    private fun  SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

// home screen activity
@Composable
fun homeScreen(){
    Column (modifier = Modifier
        .fillMaxSize()
    ) {
       Column (modifier = Modifier  .padding(start = 10.dp, end = 10.dp)){
           TopBar()
           Spacer(modifier = Modifier.height(10.dp))
           CardSection()
           Spacer(modifier = Modifier.height(10.dp))
           CardItem()
           Spacer(modifier = Modifier.height(10.dp))
           SwiperSection()
           Spacer(modifier = Modifier.height(10.dp))
       }
       Column (modifier = Modifier.fillMaxSize()){
           BottomSheetsEditHome()
       }
    }
}



