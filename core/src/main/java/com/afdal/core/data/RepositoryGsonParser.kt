package com.afdal.core.data

import com.afdal.core.domain.asLecturesLocalContainer
import com.afdal.core.domain.asLecturesUiContainer

class RepositoryGsonParser (private val iGsonParser: IGsonParser){
    suspend fun getPersonsList(jsonString: String?) = iGsonParser.parseJsonFileToPersonsList(jsonString)?.asLecturesLocalContainer()?.asLecturesUiContainer()

}