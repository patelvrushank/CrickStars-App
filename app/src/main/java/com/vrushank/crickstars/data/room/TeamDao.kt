package com.vrushank.crickstars.data.room

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Insert
    suspend fun insertTeam(team: Team):Long
    @Insert
    suspend fun insertPlayer(player: Player)

    @Query("SELECT * FROM Team")
    suspend fun getTeams():List<Team>

    @Query("SELECT * FROM Player WHERE teamOwnerId = :teamId")
    suspend fun getPlayersForTeam(teamId:Int):List<Player>

    @Transaction
    @Query("SELECT * FROM Team")
    fun getTeamsWithPlayers(): Flow<List<TeamWithPlayers>>

    @Query("DELETE FROM Player")
    suspend fun deleteAllPlayers()

    @Query("DELETE FROM Team")
    suspend fun deleteAllTeams()

}

data class TeamWithPlayers(
    @Embedded val team: Team,
    @Relation(
        parentColumn = "teamId",
        entityColumn = "teamOwnerId"
    )
    val players: List<Player>
)