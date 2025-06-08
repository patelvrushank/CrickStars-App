package com.vrushank.crickstars.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface TeamDao {
    @Insert
    suspend fun insertTeam(team: Team):Long
    @Insert
    suspend fun insertPlayer(player: Player)
    @Query("SELECT * FROM TEAM")
    suspend fun getTeams():List<Team>
    @Query("SELECT * FROM Player WHERE teamOwnerId = :teamId")
    suspend fun getPlayersForTeam(teamId:Int):List<Player>

}