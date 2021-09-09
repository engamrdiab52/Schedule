package com.afdal.schedule.frameWork.local

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.afdal.core.data.ILocalDataSource
import com.afdal.core.domain.LectureLocal
import com.afdal.core.domain.LectureLocalListContainer
import com.afdal.schedule.MainActivity.Companion.TAG
import java.util.*

class LocalDataSource(private val context: Context) : ILocalDataSource {
    private val dao = ScheduleDatabase.getInstance(context.applicationContext).lectureDao
    override suspend fun insertInDatabase(lecturesLocal: List<LectureLocal>?) {
        Log.d(TAG, "IN insertInDatabase")
        if (lecturesLocal != null) {
            try {
                LectureLocalListContainer(lecturesLocal).asLecturesEntityContainer().lecturesEntities?.let {
                    dao.insert(
                        it
                    )
                }
            } catch (e: Exception) {
                Toast.makeText(context, "ERROR in DB: " + e.message, Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(context, "ERROR in DB", Toast.LENGTH_SHORT).show()
        }
    }

    override suspend fun retrieveFromDatabase(): List<LectureLocal>? {
        val listOfLecturesEntity: List<LectureEntity>? =
            try {
                dao.getAllLectures()
            } catch (e: Exception) {
                Toast.makeText(context, "ERROR in DB: " + e.message, Toast.LENGTH_SHORT).show()
                null
            }

        val lecturesEntityContainer = LecturesEntityContainer(listOfLecturesEntity)
        return lecturesEntityContainer.asLecturesLocalContainer()?.lecturesLocal
    }
}