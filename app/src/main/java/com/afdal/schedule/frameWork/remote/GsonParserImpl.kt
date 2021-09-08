package com.afdal.schedule.frameWork.remote

import android.util.Log
import com.afdal.core.data.IGsonParser
import com.afdal.core.domain.Lecture
import com.afdal.core.domain.LectureRemote
import com.afdal.core.domain.LecturesRemoteContainer
import com.afdal.schedule.MainActivity.Companion.TAG
import com.google.gson.Gson
import java.lang.reflect.Type

class GsonParserImpl(private val gson: Gson, private val listPersonType: Type) :
    IGsonParser {
    override suspend fun parseJsonFileToPersonsList(jsonString: String?): LecturesRemoteContainer? {
        return if (jsonString != null ) {
            try {
                val personsList: List<LectureRemote>? = gson.fromJson(jsonString, listPersonType)
                personsList?.let { LecturesRemoteContainer(it) }
            } catch (e: Exception) {
                Log.d(TAG,">>>>>>>>>>"+ e.message.toString())
                null
            }
        } else {
            null
        }

    }

}