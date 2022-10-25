package co.aladinjunior.tournamentsimulator

import android.app.Application
import co.aladinjunior.tournamentsimulator.database.AppDataBase

class App : Application() {

     lateinit var database: AppDataBase

    override fun onCreate() {
        super.onCreate()

        database = AppDataBase.getAppDatabase(this)
    }
}