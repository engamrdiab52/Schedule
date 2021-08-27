package com.afdal.schedule

import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import java.io.File

class FirebaseService(private val file: File, private val storageReference: StorageReference) {

    suspend fun downloadFile(): UIState {
        return try {
            storageReference.getFile(file).await()
            HasData
        } catch (e: Exception) {
            Error(R.string.error_no_file)
        }
    }
}




