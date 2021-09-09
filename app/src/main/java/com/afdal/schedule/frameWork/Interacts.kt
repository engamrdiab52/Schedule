package com.afdal.schedule.frameWork

import com.afdal.core.useCases.DownloadLectures
import com.afdal.core.useCases.ExtractPersonsList
import com.afdal.core.useCases.RetrieveFromDatabase
import com.afdal.core.useCases.SaveInDatabase

data class Interacts(
    val downloadLectures: DownloadLectures,
    val ExtractPersonsList: ExtractPersonsList,
    val saveInDatabase: SaveInDatabase,
    val retrieveFromDatabase: RetrieveFromDatabase
)