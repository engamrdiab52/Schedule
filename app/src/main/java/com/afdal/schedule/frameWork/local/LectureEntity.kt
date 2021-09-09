package com.afdal.schedule.frameWork.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afdal.core.domain.LectureLocal
import com.afdal.core.domain.LectureLocalListContainer
import java.util.*

@Entity(tableName = "lectures_table")
class LectureEntity(
    @PrimaryKey(autoGenerate = true)
    val lecture_id: Long = 0L,
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

data class LecturesEntityContainer(val lecturesEntities: List<LectureEntity>?)

fun LecturesEntityContainer.asLecturesLocalContainer(): LectureLocalListContainer? {
    if (lecturesEntities != null) {
        return LectureLocalListContainer(
            lecturesEntities.map {
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
    return null
}

fun LectureLocalListContainer.asLecturesEntityContainer(): LecturesEntityContainer {
    return LecturesEntityContainer(
        lecturesLocal.map {
            LectureEntity(
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

