package uz.ictschool.mathkomil.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.ictschool.mathkomil.R
import uz.ictschool.mathkomil.navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {


    Box(modifier = Modifier.fillMaxSize()){    Image(
        painter = painterResource(id = R.drawable.bbbb),        contentDescription = "Background",
        contentScale = ContentScale.FillBounds,        modifier = Modifier.matchParentSize()
    )}
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Select Mode",
            fontSize = 27.sp,
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp), onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "easy")
            )
        }) {
            Text(text = "Easy")
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp), onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "medium")
            )
        }) {
            Text(text = "Medium")
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp), onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "hard")
            )
        }) {
            Text(text = "Hard")
        }
    }
}