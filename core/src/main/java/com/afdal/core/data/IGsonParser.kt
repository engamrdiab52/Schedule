package com.afdal.core.data

import com.afdal.core.domain.Person

interface IGsonParser {
    suspend fun parseJsonFileToPersonsList( jsonString : String?):List<Person>?
}