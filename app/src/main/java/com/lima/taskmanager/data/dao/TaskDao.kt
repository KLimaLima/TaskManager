package com.lima.taskmanager.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.lima.taskmanager.domain.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Transaction
    @Query("SELECT * FROM task WHERE _id = :taskId")
    suspend fun getTaskById(taskId: Int): Task

    @Transaction
    @Query("SELECT * FROM task WHERE _id = :taskId")
    fun getTaskByIdFlow(taskId: Int): Flow<Task?>

    @Transaction
    @Query("SELECT * FROM task ORDER BY isFinished DESC")
    fun readAllTasksSortByFavorite(): Flow<List<Task>>

    @Transaction
    @Query("SELECT * FROM task")
    fun readAllTasks(): Flow<List<Task>>

    @Query("UPDATE task SET isFinished = :isFinished WHERE _id = :taskId")
    suspend fun setFinishedTask(isFinished: Boolean, taskId: Int)

    @Transaction
    @Query("DELETE FROM task WHERE _id = :taskId")
    suspend fun deleteTaskById(taskId: Int)
}