import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class sqlconnect {
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
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
        } catch (SQLException | IOException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
