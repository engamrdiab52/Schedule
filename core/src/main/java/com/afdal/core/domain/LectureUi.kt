package com.afdal.core.domain

data class LectureUi(
    val indexOfLectureInTerm: String = "",
    val codeOfCourseInUniversity: String = "",
    val nameOfCourse: String = "",
    val lineOfLecture: String = "",
    val placeOfLecture: String = "",
    val timeOfLecture: String = "",
    val orderOfLecture: String = "",
    val noOfLecturesInCourse: String = "",
    val nameOfTeacher: String = "",
    val urlTeacherImage: String = ""
)

data class LecturesUiContainer(val lecturesUi: List<LectureUi>)

fun LecturesUiContainer.asLecturesLocalContainer(): LectureLocalListContainer {
    return LectureLocalListContainer(
        lecturesUi.map {
            LectureLocal(
                indexOfLectureInTerm = when (it.indexOfLectureInTerm) {
                    "" -> 0L
                    else -> it.indexOfLectureInTerm.toLong()
                },
                codeOfCourseInUniversity = when (it.codeOfCourseInUniversity) {
                    "" -> 0L
                    else -> it.codeOfCourseInUniversity.toLong()
                },
                nameOfCourse = it.nameOfCourse,
                lineOfLecture = it.lineOfLecture,
                placeOfLecture = it.placeOfLecture,
                timeOfLecture = it.timeOfLecture,
                orderOfLecture =  when (it.orderOfLecture) {
                    "" -> 0L
                    else -> it.orderOfLecture.toLong()
                },
                noOfLecturesInCourse =  when (it.noOfLecturesInCourse) {
                    "" -> 0L
                    else -> it.noOfLecturesInCourse.toLong()
                },
                nameOfTeacher = it.nameOfTeacher,
                urlTeacherImage = it.urlTeacherImage
            )
        }
    )
}