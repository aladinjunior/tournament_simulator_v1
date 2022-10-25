package co.aladinjunior.tournamentsimulator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "team_entity")
data class Teams(
    @PrimaryKey(autoGenerate = true)
     val id: Int = 0,
    @ColumnInfo(name="sport")
     val sport: String,
    @ColumnInfo(name="winner")
     val winner: String
    )
