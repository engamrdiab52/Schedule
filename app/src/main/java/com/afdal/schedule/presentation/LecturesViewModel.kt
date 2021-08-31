package com.afdal.schedule.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.afdal.schedule.MainActivity.Companion.TAG
import com.afdal.schedule.SingleLiveEvent
import com.afdal.schedule.frameWork.Interacts
import com.afdal.schedule.frameWork.ScheduleViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LecturesViewModel(application: Application, interacts: Interacts) :
    ScheduleViewModel(application, interacts) {

    private var personListMutableLiveData = SingleLiveEvent<List<com.afdal.core.domain.Person>?>()
    val personListLiveData: LiveData<List<com.afdal.core.domain.Person>?> get() = personListMutableLiveData
    fun loadLectures() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val file = interacts.downloadLectures()
                val jsonString = file?.bufferedReader().use { it!!.readText() }
                val personList = interacts.ExtractPersonsList(null)
                personListMutableLiveData.postValue(personList)
            } catch (e: Exception) {
                Log.d(TAG,"?>?>>?>?>?>?>?>"+ e.message.toString())
            }

        }
    }

}