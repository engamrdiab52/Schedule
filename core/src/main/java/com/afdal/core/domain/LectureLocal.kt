package com.afdal.core.domain

data class LectureLocal(
    val indexOfLectureInTerm: Long = 0L,
    val codeOfCourseInUniversity: Long = 0L,
    val nameOfCourse: String = "",
    val lineOfLecture: String = "",
    val placeOfLecture: String = "",
    val timeOfLecture: String = "",
    val orderOfLecture: Long = 0L,
    val noOfLecturesInCourse: Long = 0L,
    val nameOfTeacher: String = "",
    val urlTeacherImage: String = ""
)

data class LectureLocalListContainer(val lecturesLocal: List<LectureLocal>)

fun LectureLocalListContainer.asLecturesUiContainer(): LecturesUiContainer {
    return LecturesUiContainer(
        lecturesLocal.map {
            LectureUi(
                indexOfLectureInTerm = it.indexOfLectureInTerm.toString(),
                codeOfCourseInUniversity = it.codeOfCourseInUniversity.toString(),
                nameOfCourse = it.nameOfCourse,
                lineOfLecture = it.lineOfLecture,
                placeOfLecture = it.placeOfLecture,
                timeOfLecture = it.timeOfLecture,
                orderOfLecture = it.timeOfLecture,
                noOfLecturesInCourse = it.noOfLecturesInCourse.toString(),
                nameOfTeacher = it.nameOfTeacher,
                urlTeacherImage = it.urlTeacherImage

            )
        }
    )
}