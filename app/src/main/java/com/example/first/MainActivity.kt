package com.example.first

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

import com.example.first.ui.theme.FirstTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val testDataSet = listOf(
            "팡무" to "kisa002",
            "태원" to "boy",
            "잔다르크" to "janjan",
            "비와이" to "bewhy",
            "팡무" to "kisa002",
            "태원" to "boy",
            "잔다르크" to "janjan",
            "비와이" to "bewhy",
            "팡무" to "kisa002",
            "태원" to "boy",
            "잔다르크" to "janjan",
            "비와이" to "bewhy",
            "팡무" to "kisa002",
            "태원" to "boy",
            "잔다르크" to "janjan",
            "비와이" to "bewhy"
        )

        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                var isFavorite by remember {
                    mutableStateOf(false)
                }





                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            finish()
                        }
                    )
                    Text(text = "Title", fontSize = 24.sp)
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            isFavorite = !isFavorite
                        },
                        tint = if (isFavorite) Color.Red else Color.Black
                    )
                }
                Divider(color = Color.Black, thickness = 1.dp)

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    testDataSet.forEach {
                        Profile(name = it.first, id = it.second)
                    }
                }
            }
        }
    }

    @Composable
    private fun Profile(name: String, id: String) {
        var isExpanded by remember {
            mutableStateOf(false)
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF9C0EAF),
                            Color(0xFF1A184C)
                        )
                    )
                )
                .padding(15.dp)
                .clickable {
                    isExpanded = !isExpanded
                }
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.size(60.dp)
                    )
                    Column(
                        modifier = Modifier.padding(start = 20.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = name,
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "@$id", color = Color.DarkGray, fontSize = 13.sp, modifier = Modifier.clickable {
                            startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://search.naver.com/search.naver?query=$id")
                                )
                            )
                        })
                    }
                }

                AnimatedVisibility(visible = isExpanded) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(text = "게시글 수 : 100개")
                            Text(text = "팔로워 수 : 50명")
                            Text(text = "팔로우 수 : 30명")
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = null)
                            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    startActivity(
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("tel:080-335-0020")
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}