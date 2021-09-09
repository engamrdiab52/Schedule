package com.afdal.core.useCases

import com.afdal.core.data.RepositoryLocalSource
import com.afdal.core.domain.LectureLocal

class SaveInDatabase(private val repositoryLocalSource: RepositoryLocalSource) {
    suspend operator fun invoke(lecturesLocal:List<LectureLocal> ) = repositoryLocalSource.insertInDatabase(lecturesLocal)
}