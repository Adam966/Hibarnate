package instructor_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateInstructor.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Adam", "Ivan", "adam.ivan@email.com");
            InstructorDetail detail = new InstructorDetail("youtubeChannel", "programing");
            instructor.setInstructorDetail(detail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
        }
    }
}
