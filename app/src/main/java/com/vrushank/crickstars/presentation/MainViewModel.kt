package com.vrushank.crickstars.presentation

import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vrushank.crickstars.data.repository.TeamRepository
import kotlinx.coroutines.launch

class MainViewModel(val repo:TeamRepository):ViewModel() {
    var teamName by mutableStateOf("")
    var playerName by mutableStateOf("")
    var lastTeamId by mutableStateOf<Int?>(null)
    fun saveTeam(){
        viewModelScope.launch {
            val id = repo.insertTeam(teamName)
            lastTeamId = id
            teamName = ""
        }
    }
    fun savePlayer(){
        viewModelScope.launch {
            lastTeamId?.let {
                repo.insertPlayer(playerName,it)
                playerName = ""
            }
        }
    }
}