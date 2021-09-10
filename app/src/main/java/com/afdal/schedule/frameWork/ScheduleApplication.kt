package com.afdal.schedule.frameWork

import android.app.Application
import android.util.Log
import com.afdal.core.data.IPreferenceHelper
import com.afdal.core.data.RepositoryGsonParser
import com.afdal.core.data.RepositoryLectureFirebase
import com.afdal.core.data.RepositoryLocalSource
import com.afdal.core.domain.Lecture
import com.afdal.core.domain.LectureRemote
import com.afdal.core.domain.LectureUi
import com.afdal.core.useCases.DownloadLectures
import com.afdal.core.useCases.ExtractPersonsList
import com.afdal.core.useCases.RetrieveFromDatabase
import com.afdal.core.useCases.SaveInDatabase
import com.afdal.schedule.MainActivity
import com.afdal.schedule.frameWork.local.LocalDataSource
import com.afdal.schedule.frameWork.local.ScheduleDatabase
import com.afdal.schedule.frameWork.remote.FirebaseLectureDownload
import com.afdal.schedule.frameWork.remote.GsonParserImpl
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type

class ScheduleApplication : Application() {
    companion object{
        var isDownloadLectures : Boolean = false
    }

    override fun onCreate() {
        super.onCreate()
        val prefrences: IPreferenceHelper = PreferenceManager(this)
        val localPrivateFile: File? =
            try {
                File(this.applicationContext.filesDir, "myData.json")
            } catch (e: Exception) {
                null
            }

        val lectureReference: StorageReference? =
            try {
                FirebaseStorage.getInstance().reference.child("classes/country/city/university/faculty/major/academicYear/schedule2.json")
            } catch (e: Exception) {
                null
            }

        val gson = Gson()
        val listPersonType: Type = object : TypeToken<List<LectureRemote>>() {}.type

        val repositoryGsonParser = RepositoryGsonParser(GsonParserImpl(gson, listPersonType))

        val repositoryLectureFirebase =
            RepositoryLectureFirebase(
                FirebaseLectureDownload(
                    lectureReference,
                    localPrivateFile,
                    prefrences,
                    this
                )
            )

        val localDataSource  = LocalDataSource(this)
        val repositoryLocalSource  =  RepositoryLocalSource(localDataSource)
        ScheduleViewModelFactory.inject(
            this,
            Interacts(
                DownloadLectures(repositoryLectureFirebase),
                ExtractPersonsList(repositoryGsonParser),
                SaveInDatabase(repositoryLocalSource),
                RetrieveFromDatabase(repositoryLocalSource)
            )
        )
    }
}