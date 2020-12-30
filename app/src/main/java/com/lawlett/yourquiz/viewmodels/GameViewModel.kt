package com.lawlett.yourquiz.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lawlett.yourquiz.repositories.GameRepositories
import com.lawlett.yourquiz.room.GameDataBase
import com.lawlett.yourquiz.room.data.GameLevel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application):AndroidViewModel(application) {
    private val repositories: GameRepositories

    init {
        val gameDao = GameDataBase.getDatabase(application).gameDao()
        repositories = GameRepositories(gameDao)
    }
    fun addLevel(gameLevel: GameLevel) {
        viewModelScope.launch(Dispatchers.IO) {
            repositories.addTask(gameLevel)
        }
    }

    fun getLevel(level:Int): LiveData<List<GameLevel>> = repositories.loadLevel(level)

}