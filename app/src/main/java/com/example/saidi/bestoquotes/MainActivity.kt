package com.example.saidi.bestoquotes


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.saidi.bestoquotes.model.Competitions
import com.example.saidi.bestoquotes.network.NetworkManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NetworkManager.getCompetitions(object : NetworkManager.NetworkCallback<Competitions> {
            override fun networkCallback(data: Competitions?) {
                text.text = data?.count.toString()
            }

        })
    }
}
