package com.afdal.schedule.frameWork.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LectureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insert(lectures:List<LectureEntity> )

    @Query("DELETE FROM lectures_table")
    suspend fun clear()

    @Query("SELECT * FROM lectures_table ORDER BY lecture_id DESC")
    fun getAllLectures():List<LectureEntity>

}