package com.example.saidi.bestoquotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.saidi.bestoquotes.model.Competition
import com.example.saidi.bestoquotes.network.NetworkManager

class CompetitionsViewModel(application: Application) : AndroidViewModel(application) {
    var competitionsLiveData: MutableLiveData<List<Competition>> = MutableLiveData()
    var competitions = ArrayList<Competition>()

    init {
        NetworkManager.getCompetitions(object : NetworkManager.NetworkCallback<Competition> {
            override fun networkCallback(data: Competition?) {
                data?.let { it ->
                    competitions.add(it)
                    val sortedDompetitions = competitions.sortedWith(compareBy { it.id })
                    competitionsLiveData.postValue(sortedDompetitions.distinct())
                }

            }
        })

    }
}