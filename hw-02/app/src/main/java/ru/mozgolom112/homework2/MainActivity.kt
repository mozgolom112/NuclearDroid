package ru.mozgolom112.homework2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mozgolom112.homework2.ui.theme.HomeWork2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeWork2Theme {
                RandomColorScreen()
            }
        }
    }
}

@Composable
fun RandomColorScreen() {
    var backgroundColorInt by rememberSaveable { mutableIntStateOf(Color.White.toArgb()) }

    val backgroundColor = Color(backgroundColorInt)

    val hexCode = remember(backgroundColor) {
        "#%02X%02X%02X".format(
            (backgroundColor.red * 255).toInt(),
            (backgroundColor.green * 255).toInt(),
            (backgroundColor.blue * 255).toInt()
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = hexCode,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { backgroundColorInt = generateRandomColor().toArgb() }
            ) {
                Text("Случайный цвет")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { backgroundColorInt = Color.White.toArgb() }
            ) {
                Text("Сбросить цвет (белый)")
            }
        }
    }
}

private fun generateRandomColor(): Color {
    val r = Random.nextInt(0, 256)
    val g = Random.nextInt(0, 256)
    val b = Random.nextInt(0, 256)
    return Color(r, g, b)
}

@Preview(showBackground = true)
@Composable
fun RandomColorScreenPreview() {
    HomeWork2Theme {
        RandomColorScreen()
    }
}