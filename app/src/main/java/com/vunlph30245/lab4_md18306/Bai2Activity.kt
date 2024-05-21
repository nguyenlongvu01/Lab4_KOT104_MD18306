package com.vunlph30245.lab4_md18306

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class Bai2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listImg = listOf(R.drawable.img01, R.drawable.img01, R.drawable.img01)


        setContent {

            Column (modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Icon(
                    painter = painterResource(id =
                    R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo"
                )

                HorizontalImageList(imageList = listImg)
                VerticalImageList(imageList = listImg)
            }
        }
    }

    @Composable
    fun HorizontalImageList(imageList: List<Int>) {
        val scrollState = rememberScrollState()
        Row(modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(16.dp)) {
            imageList.forEachIndexed { index, image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Image Description",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .padding(
                            start = if (index == 0) 0.dp else 8.dp,
                            end = 8.dp
                        )
                )
            }
        }
    }

    @Composable
    fun VerticalImageList(imageList: List<Int>) {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier
            .verticalScroll(scrollState)
            .padding(16.dp)) {
            imageList.forEachIndexed { index, image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Image Description",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .padding(
                            top = if (index == 0) 0.dp else 8.dp,
                            bottom = 8.dp
                        )
                )
            }
        }
    }
}