package com.afdal.schedule.presentation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.afdal.schedule.frameWork.Interacts
import com.afdal.schedule.frameWork.ScheduleViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class LecturesViewModel(application: Application, interacts: Interacts) :
    ScheduleViewModel(application, interacts) {
    init {
        loadLectures()
    }
    val fileLiveData = MutableLiveData<File?>()
    fun loadLectures() {
        viewModelScope.launch(Dispatchers.IO) {
            fileLiveData.postValue(interacts.downloadLectures())
        }
    }

}