package OneToMany;

import instructor_uni.Instructor;
import instructor_uni.InstructorDetail;
import manyToOne.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReviewDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateInstructor.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class )
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Back End");
            Review review = new Review("Amazing course");
            Review review1 = new Review("Pray for you bro");

            course.add(review);
            course.add(review1);

            session.save(course);

            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
