package com.afdal.schedule.frameWork

import android.util.Log
import com.afdal.core.data.IGsonParser
import com.afdal.core.domain.Person
import com.afdal.schedule.MainActivity.Companion.TAG
import com.google.gson.Gson
import java.lang.reflect.Type

class GsonParserImpl(private val gson: Gson, private val listPersonType: Type) :
    IGsonParser {
    override suspend fun parseJsonFileToPersonsList(jsonString: String?): List<Person>? {
        return if (jsonString != null ) {
            try {
                val personsList: List<Person>? = gson.fromJson(jsonString, listPersonType)
                personsList
            } catch (e: Exception) {
                Log.d(TAG,">>>>>>>>>>"+ e.message.toString())
                null
            }
        } else {
            null
        }

    }

}