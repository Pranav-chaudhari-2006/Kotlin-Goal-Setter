package com.example.simplegoalsetter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplegoalsetter.databinding.ActivityDisplayBinding

class DisplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the goal text from the Intent
        val goal = intent.getStringExtra("GOAL_TEXT")

        // Set the goal text to the TextView
        binding.tvGoal.text = goal
    }
}