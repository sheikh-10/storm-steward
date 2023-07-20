package com.application.stormsteward.ui

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.stormsteward.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameOverScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.game_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )


        Column(modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)) {

            Text(text = "Game Over",
                modifier = modifier
                    .wrapContentSize(align = Alignment.TopCenter)
                    .padding(top = 50.dp, start = 50.dp, end = 50.dp),
                fontSize = 72.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color.White
                )

            Text(text = "Time: 00:00",
                fontSize = 38.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Text(text = "Best score: 00000",
                fontSize = 38.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = modifier.weight(1f))

            Row(
                modifier = modifier.fillMaxWidth().wrapContentWidth(align = Alignment.CenterHorizontally).padding(bottom = 100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                IconButton(
                    onClick = {},
                    modifier = modifier.size(100.dp)) {

                    Image(painter = painterResource(id = R.drawable.ic_return),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color =  Color.White),
                        contentScale = ContentScale.Crop,
                        modifier = modifier.size(160.dp)
                    )
                }

                IconButton(
                    onClick = {},
                    modifier = modifier.size(100.dp)) {

                    Image(painter = painterResource(id = R.drawable.home),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color =  Color.White),
                        contentScale = ContentScale.Crop,
                        modifier = modifier.size(160.dp),
                    )
                }
            }
        }
    }
}