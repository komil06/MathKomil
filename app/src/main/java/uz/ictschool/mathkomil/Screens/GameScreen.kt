package uz.ictschool.mathkomil.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.ictschool.mathkomil.Model.Game
import uz.ictschool.mathkomil.Model.SharedPreference
import uz.ictschool.mathkomil.R
import uz.ictschool.mathkomil.navigation.Screens

@Composable
fun GameScreen(navController: NavController, mode: String, name: String) {
    val context = LocalContext.current
    val limit = 60
    var tasks by remember { mutableIntStateOf(1) }
    var hint by remember { mutableStateOf(Game().getRandom(1..50)) }
    val time = remember { mutableIntStateOf(limit) }
    var score by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (time.intValue > 0) {
            delay(1000)
            time.intValue--
            if (time.intValue == 0) {
                SharedPreference(context).addRecord(name, score)
                navController.navigate(
                    route = Screens.Result.getFullRoute(
                        score = score, tasks = tasks
                    )
                )
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id =  R.drawable.screen),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize(),
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = hint.first,
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "$score Coin",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "00:${time.intValue}",
                fontSize = 27.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 45.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp),
                    onClick = {
                        if ("$first".toInt()*"$second".toInt() == "$correct_answer") {
                            score++
                        } else {
                            score--
                        }
                        tasks++
                    },
                ) {
                    Text(
                        text = correct_answer,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Button(
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp),
                    onClick = {
                        if (hint == correct_answer) {
                            score++
                        } else {
                            score--
                        }
                        hint = Game().getRandom(1..50)
                        tasks++
                    },
                ) {
                    Text(
                        text = hint,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Button(
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp),
                    onClick = {
                        if (hint == correct_answer) {
                            score++
                        } else {
                            score--
                        }
                        hint = Game().getRandom(1..50)
                        tasks++
                    },
                ) {
                    Text(
                        text = hint,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Button(
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp),
                    onClick = {
                        if (hint == correct_answer) {
                            score++
                        } else {
                            score--
                        }
                        hint = Game().getRandom(1..50)
                        tasks++
                    },
                ) {
                    Text(
                        text = hint,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}
