package com.example.definaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.definaa.model.MenuSource
import com.example.definaa.ui.theme.DefinaaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DefinaaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Defina Rahmayanti",
                        npm = "2407051023",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, npm: String, modifier: Modifier = Modifier) {
    val daftarMenu = MenuSource.dummyMenu

    Column(modifier = modifier.padding(16.dp)) {

        Text(text = "Nama: $name", fontWeight = FontWeight.Bold)
        Text(text = "NPM: $npm")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Menu Diet", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        daftarMenu.forEach { menu ->


            Image(
                painter = painterResource(id = menu.imageRes),
                contentDescription = menu.nama,
                modifier = Modifier
                    .size(120.dp)
                    .padding(4.dp)
            )

            Text(text = "Nama: ${menu.nama}", fontWeight = FontWeight.Bold)
            Text(text = "Kalori: ${menu.kalori} kal")
            Text(text = "Kategori: ${menu.kategori}")
            Text(text = "Info: ${menu.deskripsi}")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefinaaTheme {
        Greeting("Defina Rahmayanti", npm = "2407051023")
    }
}