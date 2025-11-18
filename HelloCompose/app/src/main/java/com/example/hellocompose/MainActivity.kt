package com.example.hellocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                //scaffold ui yg mencakup semua activity
                Scaffold(modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    CountView()
                    //konsep reusable

                }
            }
        }
    }
}
//fungsi yg menampilkan konten
//@Composable //penanda ke kotlin ini fungsi composable ui
//fun HelloCompose() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center) {
//
//        Text(
//            text = "Hello world",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold
//        )
//
//    }
//}

@Composable
fun CountView() {
    var ctx = LocalContext.current

    //state
    var count by rememberSaveable { mutableStateOf(0) }



    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
        Box(modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center){
            Text(
                text = "Count: ${count}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)

        ){
            Button(
                onClick = {
                    Toast.makeText(
                        ctx,
                        "Count ${count}",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Toast",
                    fontSize = 18.sp
                )
            }
            Button(
                onClick = { count++},
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Count",
                    fontSize = 18.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CountPreview() {
    CountView()
}


//untuk preview


