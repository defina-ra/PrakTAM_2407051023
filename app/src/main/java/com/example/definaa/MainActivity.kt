package com.example.definaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.definaa.model.MenuItem
import com.example.definaa.model.MenuSource
import com.example.definaa.ui.theme.DefinaaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DefinaaTheme {
                DaftarMenuScreen()
            }
        }
    }
}

@Composable
fun DaftarMenuScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color(0xFFF1F8E9)),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "🥗 CheatDay+",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )

            Text(
                text = "Diet Tetap Sehat, Cheat Tetap Boleh!",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "⭐ Rekomendasi Populer",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(MenuSource.dummyMenu) { menu ->
                    MenuRowItem(menu = menu)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "📋 Daftar Menu Lengkap",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        items(MenuSource.dummyMenu) { menu ->
            DetailScreen(menu = menu)
        }
    }
}

@Composable
fun MenuRowItem(menu: MenuItem) {
    Card(
        modifier = Modifier.width(150.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = menu.imageRes),
                contentDescription = menu.nama,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = menu.nama,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = "${menu.kalori} kal",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFE65100)
                )
                Text(
                    text = if (menu.kategori == "Diet")
                        "🥗 Diet" else "🍔 Cheat",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (menu.kategori == "Diet")
                        Color(0xFF2E7D32) else Color(0xFFE53935)
                )
            }
        }
    }
}

@Composable
fun DetailScreen(menu: MenuItem) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Box {
                Image(
                    painter = painterResource(id = menu.imageRes),
                    contentDescription = menu.nama,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp
                            )
                        ),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { isFavorite = !isFavorite },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite)
                            Icons.Filled.Favorite
                        else
                            Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color.White
                    )
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    text = menu.nama,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = menu.deskripsi,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Text(
                        text = "🔥 ${menu.kalori} kal",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFE65100)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = if (menu.kategori == "Diet")
                            "🥗 Diet" else "🍔 Cheat Day",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (menu.kategori == "Diet")
                            Color(0xFF2E7D32) else Color(0xFFE53935)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Tambah ke Rencana Diet")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarMenuPreview() {
    DefinaaTheme {
        DaftarMenuScreen()
    }
}
