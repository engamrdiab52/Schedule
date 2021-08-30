package com.afdal.core.data

import java.io.File

interface IFirebaseLectureDownload {
    suspend fun downloadLecturesFromFirebase(): File?

}