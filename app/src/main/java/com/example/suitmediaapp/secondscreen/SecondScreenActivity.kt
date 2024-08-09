package com.example.suitmediaapp.secondscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.suitmediaapp.R
import com.example.suitmediaapp.databinding.ActivitySecondScreenBinding
import com.example.suitmediaapp.thirdscreen.ThirdScreenActivity
import com.google.android.material.appbar.MaterialToolbar

class SecondScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<MaterialToolbar>(R.id.menuActivity)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val name =  intent.getStringExtra("EXTRA_NAME")
        val usernamechoose = intent.getStringExtra("EXTRA_USERNAME")



        binding.tvName.text = name


        binding.chooseBut.setOnClickListener {
            var intent = Intent(this,ThirdScreenActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            startActivity(intent)
            if (usernamechoose != null) {
                if (usernamechoose.isNotEmpty()){
                    finish()
                }

            }
        }

        if (usernamechoose != null) {
            if (usernamechoose.isNotEmpty())
                binding.tvSelecteduser.text = usernamechoose.toString()
        }

    }
}