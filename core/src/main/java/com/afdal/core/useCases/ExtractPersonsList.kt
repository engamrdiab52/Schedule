package com.afdal.core.useCases

import com.afdal.core.data.RepositoryGsonParser

class ExtractPersonsList (private val repositoryGsonParser: RepositoryGsonParser) {
    suspend operator fun invoke(jsonString: String?) = repositoryGsonParser.getPersonsList(jsonString)
}