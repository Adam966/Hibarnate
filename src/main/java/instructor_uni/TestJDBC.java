package instructor_uni;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";
        Connection con = null;

        try {
            System.out.println("Connecting to database");

            con = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("connected");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
