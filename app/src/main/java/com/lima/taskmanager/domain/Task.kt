package com.lima.taskmanager.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val image: String,
    val title: String,
    val description: String,
    val isFinished: Boolean,
    val topic: String, //what is it such as subjects or events or work
    val steps: List<String>
)
