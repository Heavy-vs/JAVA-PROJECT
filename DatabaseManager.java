package java_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:users.db"; // SQLite database file

    // ✅ Connect to the database
    public static Connection connect() {
        Connection conn = null;
        try {
            // ✅ Load SQLite JDBC Driver
            Class.forName("org.sqlite.JDBC");

            // ✅ Connect to SQLite database
            conn = DriverManager.getConnection(URL);
            if (conn != null) {
                System.out.println("✅ Database Connected Successfully!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ SQLite JDBC Driver Not Found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
        return conn;
    }

    // ✅ Setup database (Create table + Add default user)
    public static void setupDatabase() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "username TEXT UNIQUE NOT NULL,"
                + "password TEXT NOT NULL);";

        String insertUserSQL = "INSERT OR IGNORE INTO users (username, password) VALUES ('admin', 'password123');";

        try (Connection conn = connect();
             PreparedStatement createTable = conn.prepareStatement(createTableSQL);
             PreparedStatement insertUser = conn.prepareStatement(insertUserSQL)) {
            
            createTable.executeUpdate(); // ✅ Create table if not exists
            insertUser.executeUpdate();  // ✅ Insert predefined user if not exists
            
            System.out.println("✅ Database setup complete. User added: admin | password123");
        } catch (SQLException e) {
            System.out.println("❌ Database setup failed: " + e.getMessage());
        }
    }

    // ✅ Validate user login
    public static boolean validateLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) { // ✅ If user exists, login successful
                System.out.println("✅ Login successful for user: " + username);
                return true;
            } else {
                System.out.println("❌ Login failed for user: " + username);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("❌ Login validation failed: " + e.getMessage());
            return false;
        }
    }

    // ✅ Test database setup
    public static void main(String[] args) {
        setupDatabase(); // 🔥 Ensures database is created before running
    }
}
