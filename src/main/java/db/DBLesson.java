package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLesson {

    private static Session session;
    private static Transaction transaction;

    public static List<Student> getlessonsOfStudents(Lesson lesson){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> results = null;

        try {
            Criteria cr = session.createCriteria(Student.class);
            cr.createAlias("lessons", "individual_lesson");
            cr.add(Restrictions.eq("individual_lesson.id", lesson.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
