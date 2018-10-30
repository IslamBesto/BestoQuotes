package com.example.saidi.bestoquotes

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.title = ""
    }

    fun initActionBar() {
        supportActionBar?.let { it.setDisplayHomeAsUpEnabled(true) }
    }

    fun setActionBarTitle(@StringRes title: String) {
        actionBar?.title = title
    }

    fun pushFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        with(fragmentTransaction) {
            replace(R.id.fragment_container_layout, fragment)
            addToBackStack(null)
            commit()
        }
    }

    fun clearBackStack() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}
