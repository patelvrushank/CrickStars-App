package com.vrushank.crickstars.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vrushank.crickstars.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectTeamPlayers(teamInit: () -> String, teamName: (String) -> Unit, addTeamName: () -> Unit) {
//    Column(
//        horizontalAlignment = Alignment.Start,
//        verticalArrangement = Arrangement.Center
//    ) {
//        TextField()
//    }
    Box {
        Image(
            painter = painterResource(R.drawable.team_select_new),
            contentDescription = "Home Screen Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(50.dp)
                .fillMaxSize()
        ) {

            TextField(
                value = teamInit(),
                onValueChange = { teamName(it) },
                label = { Text("Team Name", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color(0xFF2E7D32),
                    focusedTextColor = Color(0xFF2E7D32),
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color(0xFF2E7D32),
                    unfocusedIndicatorColor = Color.Black

                )

            )

            Button(
                onClick = { addTeamName() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            ) {
                Text("Add Team",color = Color.White)
            }



            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = "",
                onValueChange = { },
                label = { Text("Player Name" ,color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color(0xFF2E7D32),
                    focusedTextColor = Color(0xFF2E7D32),
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color(0xFF2E7D32),
                    unfocusedIndicatorColor = Color.Black
                    )
            )

            Button(
                onClick = { },
                //enabled = viewModel.lastTeamId != null,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            ) {
                Text("Add Player to Team",color = Color.White)
            }
        }
    }
}