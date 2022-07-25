package com.tozmd.bard.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.tozmd.bard.network.SpotifyApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

//Handles the song recommendation data from Spotify API
class SongRecommendationViewModel(): ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableStateFlow("")
    // The external immutable LiveData for the request status
    val status = _status.asStateFlow()

//    //Internal MutableLiveData that stores the list of songs
//    private val _songRecommendationList = MutableStateFlow<List<String>>(listOf())
//    //External LiveData for song recommendations
//    val songRecommendationList = _songRecommendationList.asStateFlow()


    //Call to get songs on init for instant displaying.
    init {
        getRecommendedSongs()
    }


    private fun getRecommendedSongs(){
        //viewModelScope is a coroutine that is cancelled if the current view model is cleared.
        viewModelScope.launch {
            try{
                val recommendationList = SpotifyApi.retrofitService.getRecommendedSongs()
                _status.value = recommendationList

            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
