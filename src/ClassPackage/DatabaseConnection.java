
package ClassPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // No static connection here, it will create a new connection every time
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/megacitycab";
            String username = "root";  
            String password = "sanjoon01"; 

            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to connect to the database.");
        }
        return null;
    }
}
