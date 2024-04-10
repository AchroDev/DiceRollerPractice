package com.achrodev.dicerollerpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.achrodev.dicerollerpractice.ui.theme.DiceRollerPracticeTheme

// Entry point of application
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerPracticeTheme {
                DiceRollerApp()
            }
        }
    }
}

// Code to build and run the preview of the app
@Preview (showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF4fa6a2))
        .wrapContentSize(Alignment.Center)
    )
}

// Function to structure the vertical layout and elements inside (Column,Image,Spacer,Button)
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

    // Observes the state of the number determined by the "roll"
    var result by remember {
        mutableStateOf(1)
    }

    // Changes the image of the die based on result
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // Structure/layout of the app
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(imageResource)
            , contentDescription = "1"
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = { result = (1..6).random()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF112322))
        ) {
            Text(stringResource(R.string.roll)
                , fontSize = 24.sp
                , fontFamily = FontFamily.Serif
                , color = Color(0xFFd2e8d4))
        }
    }
}