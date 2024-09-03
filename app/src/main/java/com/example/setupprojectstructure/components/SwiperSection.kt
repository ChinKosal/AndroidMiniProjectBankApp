package com.example.setupprojectstructure.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.setupprojectstructure.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@SuppressLint("ResourceType")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SwiperSection() {
    @OptIn(ExperimentalPagerApi::class)
    val pagerState = rememberPagerState(initialPage = 0)
    val imageSlider = listOf(
        painterResource(id = R.drawable.add1),
        painterResource(id = R.drawable.add2),
        painterResource(id = R.drawable.add3)
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }
    Column {
        Text(
            text = "New's and Information",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            HorizontalPager(count = imageSlider.size, state = pagerState,
                contentPadding = PaddingValues(horizontal = 0.dp),
                modifier = Modifier
                    .height(170.dp)
            ) { paga ->
                Card (modifier = Modifier.graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(paga).absoluteValue
                        lerp(
                            0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )

                    }
                ) {
                    Image(
                        painter = imageSlider[paga],
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
           Box( modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 8.dp)
               .clip(RoundedCornerShape(30.dp))
               .background(Color.Black.copy(alpha = 0.4f))
           ){
               HorizontalPagerIndicator(
                   pagerState = pagerState, indicatorWidth = 6.dp , inactiveColor = Color.DarkGray, activeColor = Color.Yellow,
                   modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
               )
           }
        }
    }
}