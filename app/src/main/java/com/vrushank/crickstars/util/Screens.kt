package com.vrushank.crickstars.util

sealed class Screens(val route:String, val title:String) {
    object Home:Screens("home","Home")
    object NewMatch:Screens("new_match","NewMatch")
    object SelectTeamPlayers:Screens("select_team_players","selectTeamPlayers")
}