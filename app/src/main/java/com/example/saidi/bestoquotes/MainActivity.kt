package com.example.saidi.bestoquotes


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saidi.bestoquotes.ui.adapter.CompetitionAdapter
import com.example.saidi.bestoquotes.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompetitionAdapter.ItemClickListener {
    override fun onItemClickListener() {
        Toast.makeText(baseContext, "click", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val competitionAdapter = init()
        setupViewModel(competitionAdapter)
    }

    private fun init(): CompetitionAdapter {
        val competitionAdapter = CompetitionAdapter(mItemClickListener = this)
        with(competitionList) {
            adapter = competitionAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
        }
        return competitionAdapter
    }

    private fun setupViewModel(competitionAdapter: CompetitionAdapter) {
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.competitionsLiveData.observe(this, Observer { competition ->
            competitionAdapter.setCompetitionData(competition)
        })
    }
}
