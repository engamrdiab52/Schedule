package com.afdal.schedule.frameWork

import android.util.Log
import com.afdal.core.data.IFirebaseLectureDownload
import com.afdal.core.data.IPreferenceHelper
import com.afdal.schedule.MainActivity.Companion.TAG
import com.google.firebase.storage.StorageMetadata
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import java.io.File

class FirebaseLectureDownload(
    private val lecturesReference: StorageReference?,
    private val localPrivateFile: File?,
    private val preferences: IPreferenceHelper

) : IFirebaseLectureDownload {

    override suspend fun downloadLecturesFromFirebase(): File? {
        return if (localPrivateFile != null && lecturesReference != null) {
            try {
                var metaData: StorageMetadata? = lecturesReference.metadata.await()
                if (preferences.getCreationTime() == null) {
                    lecturesReference.getFile(localPrivateFile).await()
                    preferences.setCreationTime(metaData?.creationTimeMillis)
                    Log.d(TAG, "DOWNLOADING FROM FIREBASE First Time")
                    localPrivateFile
                } else {
                    if (metaData != null) {
                        if (metaData.creationTimeMillis > preferences.getCreationTime()!!) {
                            lecturesReference.getFile(localPrivateFile).await()
                            preferences.setCreationTime(metaData.creationTimeMillis)
                            Log.d(TAG,"DOWNLOADING FROM FIREBASE New File uploaded" )
                            localPrivateFile
                        } else {
                            Log.d(TAG ,"File will be from device memory")
                            localPrivateFile
                        }
                    } else {
                        Log.d(TAG,"SOMETHING WRONG IN THE SERVER")
                        null
                    }
                }
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
                null
            }
        } else {
            null
        }

    }
}