package com.example.saidi.bestoquotes


import android.os.Bundle
import com.example.saidi.bestoquotes.fragment.HomeFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pushFragment(HomeFragment.newInstance())
    }
}
