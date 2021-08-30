package com.afdal.schedule.frameWork

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class ScheduleViewModel(application: Application, protected val interacts: Interacts) :
    AndroidViewModel(application) {
    protected val application: ScheduleApplication = this.getApplication()

}