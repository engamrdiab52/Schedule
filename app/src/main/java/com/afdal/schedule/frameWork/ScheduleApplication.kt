package com.afdal.schedule.frameWork

import android.app.Application
import com.afdal.core.data.RepositoryGsonParser
import com.afdal.core.data.RepositoryLectureFirebase
import com.afdal.core.domain.Person
import com.afdal.core.useCases.DownloadLectures
import com.afdal.core.useCases.ExtractPersonsList
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type

class ScheduleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val localPrivateFile: File? =
            try {
                File(this.applicationContext.filesDir, "myData.json")
            } catch (e: Exception) {
                null
            }

        val lectureReference : StorageReference? =
            try {
                FirebaseStorage.getInstance().reference.child("lecture").child("myData.json")
            }catch (e :Exception){
                null
            }
        val gson = Gson()
        val listPersonType :Type = object :TypeToken<List<Person>>(){}.type

        val repositoryGsonParser  = RepositoryGsonParser(GsonParserImpl(gson, listPersonType))

        val repositoryLectureFirebase =
            RepositoryLectureFirebase(FirebaseLectureDownload(lectureReference, localPrivateFile))
        ScheduleViewModelFactory.inject(
            this,
            Interacts(DownloadLectures(repositoryLectureFirebase),
            ExtractPersonsList(repositoryGsonParser)
            )
        )
    }
}