import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/se450", "root", "root123");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}