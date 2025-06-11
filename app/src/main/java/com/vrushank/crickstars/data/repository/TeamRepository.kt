package com.vrushank.crickstars.data.repository

import com.vrushank.crickstars.data.room.Player
import com.vrushank.crickstars.data.room.Team
import com.vrushank.crickstars.data.room.TeamDao
import com.vrushank.crickstars.data.room.TeamWithPlayers
import kotlinx.coroutines.flow.Flow

class TeamRepository(val dao:TeamDao) {
    suspend fun insertTeam(name:String):Int{
        val id = dao.insertTeam(Team(name = name))
        return id.toInt()
    }
    suspend fun insertPlayer(name:String, teamId:Int){
        dao.insertPlayer(Player(name=name, teamOwnerId = teamId))
    }
    suspend fun getTeams():List<Team> = dao.getTeams()
    suspend fun getPlayersForTeam(teamId: Int):List<Player> = dao.getPlayersForTeam(teamId)

    val teamsWithPlayers :Flow<List<TeamWithPlayers>> = dao.getTeamsWithPlayers()

    suspend fun deleteAllData() {
        dao.deleteAllPlayers()
        dao.deleteAllTeams()
    }
}