package student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Ivan1", "Adam1", "adam.ivan@email.sk");
            Student student2 = new Student("Ivan2", "Adam2", "adam.ivan@email.sk");
            Student student3 = new Student("Ivan3", "Adam3", "adam.ivan@email.sk");


            session.beginTransaction();
            session.save(student);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();

        }catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
        }
    }
}
