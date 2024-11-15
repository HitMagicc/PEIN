package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamud
 */
public class Koneksi {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:postgresql://localhost:1401/db_kampus"; 
                String user = "postgres"; 
                String password = "admin1234!"; 
                
                // Register PostgreSQL driver
                DriverManager.registerDriver(new org.postgresql.Driver());
                
                // Establish the connection
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return conn;
    }
}
