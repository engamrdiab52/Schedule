package com.afdal.schedule.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.afdal.core.domain.*
import com.afdal.schedule.MainActivity.Companion.TAG
import com.afdal.schedule.frameWork.Interacts
import com.afdal.schedule.frameWork.ScheduleApplication.Companion.isDownloadLectures
import com.afdal.schedule.frameWork.ScheduleViewModel
import com.afdal.schedule.utilis.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LecturesViewModel(application: Application, interacts: Interacts) :
    ScheduleViewModel(application, interacts) {
    private var personListMutableLiveData = SingleLiveEvent<List<LectureUi>?>()
    val personListLiveData: LiveData<List<LectureUi>?> get() = personListMutableLiveData
    fun loadLectures() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val file = interacts.downloadLectures()
                if (isDownloadLectures) {
                    val jsonString = file?.bufferedReader().use { it!!.readText() }
                    val lecturesUiContainer = interacts.ExtractPersonsList(jsonString)
                    if (lecturesUiContainer != null) {
                        //save in db
                        val lecturesLocalList =
                            lecturesUiContainer.asLecturesLocalContainer().lecturesLocal
                        interacts.saveInDatabase(lecturesLocalList)
                        Log.d(TAG, "SAVING IN DATABASE***********")
                    }
                }
                //retrieve from db
                val list: List<LectureLocal>? = interacts.retrieveFromDatabase()
                val uiList =
                    list?.let { LectureLocalListContainer(it).asLecturesUiContainer().lecturesUi }

                if (uiList.isNullOrEmpty()) {
                    Log.d(TAG, "NO DATA CHECK NETWORK CONNECTION")
                }
                personListMutableLiveData.postValue(uiList)
            } catch (e: Exception) {
                Log.d(TAG, "?>?>>?>?>?>?>?>" + e.message.toString())
            }

        }
    }

}