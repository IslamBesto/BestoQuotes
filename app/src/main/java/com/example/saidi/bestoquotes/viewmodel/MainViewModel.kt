package com.example.saidi.bestoquotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.saidi.bestoquotes.model.Competition
import com.example.saidi.bestoquotes.model.Competitions
import com.example.saidi.bestoquotes.network.NetworkManager

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var competitions: MutableLiveData<List<Competition>> = MutableLiveData()

    init {
        NetworkManager.getCompetitions(object : NetworkManager.NetworkCallback<Competitions> {
            override fun networkCallback(data: Competitions?) {
                competitions.postValue(data?.compititonList)
            }
        })
    }
}