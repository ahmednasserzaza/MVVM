package com.example.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setup()
    }


    private fun setup() {
        viewModel.getUserInfo()
        binding.buttonFetch.setOnClickListener {
            viewModel.getAWisdom()
        }


        // I replaced this code by dataBinding
//        viewModel.currentUser.observe(this){
//            binding.textUsername.text = it.name
//        }

//        viewModel.wisdom.observe(this){
//            binding.apply {
//                textDate.text = it.publishDate
//                textContent.text = it.content
//            }
//        }
    }



}
