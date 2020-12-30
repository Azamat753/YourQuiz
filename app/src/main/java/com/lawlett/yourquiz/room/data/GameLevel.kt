package com.lawlett.yourquiz.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_table")
class GameLevel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var question: String?=null,
    var firstOp: String?=null,
    var secondOp: String?=null,
    var thirdOp: String?=null,
    var fourOp: String?=null,
    var description:String?=null,
    var answer: String?=null
)