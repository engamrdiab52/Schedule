package com.afdal.schedule.frameWork

import android.app.Application
import com.afdal.core.data.RepositoryLectureFirebase
import com.afdal.core.useCases.DownloadLectures
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class ScheduleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val localPrivateFile : File? = File(this.applicationContext.filesDir, "myData.json")
        val lectureReference =
            FirebaseStorage.getInstance().reference.child("lecture").child("myData.json")
        val repositoryLectureFirebase =
            RepositoryLectureFirebase(FirebaseLectureDownload(lectureReference, localPrivateFile))
        ScheduleViewModelFactory.inject(
            this,
            Interacts(DownloadLectures(repositoryLectureFirebase))
        )
    }
}