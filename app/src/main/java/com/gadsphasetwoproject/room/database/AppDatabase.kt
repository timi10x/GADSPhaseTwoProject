package com.gadsphasetwoproject.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gadsphasetwoproject.model.User
import com.gadsphasetwoproject.model.UserIq
import com.gadsphasetwoproject.room.dao.LearningHoursDao
import com.gadsphasetwoproject.room.dao.SkillIqDao

@Database(entities = [User::class, UserIq::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun learningHoursDao(): LearningHoursDao
    abstract fun skillIqDao(): SkillIqDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "gadsPhaseTwo")
                .fallbackToDestructiveMigration()
                .build()
    }
}