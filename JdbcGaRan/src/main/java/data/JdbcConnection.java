package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    // Thay đổi 'root' và 'password' theo đúng tài khoản MySQL của bạn
    private static final String URL = "jdbc:mysql://localhost:3306/fastfooddb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "Thien Nhan"; 
    private static final String PASS = "Fubuku@190906"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}