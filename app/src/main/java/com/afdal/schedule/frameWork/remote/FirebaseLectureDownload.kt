package com.afdal.schedule.frameWork.remote

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.afdal.core.data.IFirebaseLectureDownload
import com.afdal.core.data.IPreferenceHelper
import com.afdal.schedule.MainActivity
import com.afdal.schedule.MainActivity.Companion.TAG
import com.afdal.schedule.frameWork.ScheduleApplication.Companion.isDownloadLectures
import com.google.firebase.storage.StorageMetadata
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeoutOrNull
import java.io.File

class FirebaseLectureDownload(
    private val lecturesReference: StorageReference?,
    private val localPrivateFile: File?,
    private val preferences: IPreferenceHelper,
    private val context: Context
) : IFirebaseLectureDownload {

    override suspend fun downloadLecturesFromFirebase(): File? {
        return if (localPrivateFile != null && lecturesReference != null) {
            try {

                val metaData: StorageMetadata? = withTimeoutOrNull(3000L)
                { lecturesReference.metadata.await() }
                if (metaData == null){
                  //  Log.d(TAG, "NO DATA CHECK NETWORK CONNECTION")
                }
                    if (preferences.getCreationTime() == null) {
                        lecturesReference.getFile(localPrivateFile).await()
                        preferences.setCreationTime(metaData?.creationTimeMillis)
                        Log.d(TAG, "DOWNLOADING FROM FIREBASE First Time")
                        isDownloadLectures = true
                        localPrivateFile
                    } else {
                        if (metaData != null) {
                            if (metaData.creationTimeMillis > preferences.getCreationTime()!!) {
                                lecturesReference.getFile(localPrivateFile).await()
                                Log.d(TAG, "SOMETHING WRONG IN THE SERVER")
                                preferences.setCreationTime(metaData.creationTimeMillis)
                                Log.d(TAG, "DOWNLOADING FROM FIREBASE New File uploaded")
                                isDownloadLectures = true
                                localPrivateFile
                            } else {
                                Log.d(TAG, "File will be from device memory")
                                isDownloadLectures = false
                                localPrivateFile
                            }
                        } else {
                            isDownloadLectures = false
                            null
                        }
                    }
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
                isDownloadLectures = false
                null
            }
        } else {
            isDownloadLectures = false
            null
        }

    }
}