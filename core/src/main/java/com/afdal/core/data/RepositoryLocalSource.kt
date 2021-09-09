package com.afdal.core.data

import com.afdal.core.domain.LectureLocal

class RepositoryLocalSource(private val iLocalDataSource: ILocalDataSource) {
   suspend fun insertInDatabase(lecturesLocal: List<LectureLocal> )= iLocalDataSource.insertInDatabase(lecturesLocal)

    suspend fun retrieveFromDatabase() = iLocalDataSource.retrieveFromDatabase()
}