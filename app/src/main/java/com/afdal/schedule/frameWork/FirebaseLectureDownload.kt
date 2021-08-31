package com.afdal.schedule.frameWork

import android.util.Log
import com.afdal.core.data.IFirebaseLectureDownload
import com.afdal.schedule.MainActivity.Companion.TAG
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import java.io.File

class FirebaseLectureDownload(
    private val lecturesReference: StorageReference?,
    private val localPrivateFile: File?
) : IFirebaseLectureDownload {

    override suspend fun downloadLecturesFromFirebase(): File? {
        return if (localPrivateFile != null && lecturesReference != null) {
            try {
                lecturesReference.getFile(localPrivateFile).await()
                localPrivateFile
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
                null
            }
        } else {
            null
        }

    }
}