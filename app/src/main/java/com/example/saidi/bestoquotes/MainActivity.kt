package com.example.saidi.bestoquotes


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.saidi.bestoquotes.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.competitions.observe(this, Observer { competition ->
            text.text = competition[0].name
        })

    }
}
