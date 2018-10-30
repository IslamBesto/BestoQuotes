package com.example.saidi.bestoquotes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saidi.bestoquotes.R
import com.example.saidi.bestoquotes.ui.adapter.CompetitionAdapter
import com.example.saidi.bestoquotes.viewmodel.CompetitionsViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), CompetitionAdapter.ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel(init())
    }

    override fun onItemClickListener() {
        Toast.makeText(context, "click", Toast.LENGTH_LONG).show()
    }

    private fun init(): CompetitionAdapter {
        val competitionAdapter = CompetitionAdapter(mItemClickListener = this)
        with(competitionList) {
            adapter = competitionAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        return competitionAdapter
    }

    private fun setupViewModel(competitionAdapter: CompetitionAdapter) {
        val mainViewModel = ViewModelProviders.of(this).get(CompetitionsViewModel::class.java)
        mainViewModel.competitionsLiveData.observe(this, Observer { competition ->
            competitionAdapter.setCompetitionData(competition)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }
}
