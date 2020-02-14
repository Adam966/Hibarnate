package student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").list();
            displayStudent(students);

            students = session.createQuery("from Student s where s.lastName='Duffy'").list();
            displayStudent(students);

            session.getTransaction().commit();

        }catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void displayStudent(List<Student> students) {
        for (Student s: students) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
    }
}
