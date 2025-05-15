import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL 8.0 and above
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_db", // Replace with your actual DB name
                "root",                                  // Default XAMPP username
                ""                                       // Default XAMPP password (blank)
            );
        } catch (Exception e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
            return null;
        }
    }
}
