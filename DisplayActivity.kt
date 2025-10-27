package com.example.simplegoalsetter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * DisplayActivity is the second screen of the application.
 * It receives the user's goal from MainActivity and displays it along with a motivational quote.
 */
class DisplayActivity : AppCompatActivity() {

    // This function is called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the user interface layout for this Activity
        setContentView(R.layout.activity_display)

        // Initialize the UI elements from the layout file using the CORRECT IDs.
        val goalTextView: TextView = findViewById(R.id.goalDisplayText)
        val quoteTextView: TextView = findViewById(R.id.quoteTextView)

        // Get the Intent that started this activity and extract the goal string.
        val userGoal = intent.getStringExtra("USER_GOAL")

        // Set the user's goal on the TextView.
        goalTextView.text = userGoal

        // An array of strong, crisp, action-oriented motivational quotes.
        val quotes = arrayOf(
            "Today is your opportunity to build the tomorrow you want.",
            "Success is the sum of small efforts, repeated day in and day out. Today is day one.",
            "Don't just count the hours. Make the hours count. Start now.",
            "The work you do today is the foundation of your future success.",
            "A year from now, you will wish you had started today. So, start."
        )

        // Select a random quote and display it.
        val randomQuote = quotes.random()
        quoteTextView.text = randomQuote
    }
}
