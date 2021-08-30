package com.afdal.core.domain

data class Lecture(
    val id: String = "",
    val indexOfLectureInTerm: Long = 0L,
    val codeOfCourseInUniversity : Long = 0L,
    val nameOfCourse : String = "",
    val lineOfLecture : String = "",
    val placeOfLecture : String = "",
    val timeOfLecture : String = "",
    val orderOfLecture : Long = 0L,
    val noOfLecturesInCourse : Long = 0L,
    val nameOfTeacher : String = "",
    val urlTeacherImage : String = ""
)