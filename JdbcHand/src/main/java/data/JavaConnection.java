package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaConnection {
    // 1. Khai báo các hằng số kết nối
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    // Lưu ý: Đổi tên database từ 'test' thành 'QuanLyGiaoVien' cho đúng bài của bạn
    private static final String JDBC_URL = "jdbc:mysql://localhost/quanlygiaovien?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String JDBC_USER = "Thien Nhan";  // Thay bằng user của máy bạn (thường là root)
    private static final String JDBC_PASS = "Fubuku@190906"; // Thay bằng password của máy bạn

    // 2. Hàm lấy kết nối
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Nạp driver
            Class.forName(JDBC_DRIVER);
            // Mở kết nối
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch (Exception e) {
            System.out.println("Loi ket noi: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}