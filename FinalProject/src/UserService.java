import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        String query = "SELECT * FROM Users";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("password"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public static Boolean addUser(User user)
    {
        String username=user.getUsername();
        String pass=user.getPassword();
        String query = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + pass + "');";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {

            int rowsAffected = stmt.executeUpdate(query);

            // Check if the insertion was successful (rowsAffected > 0)
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
            return false;
        }
    }
}
