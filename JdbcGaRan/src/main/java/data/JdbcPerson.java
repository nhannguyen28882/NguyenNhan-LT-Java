package data;

import domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPerson {

    // Lấy danh sách thực đơn từ MySQL
    public List<Person> findAll() {
        List<Person> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        
        try (Connection conn = JdbcConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
        	while (rs.next()) {
        	    // Nếu trong DB là ProductID thì sửa "id" thành "ProductID"
        	    // Nếu trong DB là ProductName thì sửa "name" thành "ProductName"
        	    int id = rs.getInt("ProductID"); 
        	    String name = rs.getString("ProductName");
        	    double price = rs.getDouble("Price");
        	    
        	    list.add(new Person(id, name, price));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn: " + e.getMessage());
        }
        return list;
    }

    // Thực hiện chức năng 'Send Order' - Lưu đơn hàng xuống DB (giả định nhà bếp)
    public void saveOrder(double total) {
        String sql = "INSERT INTO orders (TotalAmount) VALUES (?)";
        
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDouble(1, total);
            pstmt.executeUpdate();
            System.out.println(">>> THÔNG BÁO: Đã gửi đơn hàng thành công xuống nhà bếp (Wireless Connected).");
            
        } catch (SQLException e) {
            System.err.println("Lỗi gửi đơn hàng: " + e.getMessage());
        }
    }
}