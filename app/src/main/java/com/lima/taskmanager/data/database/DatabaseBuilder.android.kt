package com.lima.taskmanager.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lima.taskmanager.data.TaskDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<TaskDatabase> {
    val dbFile = context.getDatabasePath("task.db")
    return Room.databaseBuilder(
        context = context,
        name = dbFile.absolutePath
    )
}