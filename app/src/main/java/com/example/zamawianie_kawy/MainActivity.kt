package com.example.zamawianie_kawy

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val kawaespresso = findViewById<RadioButton>(R.id.espresso)
        val kawacapuccino = findViewById<RadioButton>(R.id.capuccino)
        val kawalatte = findViewById<RadioButton>(R.id.latte)
        val azdjecie = findViewById<ImageView>(R.id.zdjecie)
        kawaespresso.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                azdjecie.setImageResource(R.drawable.espresso)
            }
        }

        kawacapuccino.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                azdjecie.setImageResource(R.drawable.capuccino)
            }
        }

        kawalatte.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                azdjecie.setImageResource(R.drawable.latte)
            }
        }

        val seekBar = findViewById<SeekBar>(R.id.ilosc)
        val ilosckaw = findViewById<TextView>(R.id.ilosckaw)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                ilosckaw.text = "Ile kaw chcesz zamówić: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        val zakup = findViewById<Button>(R.id.przycisk)
        val mleczko = findViewById<CheckBox>(R.id.mleko)
        val cuker = findViewById<CheckBox>(R.id.cukier)

        zakup.setOnClickListener {
            if (mleczko.isChecked && cuker.isChecked) {
                if (kawaespresso.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Espresso, +cukier, +mleko", Toast.LENGTH_SHORT).show()
                } else if (kawacapuccino.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Capuccino, +cukier, +mleko", Toast.LENGTH_SHORT).show()
                } else if (kawalatte.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Latte, +cukier, +mleko", Toast.LENGTH_SHORT).show()
                }
            }
            if (mleczko.isChecked && !cuker.isChecked) {
                if (kawaespresso.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Espresso, +mleko", Toast.LENGTH_SHORT).show()
                } else if (kawacapuccino.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Capuccino, +mleko", Toast.LENGTH_SHORT).show()
                } else if (kawalatte.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Latte, +mleko", Toast.LENGTH_SHORT).show()
                }

            }
            if(!mleczko.isChecked && cuker.isChecked){
                if (kawaespresso.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Espresso, +cukier", Toast.LENGTH_SHORT).show()
                } else if (kawacapuccino.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Capuccino, +cukier", Toast.LENGTH_SHORT).show()
                } else if (kawalatte.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Latte, +cukier", Toast.LENGTH_SHORT).show()
                }
            }
            if(!mleczko.isChecked && !cuker.isChecked){
                if (kawaespresso.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Espresso", Toast.LENGTH_SHORT).show()
                } else if (kawacapuccino.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Capuccino", Toast.LENGTH_SHORT).show()
                } else if (kawalatte.isChecked) {
                    Toast.makeText(this, "${seekBar.progress} - Latte", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}