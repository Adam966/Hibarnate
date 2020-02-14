package student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Daffy", "Duffy", "adam.ivan@email.sk");

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();
            Student student1 = session.get(Student.class, student.getId());
            System.out.println(student1.getFirstName() + " " + student1.getLastName());
            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
        }
    }
}
