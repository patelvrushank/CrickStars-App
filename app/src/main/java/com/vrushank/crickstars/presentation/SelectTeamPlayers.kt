package com.vrushank.crickstars.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vrushank.crickstars.R
import com.vrushank.crickstars.data.room.TeamWithPlayers
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectTeamPlayers(
    teamInit: () -> String,
    teamName: (String) -> Unit,
    addTeamName: () -> Unit,
    teamsList: StateFlow<List<TeamWithPlayers>>,
    delete: () -> Unit,
    playerInit: () -> String,
    playerName : (String) -> Unit,
    addPlayerName:() -> Unit
) {
//    Column(
//        horizontalAlignment = Alignment.Start,
//        verticalArrangement = Arrangement.Center
//    ) {
//        TextField()
//    }

    val teams by teamsList.collectAsState()
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
                label = {
                    Text(
                        "Team Name",
                        color = Color(0xFF2E7D32),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color(0xFF2E7D32),
                    focusedTextColor = Color(0xFF2E7D32),
                    unfocusedTextColor = Color(0xFF4CAF50),
                    cursorColor = Color(0xFF2E7D32),
                    unfocusedIndicatorColor = Color.Black

                )

            )

            Button(
                onClick = { addTeamName() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Add Team", color = Color.White)
            }



            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value =playerInit(),
                onValueChange = { playerName(it)},
                label = {
                    Text(
                        "Player Name",
                        color = Color(0xFF2E7D32),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color(0xFF2E7D32),
                    focusedTextColor = Color(0xFF2E7D32),
                    unfocusedTextColor = Color(0xFF4CAF50),
                    cursorColor = Color(0xFF2E7D32),
                    unfocusedIndicatorColor = Color.Black
                )
            )

            Button(
                onClick = { addPlayerName()},
                //enabled = viewModel.lastTeamId != null,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Add Player to Team", color = Color.White)
            }

            Button(
                onClick = { delete() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Remove all",color = Color.White)
            }

            LazyColumn(modifier = Modifier.padding(16.dp).background(Color(0xFF2E7D32))) {
                items(teams) { teamWithPlayers ->
                    Text(
                        "Team: ${teamWithPlayers.team.name}",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )

                    teamWithPlayers.players.forEach { player ->
                        Text(" - ${player.name}", color = Color.White,modifier = Modifier.padding(start = 16.dp))
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

        }
    }
}