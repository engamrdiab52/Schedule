package com.afdal.core.domain

data class LectureRemote(
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

data class LecturesRemoteContainer(val lecturesRemote: List<LectureRemote>)

fun LecturesRemoteContainer.asLecturesLocalContainer(): LectureLocalListContainer {
    return LectureLocalListContainer(
        lecturesRemote.map {
            LectureLocal(
                indexOfLectureInTerm = it.indexOfLectureInTerm,
                codeOfCourseInUniversity = it.codeOfCourseInUniversity,
                nameOfCourse = it.nameOfCourse,
                lineOfLecture = it.lineOfLecture,
                placeOfLecture = it.placeOfLecture,
                timeOfLecture = it.timeOfLecture,
                orderOfLecture = it.orderOfLecture,
                noOfLecturesInCourse = it.noOfLecturesInCourse,
                nameOfTeacher = it.nameOfTeacher,
                urlTeacherImage = it.urlTeacherImage

            )
        }
    )
}

