package healthrecordmanagementsystem;

import java.sql.Connection; // For handling database connections
import java.sql.DriverManager; // For managing database drivers
import java.sql.SQLException; // For handling SQL exceptions
import java.util.logging.Level; // For logging errors and warnings
import java.util.logging.Logger; // For logging system events
import javax.swing.JOptionPane; // For showing error messages to the user

// A utility class for managing database connections
public class DataBase {

    // Private method to establish a database connection
    private static Connection createConnection() throws SQLException {
        // Database connection details
        String url = "jdbc:mysql://localhost/tblpayroll"; // JDBC URL for the database
        String username = "root"; // Database username
        String password = "1234"; // Database password
        
        // Return a new connection using the specified details
        return DriverManager.getConnection(url, username, password);
    }

    // Public method to retrieve an active database connection
    public static Connection getConnection() {
        Connection conn = null; // Initialize the connection object6

        try {
            // Attempt to create a database connection
            conn = createConnection();

            // Check if the connection is valid
            if (conn == null || conn.isClosed()) {
                throw new SQLException("Failed to establish a connection."); // Throw exception if connection fails
            }
        } catch (SQLException ex) {
            // Show an error message dialog if there is a database issue
            JOptionPane.showMessageDialog(null, 
                "Database Error: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);

            // Log the exception for debugging and tracking
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the connection object, whether valid or null
        return conn;
    }

    // Public method to close an active database connection
    public static void closeConnection(Connection conn) {
        try {
            // Check if the connection is not null and is open
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Close the connection
            }
        } catch (SQLException e) {
            // Log any errors encountered while closing the connection
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
