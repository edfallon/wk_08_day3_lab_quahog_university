import db.DBHelper;
import db.DBLesson;
import db.DBStudent;
import models.Course;
import models.Lesson;
import models.LevelType;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args) {



        Course course1 = new Course("History", LevelType.MA);
        DBHelper.save(course1);

        Course course2 = new Course("Drama", LevelType.HND);
        DBHelper.save(course2);

        Lesson lesson1 = new Lesson("Stanislavski", 3, course2);
        DBHelper.save(lesson1);

        Lesson lesson2 = new Lesson("Scottish Wars of Independence", 1, course1);
        DBHelper.save(lesson2);

        Student student1 = new Student("Liam", 26, 65656565, course2);
        DBHelper.save(student1);

        Student student2 = new Student("Bob", 35, 4542265, course1);

        student2.addLessonToStudent(lesson1);
        DBHelper.save(student2);

        lesson1.addStudentToLesson(student2);
        DBHelper.save(lesson1);



        List<Lesson> bobsLessons = DBStudent.getStudentsLessons(student2);

        List<Lesson> lessons = DBHelper.getAll(Lesson.class);

        List<Student> students = DBLesson.getlessonsOfStudents(lesson1);

    }
}
