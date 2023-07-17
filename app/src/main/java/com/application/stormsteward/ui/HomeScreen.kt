package com.application.stormsteward.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.stormsteward.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.game_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )

        Column(modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.title),
                contentDescription = null,
                modifier = modifier
                    .wrapContentSize(align = Alignment.TopCenter)
                    .size(250.dp)
                    .padding(top = 50.dp))

            Text(text = "Best score: 00000",
                fontSize = 30.sp,
                color = Color(0xFF255A89),
                modifier = modifier.padding(50.dp)
                )

            Spacer(modifier = modifier.weight(1f))

            Image(painter = painterResource(id = R.drawable.play),
                contentDescription = null,
                modifier = modifier.padding(bottom = 50.dp).size(120.dp),
                contentScale = ContentScale.Crop
                )

            Image(painter = painterResource(id = R.drawable.sound_on),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color =  Color(0xFF255A89)),
                modifier = modifier.padding(bottom = 50.dp).size(80.dp),
                contentScale = ContentScale.Crop)

        }
    }
}