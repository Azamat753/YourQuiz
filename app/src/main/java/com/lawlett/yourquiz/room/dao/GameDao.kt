package com.lawlett.yourquiz.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lawlett.yourquiz.room.data.GameLevel

@Dao
interface GameDao {
    @Query("SELECT * FROM quiz_table WHERE id=:level ")
    fun loadLevel(level: Int): LiveData<List<GameLevel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLevel(gameLevel: GameLevel)
}
