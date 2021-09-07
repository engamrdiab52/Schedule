package com.afdal.core.data

interface IPreferenceHelper {
    fun setCreationTime(creationTime: Long?)
    fun getCreationTime(): Long?
    fun clearPrefs()
}