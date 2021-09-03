package com.afdal.core.data

import com.afdal.core.domain.Lecture

interface IGsonParser {
    suspend fun parseJsonFileToPersonsList( jsonString : String?):List<Lecture>?
}