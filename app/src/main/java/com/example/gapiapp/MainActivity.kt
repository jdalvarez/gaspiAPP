package com.example.gapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gapiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myFragment = ContainerFragment()
        replaceFragment(myFragment)
    }

    private fun replaceFragment(myFragment:ContainerFragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.conten_fragment,myFragment)
        fragmentTransaction.commit()
    }
}