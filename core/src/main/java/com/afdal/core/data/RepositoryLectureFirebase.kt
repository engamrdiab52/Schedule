package com.afdal.core.data

class RepositoryLectureFirebase(private val firebaseLectureDownload: IFirebaseLectureDownload) {
    suspend fun getLectures() =firebaseLectureDownload.downloadLecturesFromFirebase()
}