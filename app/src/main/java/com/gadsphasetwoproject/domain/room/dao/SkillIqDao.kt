package com.gadsphasetwoproject.domain.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gadsphasetwoproject.presentation.model.UserIq

@Dao
interface SkillIqDao {
    @Query("SELECT * FROM Iq_leader_board")
    fun getAllLearnersIq(): LiveData<List<UserIq>>

    /*@Query("SELECT * FROM Iq_leader_board WHERE userIqId = :id")
    fun getUserIq(id: Int): LiveData<UserIq>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllIq(userIq: List<UserIq>)*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIq(userIq: List<UserIq>)
}