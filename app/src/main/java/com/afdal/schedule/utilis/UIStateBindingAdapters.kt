package com.afdal.schedule.utilis

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.afdal.schedule.presentation.*

const val EMPTY_STRING = ""
@BindingAdapter("uiState")
fun setUiStateForLoading(progressView: ProgressBar, uiState: UIState) {
    progressView.visibility = when (uiState) {
        Loading -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("uiState")
fun setUiStateForLoadedContent(view: View, uiState: UIState) {
    view.visibility = when (uiState) {
        HasData -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("emptyState")
fun setUiStateForEmptyView(view: View, uiState: UIState) {
    view.visibility = when (uiState) {
        NoData -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("errorState")
fun setUiStateForErrorView(view: View, uiState: UIState) {
    view.visibility = when (uiState) {
        is Error -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("errorTextState")
fun setUiStateForErrorText(textView: TextView, uiState: UIState) {
    val textState = when (uiState) {
        is Error -> textView.context.getString(uiState.errorMsgId) to View.VISIBLE
        else -> EMPTY_STRING to View.GONE

    }

    textView.text = textState.first
    textView.visibility = textState.second
}