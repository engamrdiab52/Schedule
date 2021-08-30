package com.afdal.core.useCases

import com.afdal.core.data.RepositoryLectureFirebase

class DownloadLectures (private val lecturesRepository:RepositoryLectureFirebase){
    suspend operator fun invoke() =lecturesRepository.getLectures()

}