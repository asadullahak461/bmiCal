package com.example.bmicalculator

import android.R
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.example.bmicalculator.databinding.ActivityMainBinding
import com.example.bmicalculator.room.AppDatabase
import com.example.bmicalculator.room.DatabaseBuilder
import com.example.bmicalculator.room.data
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = DatabaseBuilder.getInstance(this)







        binding.calculateBMI.setOnClickListener {
            binding.spinKit.visibility = View.VISIBLE
            val weight: Float = binding.weightet.text.toString().toFloat()
            val height: Float = binding.heightet.text.toString().toFloat()
            val age: Float = binding.ageet.text.toString().toFloat()
            val bmi: Float = 703 * weight / (height * height)
            Handler(Looper.getMainLooper()).postDelayed(5000) {
                // Do something
                try {
                    val myObj =
                        data(weight = weight, height = height, age = age, bmi = bmi, name = "asad")
                    database.dao().insertLogin(myObj)

                    binding.spinKit.visibility = View.GONE

                } catch (e: Exception) {
                    Toast.makeText(this, "Same Name Cannot Be Added", Toast.LENGTH_SHORT).show()
                    binding.spinKit.visibility = View.GONE
                }

            }
        }

    }

}
