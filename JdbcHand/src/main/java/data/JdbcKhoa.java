package data;
import java.sql.*;

public class JdbcKhoa {
    // Thêm Khoa
    public int insert(String ma, String ten, String ngay) {
        String sql = "INSERT INTO KHOA(MAKHOA, TENKHOA, NGTLAP) VALUES(?,?,?)";
        try (Connection conn = JavaConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ma); ps.setString(2, ten); ps.setString(3, ngay);
            return ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); return 0; }
    }

    // Sửa Khoa
    public int update(String ma, String tenMoi) {
        String sql = "UPDATE KHOA SET TENKHOA = ? WHERE MAKHOA = ?";
        try (Connection conn = JavaConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tenMoi); ps.setString(2, ma);
            return ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); return 0; }
    }

    // Xóa Khoa
    public int delete(String ma) {
        String sql = "DELETE FROM KHOA WHERE MAKHOA = ?";
        try (Connection conn = JavaConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); return 0; }
    }
}