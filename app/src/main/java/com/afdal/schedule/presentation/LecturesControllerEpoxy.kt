package com.afdal.schedule.presentation

import com.afdal.core.domain.Lecture
import com.afdal.core.domain.LectureUi
import com.afdal.schedule.courseCard
import com.afdal.schedule.emptyRecyclerView
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController

class LecturesControllerEpoxy : TypedEpoxyController<List<LectureUi>>(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {
    override fun buildModels(data: List<LectureUi>?) {
        data?.forEachIndexed { index, lecture ->
            courseCard {
                id(index)
                lecture(lecture)
            }
        }
    }
}