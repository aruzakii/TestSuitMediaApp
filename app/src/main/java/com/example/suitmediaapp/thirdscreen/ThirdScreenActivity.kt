package com.example.suitmediaapp.thirdscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.Resource
import com.example.core.ui.UserAdapter
import com.example.suitmediaapp.R
import com.example.suitmediaapp.databinding.ActivityThirdScreenBinding
import com.example.suitmediaapp.secondscreen.SecondScreenActivity
import com.google.android.material.appbar.MaterialToolbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdScreenActivity : AppCompatActivity() {
    private val thirdViewModel:ThirdScreenViewModel by viewModel()
    private lateinit var binding: ActivityThirdScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<MaterialToolbar>(R.id.menuActivity)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val name =  intent.getStringExtra("EXTRA_NAME")
        val userAdapter = UserAdapter()
        userAdapter.onItemClick = { selectedData ->
            val intent = Intent(this,SecondScreenActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_USERNAME", "${selectedData.firstName} ${selectedData.lastName}")
            startActivity(intent)
            finish()
        }

        thirdViewModel.users.observe(this){user ->
            if (user != null) {
                when (user) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        userAdapter.setData(user.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
//                        binding.viewError.root.visibility = View.VISIBLE
//                        binding.viewError.tvError.text = tourism.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        }

        with(binding.rvUsers) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = userAdapter
        }

    }
}