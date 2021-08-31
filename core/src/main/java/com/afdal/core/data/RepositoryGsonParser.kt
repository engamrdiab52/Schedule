package com.afdal.core.data

class RepositoryGsonParser (private val iGsonParser: IGsonParser){
    suspend fun getPersonsList(jsonString: String?) = iGsonParser.parseJsonFileToPersonsList(jsonString)

}