package com.afdal.schedule.frameWork.local

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.afdal.schedule.MainActivity.Companion.TAG

@Database(entities = [LectureEntity::class], version = 1, exportSchema = false)
abstract class ScheduleDatabase : RoomDatabase() {
    abstract val lectureDao: LectureDao

    companion object {
        @Volatile
        private  var INSTANCE: ScheduleDatabase? =null
        fun getInstance(context: Context): ScheduleDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ScheduleDatabase::class.java,
                        "Schedule_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}