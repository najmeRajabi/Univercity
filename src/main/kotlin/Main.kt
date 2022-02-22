import java.util.*

fun main() {
    lesson.addLesson(student1)
    lesson.addLesson(student2)
    lesson.addLesson(student3)
    student1.printLessons()

    student1.addGrade(lesson,18.3)
    student1.addGrade(physic,17.5)

}
class Teacher{}
class Student(val name :String,
              val id :Int){

    var lessonList= arrayListOf<Lesson>()
    var gradeList= mutableMapOf<Lesson,Double>()


    fun printLessons(){
        for (lesson in lessonList){
            println(lesson.name)
        }
    }
    fun addGrade(lesson:Lesson , grade :Double){
        if (lesson !in lessonList){
            println("invalid!")
            return
        }
        gradeList[lesson] = grade
    }

    fun getAverage(): Double {
        var sum =0.0
        for (grad in gradeList){
            sum += grad.value
        }
        var average = sum / gradeList.size
        return average
    }

}
class Lesson(
    val name:String,
    var teacher:Teacher,
    val unit:Int,
    var examDay: Date? = null){

    var averageOfStudent: Double? = null
    var studentList = arrayListOf<Student>()

    fun addLesson(student:Student ){
        this.studentList.add(student)
        student.lessonList.add(this)
    }

}

val student1 = Student("ali",1)
val student2 = Student("ala",2)
val student3 = Student("ava",3)

val teacher =Teacher()

val lesson = Lesson("math",teacher,2)
val physic = Lesson("physic",teacher,3)

