package com.vrushank.crickstars.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

@Database(entities = [Team::class,Player::class], version = 1)
abstract class PlayerDataBase :RoomDatabase(){
    abstract fun teamDao():TeamDao

    companion object{
        @Volatile
        private var INSTANCE:PlayerDataBase?= null
        fun getInstance(context: Context):PlayerDataBase{
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    PlayerDataBase::class.java,
                    "cricket database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}