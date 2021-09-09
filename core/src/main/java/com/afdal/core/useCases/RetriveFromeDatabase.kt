package com.afdal.core.useCases

import com.afdal.core.data.RepositoryLocalSource

class RetrieveFromDatabase(private val repositoryLocalSource: RepositoryLocalSource) {
    suspend operator fun invoke() = repositoryLocalSource.retrieveFromDatabase()
}