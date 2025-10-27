package com.example.simplegoalsetter

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simplegoalsetter.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // This is the code that ACTUALLY activates the animation
        val shootingStarAnimation = AnimationUtils.loadAnimation(this, R.anim.shooting_star)
        binding.shootingStar.clearAnimation()
        binding.shootingStar.startAnimation(shootingStarAnimation)


        binding.btnSetGoal.setOnClickListener {
            val goal = binding.etGoal.text.toString()

            if (goal.isNotEmpty()) {
                showRewardDialog(goal)
            } else {
                Toast.makeText(this, "Please enter a goal", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showRewardDialog(goal: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_reward)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.setDimAmount(0.7f)
        dialog.show()

        // Automatically dismiss the dialog and start the next activity after a delay
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("GOAL_TEXT", goal)
            startActivity(intent)
        }, 2000) // 2-second delay
    }
}