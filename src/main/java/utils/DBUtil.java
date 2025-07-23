package utils;

import model.LoginData;
import java.sql.*;

public class DBUtil {

    static String url = "jdbc:sqlserver://localhost:1433;databaseName=TestAutomationDB;integratedSecurity=true";

    public static LoginData getLoginData() {
        LoginData loginData = null;

        String query = "SELECT TOP 1 username, password FROM LoginData"; // Fetch first row

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                loginData = new LoginData(username, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loginData;
    }
}
