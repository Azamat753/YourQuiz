package com.lawlett.yourquiz.repositories

import androidx.lifecycle.LiveData
import com.lawlett.yourquiz.room.dao.GameDao
import com.lawlett.yourquiz.room.data.GameLevel

class GameRepositories(private val gameDao: GameDao) {
    fun loadLevel(level: Int): LiveData<List<GameLevel>> {
        return gameDao.loadLevel(level)
    }
    suspend fun addTask(gameLevel: GameLevel) {
        gameDao.addLevel(gameLevel)
    }
}