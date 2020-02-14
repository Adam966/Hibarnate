package instructor_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateInstructor.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            InstructorDetail detail = session.get(InstructorDetail.class, 2);
            System.out.println(detail.getHobby());
            System.out.println(detail.getInstructor().getFirstName() + " " + detail.getInstructor().getLastName());

            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
