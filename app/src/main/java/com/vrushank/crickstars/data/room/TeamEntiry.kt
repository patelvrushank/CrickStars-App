package com.vrushank.crickstars.data.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Team(
    @PrimaryKey(autoGenerate = true) val teamId:Int =0,
    val name:String
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = Team::class,
        parentColumns = ["teamId"],
        childColumns = ["teamOwnerId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Player(
    @PrimaryKey(autoGenerate = true) val playerId:Int = 0,
    val name: String,
    val teamOwnerId:Int
)