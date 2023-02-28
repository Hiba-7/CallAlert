package com.example.application2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.application2.R
import com.example.application2.databinding.ActivityAdapterBinding
import com.example.application2.databinding.ActivityLoginBinding

class adapterActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdapterBinding
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdapterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.graphadapter) as NavHostFragment
        navController=navHostFragment.navController
    }

}
