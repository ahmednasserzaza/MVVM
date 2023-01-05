package com.example.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        viewModel.getUserInfo()
        binding.buttonFetch.setOnClickListener {
            viewModel.getAWisdom()
        }

        viewModel.currentUser.observe(this){
            binding.textUsername.text = it.name
        }

        viewModel.wisdom.observe(this){
            binding.apply {
                textDate.text = it.publishDate
                textContent.text = it.content
            }
        }
    }



}
