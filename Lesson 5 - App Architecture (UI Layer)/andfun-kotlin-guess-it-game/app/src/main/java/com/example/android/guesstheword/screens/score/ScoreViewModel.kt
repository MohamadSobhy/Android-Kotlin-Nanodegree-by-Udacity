package com.example.android.guesstheword.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(val finalScore: Int) : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    private fun onPlayAgainPressed(){
        _eventPlayAgain.value = false
    }

    fun playAgain(){
        _eventPlayAgain.value = true;
        onPlayAgainPressed()
    }

    init {
        println("Final Score is: $finalScore")
        _score.value = finalScore
        _eventPlayAgain.value = false
    }

    override fun onCleared() {
        super.onCleared()

        println("ScoreViewModel cleared")
    }
}