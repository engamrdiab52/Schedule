package com.afdal.core.domain

data class LectureUi(val indexOfLectureInTerm: String = "",
                     val codeOfCourseInUniversity : String = "",
                     val nameOfCourse : String = "",
                     val lineOfLecture : String = "",
                     val placeOfLecture : String = "",
                     val timeOfLecture : String = "",
                     val orderOfLecture : String = "",
                     val noOfLecturesInCourse : String ="" ,
                     val nameOfTeacher : String = "",
                     val urlTeacherImage : String = "")

data class LecturesUiContainer(val lecturesUi : List<LectureUi>)