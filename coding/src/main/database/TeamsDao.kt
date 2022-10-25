package co.aladinjunior.tournamentsimulator.database

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface TeamsDao {

    @Insert
    fun insert(teams: Teams){

    }
}