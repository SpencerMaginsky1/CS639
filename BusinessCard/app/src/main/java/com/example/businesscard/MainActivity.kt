package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFADD8E6)) {
                    BusinessCard()

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCard(){
    val businessCardIcons = Icons.Rounded
    Column(modifier = Modifier.fillMaxSize().padding(40.dp),
        verticalArrangement  = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column (modifier = Modifier
            .padding(all = 4.dp)
            .fillMaxWidth()
            .size(width = 300.dp, height = 300.dp),
/*            .border(
                width = 2.dp,
                color = Color.Red,
                shape = RoundedCornerShape(4.dp)
            ),*/
            verticalArrangement  = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
/*                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(4.dp)
                ),*/
                horizontalArrangement = Arrangement.Center){
                // Image
                Image(
                    painter = painterResource(R.drawable.sm_profile_picture),
                    contentDescription = "BusinessCard Headshot",
                    modifier = Modifier
                        .size(200.dp)
                )

            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
/*                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(4.dp)
                ),*/
                horizontalArrangement = Arrangement.Center){
                // Name
                Text(
                    text = stringResource(id = R.string.name),
                    color = Color.Black,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 35.sp

                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
/*                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(4.dp)
                ),*/
                horizontalArrangement = Arrangement.Center){
                // Title
                Text(
                    text = stringResource(id = R.string.title),
                    color = Color.Black,
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(150.dp))

        Column (modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .size(width = 300.dp, height = 125.dp),
/*            .border(
                width = 2.dp,
                color = Color.Red,
                shape = RoundedCornerShape(8.dp)
            ),*/
            verticalArrangement  = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally){
            Row(modifier = Modifier
                .fillMaxWidth(),
/*                .padding(2.dp)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(8.dp)
                ),*/
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){

                Column(modifier = Modifier
                    .padding(5.dp)
                    .width(30.dp),
/*                    .border(
                        width = 2.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(8.dp)
                    ),*/
                    horizontalAlignment = Alignment.CenterHorizontally){
                    // Title
                    Icon(
                        imageVector = businessCardIcons.Phone,
                        contentDescription = "Phone icon",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )


                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
/*                    modifier = Modifier.border(
                        width = 2.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(8.dp)
                    ),*/
                    text = stringResource(id = R.string.phone),
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp
                )

            }
            Row(modifier = Modifier
                .fillMaxWidth(),
/*                .padding(2.dp)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(8.dp)
                ),*/
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){

                Column(modifier = Modifier
                    .padding(5.dp)
                    .width(30.dp),
/*                    .border(
                        width = 2.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(8.dp)
                    ),*/
                    horizontalAlignment = Alignment.CenterHorizontally){
                    // Title
                    Icon(
                        imageVector = businessCardIcons.Share,
                        contentDescription = "Share icon",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )


                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
/*                    modifier = Modifier.border(
                        width = 2.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(8.dp)
                    ),*/
                    text = stringResource(id = R.string.social),
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp
                )

            }
            Row(modifier = Modifier
                .fillMaxWidth(),
/*                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(8.dp)
                ),*/
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){

                Column(modifier = Modifier
                    .padding(5.dp)
                    .width(30.dp),
/*                    .border(
                        width = 2.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(8.dp)
                    ),*/
                    horizontalAlignment = Alignment.CenterHorizontally){
                    // Title
                    Icon(
                        imageVector = businessCardIcons.Email,
                        contentDescription = "Email icon",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )


                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
/*                    modifier = Modifier.border(
                        width = 2.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(8.dp)
                    ),*/
                    text = stringResource(id = R.string.email),
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp
                )

            }
        }
    }

}
