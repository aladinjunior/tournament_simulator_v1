package co.aladinjunior.tournamentsimulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import co.aladinjunior.tournamentsimulator.database.Teams
import com.example.tournamentsimulator.R
import java.util.*

class BasketActivity : AppCompatActivity() {

    private lateinit var bttn: Button
    private lateinit var txtField1: EditText
    private lateinit var txtField2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        bttn = findViewById(R.id.play_bttn)
        txtField1 = findViewById(R.id.team1_name)
        txtField2 = findViewById(R.id.team2_name)

        val team1 = txtField1.text
        val team2 = txtField2.text


        val randNum = (0..9).random() % 2

        bttn.setOnClickListener {
            val winner: Editable?
            if (randNum == 0) winner = team2 else winner = team1

            AlertDialog.Builder(this)
                .setMessage(getString(R.string.winner_message, winner))
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setNegativeButton(R.string.save_button) { _, _ ->
                    Thread {
                        val app = application as App
                        val dao = app.database.teamsDao()
                        dao.insert(Teams(sport = "BasketBall", winner = winner.toString()))
                        runOnUiThread {
                            Toast.makeText(this, R.string.saved_toast, Toast.LENGTH_LONG).show()
                        }
                    }.start()


                }
                .create()
                .show()
        }
    }

}






