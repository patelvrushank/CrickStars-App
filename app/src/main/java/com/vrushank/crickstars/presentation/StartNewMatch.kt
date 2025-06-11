package com.vrushank.crickstars.presentation

import android.content.res.Resources
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vrushank.crickstars.R
import com.vrushank.crickstars.data.room.TeamWithPlayers
import com.vrushank.crickstars.util.ScreenHeading
import com.vrushank.crickstars.util.Screens
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun StartNewMatch(
    onclickTeam1: (String) -> Unit,
    onlclickTeam2: (String) -> Unit
) {

    Box {
        Image(
            painter = painterResource(R.drawable.start_new_match_background),
            contentDescription = "Home Screen Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(top = 30.dp)) {
            ScreenHeading("New Match")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(50.dp)
                .fillMaxSize()
        ) {

            Button(
                onClick = { onclickTeam1(Screens.SelectTeamPlayers.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                modifier = Modifier.fillMaxWidth()
            )
            { Text(text = "Select Team 1", color = Color.White) }
            Spacer(Modifier.height(50.dp))
            Button(
                onClick = { onlclickTeam2(Screens.SelectTeamPlayers.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                modifier = Modifier.fillMaxWidth()
            )
            { Text(text = "Select Team 2", color = Color.White) }


        }


    }
}