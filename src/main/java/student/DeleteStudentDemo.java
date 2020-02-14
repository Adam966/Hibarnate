package student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Student student = session.get(Student.class, 1);
            session.delete(student);

            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
        }
    }
}
