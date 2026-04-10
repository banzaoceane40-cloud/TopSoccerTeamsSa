package za.ac.iie.topsoccerteamsa

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

//created functions to display array values
fun LogArrValues(arr: Array<String>, limit: Int =0){
    //if statement to check if there is a limit - if there is a limit, cut the array at that index
    if (limit == 0) {
        Log.v("Array values: ", Arrays.toString(arr))
    }
    else
    {
        Log.v("Arrayvalues:", Arrays.toString(arr.sliceArray(0..limit)))
    }
}

class MainActivity : AppCompatActivity() {

    val teams = arrayOf<String>("Mam Sundowns FC", "Orlando Pirates", "Bidvest wists",
        "Stellenbosch FC", "Sek united FC")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val teamsTxt = findViewById<TextView>(R.id.teamsTxt)
        var teamsDisplay = ""
        var count = 0

        //calling LogArrValues functions to log array values
        LogArrValues(teams)

        //re-assigning position 0 of the teams array
        teams [0] = "Man sundowns FC :)"


//        while (count < teams.count()){
//            teamsDisplay += "${teams[count]}\n"
//            count++
//        }

        //for loop to iterate through the team array and display then
        for (team in teams){
            teamsDisplay += "${teams}\n"
        }

        //displaying top soccer team in text view Ui
        teamsTxt.text = Arrays.toString(teams)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}