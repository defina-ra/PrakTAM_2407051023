package com.example.definaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF1F8E9))
            .padding(16.dp)
    ) {
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

        MenuSource.dummyMenu.forEach { menu ->
            DetailScreen(menu = menu)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun DetailScreen(menu: MenuItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Image(
                painter = painterResource(id = menu.imageRes),
                contentDescription = menu.nama,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    text = menu.nama,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = menu.deskripsi,
                    fontSize = 14.sp,
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