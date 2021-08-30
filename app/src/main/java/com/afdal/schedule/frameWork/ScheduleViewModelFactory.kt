package com.afdal.schedule.frameWork

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object ScheduleViewModelFactory : ViewModelProvider.Factory {
    lateinit var application: Application
    lateinit var dependencies: Interacts

    fun inject(application: Application, dependencies: Interacts) {
        ScheduleViewModelFactory.application = application
        ScheduleViewModelFactory.dependencies = dependencies
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (ScheduleViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, Interacts::class.java)
                .newInstance(
                    application, dependencies
                )
        }else{
            throw IllegalStateException("ViewModel must extend ScheduleViewModel")
        }
    }
}