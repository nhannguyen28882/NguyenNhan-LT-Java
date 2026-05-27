package data;

import java.sql.*;

public class JdbcGiaoVien {

    // 1. Hàm THÊM giáo viên (Đã chuyển sang int để trả về số dòng thành công)
    public int insert(String ma, String ten, String hocvi, String gt, double hs, double luong, String mk) {
        String sql = "INSERT INTO GIAOVIEN VALUES(?,?,?,?,?,?,?,?)";
        int rows = 0;
        try (Connection conn = JavaConnection.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ma); 
            ps.setString(2, ten); 
            ps.setString(3, hocvi);
            ps.setString(4, null); // hocham (để trống hoặc truyền vào nếu có)
            ps.setString(5, gt); 
            ps.setDouble(6, hs); 
            ps.setDouble(7, luong); 
            ps.setString(8, mk);
            
            rows = ps.executeUpdate();
            System.out.println("Thuc thi lenh Them...");
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return rows;
    }

    // 2. Hàm SỬA tên giáo viên
    public int update(String ma, String tenMoi) {
        String sql = "UPDATE GIAOVIEN SET HOTEN = ? WHERE MAGV = ?";
        int rowsAffected = 0; 
        try (Connection conn = JavaConnection.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, tenMoi); 
            ps.setString(2, ma);
            
            rowsAffected = ps.executeUpdate(); 
            System.out.println("Thuc thi lenh Sua...");
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return rowsAffected; 
    }

    // 3. Hàm XÓA giáo viên (MỚI THÊM)
    public int delete(String ma) {
        String sql = "DELETE FROM GIAOVIEN WHERE MAGV = ?";
        int rowsAffected = 0;
        try (Connection conn = JavaConnection.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, ma);
            rowsAffected = ps.executeUpdate();
            System.out.println("Thuc thi lenh Xoa...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    // 4. Hàm LIỆT KÊ giáo viên Nam khoa CNTT
    public void listNamCNTT() {
        String sql = "SELECT * FROM GIAOVIEN WHERE GIOITINH = 'Nam' AND MAKHOA = 'CNTT'";
        try (Connection conn = JavaConnection.getConnection(); 
             Statement st = conn.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) {
            
            System.out.println("--- KET QUA TRUY VAN ---");
            while (rs.next()) {
                System.out.println("Ma: " + rs.getString("MAGV") + " - Ten: " + rs.getString("HOTEN"));
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }
}