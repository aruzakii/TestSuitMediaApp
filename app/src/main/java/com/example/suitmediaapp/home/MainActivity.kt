package com.example.suitmediaapp.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suitmediaapp.secondscreen.SecondScreenActivity
import com.example.suitmediaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextBut.setOnClickListener {
            if (binding.inputName.text.toString().isNotEmpty()){
                val intent = Intent(this, SecondScreenActivity::class.java)
                intent.putExtra("EXTRA_NAME", binding.inputName.text.toString())
                startActivity(intent)
            }else{
                showToast("Field Name Tidak Boleh Kosong")
            }

        }

        binding.checkBut.setOnClickListener {
            if (binding.inputPalindrom.text.toString().isNotEmpty()){
                if (isPalindrome(binding.inputPalindrom.text.toString())){
                    showToast("isPalindrom")
                }else{
                    showToast("not palindrome")
                }
            }else{
                showToast("Field Polindrom Tidak Boleh Kosong")
            }

        }
    }

    private fun isPalindrome(s: String): Boolean {
        val cleanString = s.replace("\\s".toRegex(), "").lowercase()
        return cleanString == cleanString.reversed()
    }

    private fun showToast(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}


