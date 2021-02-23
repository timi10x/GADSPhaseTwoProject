package com.gadsphasetwoproject.domain.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gadsphasetwoproject.presentation.model.User

@Dao
interface LearningHoursDao {
    @Query("SELECT * FROM hours_leader_board")
    fun getAllLearnersHour(): LiveData<List<User>>

    /* @Query("SELECT * FROM hours_leader_board WHERE userHoursId = :id")
     fun getUserHour(id: Int): LiveData<User>

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertAllHours(user: List<User>)*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHour(user: List<User>)
}