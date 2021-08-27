package com.afdal.schedule

import androidx.annotation.StringRes

/**
 * Base class to represent common UI states
 */
sealed class UIState

/**
 * the screen is currently loading it's data. "loading state"
 */
object Loading : UIState()

/**
 * data was successfully loaded for the screen.  "happy path"
 */
object HasData : UIState()

/**
 * the load was successful, but there was no data.  "empty state"
 */
object NoData : UIState()

/**
 * some type of error occurred.  "error state"
 */
class Error(@StringRes val errorMsgId:Int = 0) : UIState()