package com.afdal.schedule.presentation

import com.afdal.core.domain.Lecture
import com.afdal.schedule.courseCard
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController

class LecturesControllerEpoxy : TypedEpoxyController<List<Lecture>>(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {
    override fun buildModels(data: List<Lecture>?) {
        data?.forEachIndexed { index, lecture ->
            courseCard {
                id(index)
                lecture(lecture)
            }
        }
    }
}