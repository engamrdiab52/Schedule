package com.afdal.core.data

import com.afdal.core.domain.LectureLocal

interface ILocalDataSource {
    suspend fun insertInDatabase(lecturesLocal: List<LectureLocal>? )

    suspend fun retrieveFromDatabase():  List<LectureLocal>?
}