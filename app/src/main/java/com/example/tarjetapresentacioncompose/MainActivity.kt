package com.example.tarjetapresentacioncompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacioncompose.ui.theme.TarjetaPresentacionComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TarjetaPresentacionComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =MaterialTheme.colorScheme.background
                ) {
                TarjetaComposer()
                }
            }
        }
    }
}

@Composable
fun TarjetaComposer(){
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally){
        TarjetaCentral(
            nombre = stringResource(R.string.nombre),
            titulo = stringResource(R.string.profesion),
            icono = painterResource(R.drawable.android_logo)
        )
        TarjetaInferior(
            tel = stringResource(R.string.telefono),
            con = stringResource(R.string.contacto),
            em = stringResource(R.string.email)
        )
    }
}


/*
Composable Card which takes care of the picture, name and profession, change your name and title in the string nombre and profession
 */
@Composable
fun TarjetaCentral(nombre: String, titulo: String, icono: Painter, modifier: Modifier = Modifier){
    Column (modifier = Modifier.padding(top = 200.dp, bottom = 130.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = icono,
            contentDescription = null,
            modifier
                .background(colorResource(R.color.azuloscuro))
                .width(150.dp)
                .height(150.dp)
                .align(Alignment.CenterHorizontally),
        )
        Text(
            text = nombre,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
        Text(
            text = titulo,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 25.sp)
    }
}
/*
Composable Card that takes care of the information, change your phone number, email and prefered contact in 'Telefono', 'email' and 'contacto'
 */
@Composable
fun TarjetaInferior(tel : String, con: String, em: String, modifier: Modifier = Modifier){
Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
    Row (modifier= Modifier.fillMaxWidth().padding(start = 40.dp)){
        Icon(
            painter = painterResource(R.drawable.baseline_phone_24),
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier =Modifier.padding(start = 25.dp)
        )
        Text(
            text = tel,
            modifier.padding(start = 25.dp)
        )
    }
    Row(modifier= Modifier.fillMaxWidth().padding(start = 40.dp)) {
        Icon(
            painter = painterResource(R.drawable.baseline_hub_24),
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier =Modifier.padding(start = 25.dp)
        )
        Text(text = con,
            modifier.padding(start = 25.dp))
    }
    Row(modifier= Modifier.fillMaxWidth().padding(start = 40.dp)) {
        Icon(
            painter = painterResource(R.drawable.baseline_alternate_email_24),
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier =Modifier.padding(start = 25.dp)
        )
        Text(text = em,
            modifier.padding(start = 25.dp)
            )
    }
}
}
@Preview(showBackground = true)
@Composable
fun TarjetaPreview() {
    TarjetaPresentacionComposeTheme {
        TarjetaComposer()
    }
}