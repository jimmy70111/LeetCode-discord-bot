import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnect {

    private static final String URL = "jdbc:mysql://localhost:3306/leetcode_leaderboard";
    private static final String USER = "root";
    private static final String PASSWORD = "jimmyjiang2264160985";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection connection = sqlconnect.getConnection(); 
            if (connection != null) {
                System.out.println("Connection successful!");
                connection.close(); // Close the connection when done
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
