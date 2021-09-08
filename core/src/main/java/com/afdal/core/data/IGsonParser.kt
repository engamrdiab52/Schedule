package com.afdal.core.data

import com.afdal.core.domain.Lecture
import com.afdal.core.domain.LecturesRemoteContainer

interface IGsonParser {
    suspend fun parseJsonFileToPersonsList( jsonString : String?):LecturesRemoteContainer?
}