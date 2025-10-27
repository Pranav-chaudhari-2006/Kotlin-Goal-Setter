package com.example.simplegoalsetter

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity is the first screen of the application.
 * It allows the user to input their goal.
 */
class MainActivity : AppCompatActivity() {

    // This function is called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the user interface layout for this Activity
        setContentView(R.layout.activity_main)

        // Initialize UI elements from the layout file.
        // --- FIX: Use the correct IDs from activity_main.xml ---
        val goalInput: EditText = findViewById(R.id.goalEditText)
        val setGoalButton: Button = findViewById(R.id.setGoalButton)

        // Set a click listener on the button to handle user interaction.
        setGoalButton.setOnClickListener {
            val goalText = goalInput.text.toString().trim()

            if (goalText.isEmpty()) {
                Toast.makeText(this, "Please enter your goal!", Toast.LENGTH_SHORT).show()
            } else {
                // Show the custom reward dialog
                showRewardDialog(goalText)
            }
        }
    }

    /**
     * Displays a large, centered dialog with a reward message.
     * After a short delay, it proceeds to the DisplayActivity.
     */
    private fun showRewardDialog(goalText: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_reward)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()

        // Use a Handler to delay the next action.
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
            // Proceed to the next screen
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("USER_GOAL", goalText)
            startActivity(intent)
        }, 1500) // 1.5-second delay
    }
}
