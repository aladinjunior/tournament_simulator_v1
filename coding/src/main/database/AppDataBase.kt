package co.aladinjunior.tournamentsimulator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Teams::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun teamsDao(): TeamsDao

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getAppDatabase(context: Context): AppDataBase {
            return if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "tournament_simulator"
                    ).build()
                }
                INSTANCE as AppDataBase
            } else {
                INSTANCE as AppDataBase
            }
        }

    }
}
