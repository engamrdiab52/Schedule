package com.afdal.schedule.frameWork

import com.afdal.core.useCases.DownloadLectures
import com.afdal.core.useCases.ExtractPersonsList

data class Interacts(
    val downloadLectures: DownloadLectures,
    val ExtractPersonsList: ExtractPersonsList
)