package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BirthdayCard()

                }
            }
        }
    }
}


//Reference to Lottie Code:
// https://www.geeksforgeeks.org/kotlin/lottie-animation-in-android-jetpack-compose/
@Composable
fun BirthdayCard(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.navy_background_confetti),
            contentDescription = "Confetti background. Designed by kjpargeter / Freepik",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )


        //Happy Birthday animation: Free to use under the Lottie Simple License
        //https://lottiefiles.com/free-animation/happy-birthday-3X525ZLxwk
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.happy_birthday)
        )
        val progress by animateLottieCompositionAsState(
            composition,
            iterations = LottieConstants.IterateForever,
            speed = .9f
        )

        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(120.dp))
            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier.size(250.dp)
            )
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = stringResource(id = R.string.birthday_greeting),
                color = Color(0xFFFF4691),
                fontSize = 25.sp,
                fontFamily = FontFamily.Cursive,
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(id = R.string.sender),
                color = Color(0xFFFF4691),
                fontSize = 25.sp,
                fontFamily = FontFamily.Cursive
            )
        }


    }

}

