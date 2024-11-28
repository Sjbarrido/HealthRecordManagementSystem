package healthrecordmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataBase {

    private static Connection createConnection() throws SQLException {
   
        String url = "jdbc:mysql://localhost/healthdb";  
        String username = "root";  
        String password = "1234";  
        
        return DriverManager.getConnection(url, username, password);
    }

    
    public static Connection getConnection() {
        Connection conn = null;

        try {
           
            conn = createConnection();

         
            if (conn == null || conn.isClosed()) {
                throw new SQLException("Failed to establish a connection.");
            }

        } catch (SQLException ex) {
          
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
