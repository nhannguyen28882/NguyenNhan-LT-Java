package test;

import data.JdbcGiaoVien;

public class JdbcHandlingTest {
    public static void main(String[] args) {
        System.out.println(">>> CHUONG TRINH DANG BAT DAU CHAY..."); // Thêm dòng này
        
        JdbcGiaoVien action = new JdbcGiaoVien();

        System.out.println("--- DANG CAP NHAT TEN GV ---");
        int checkUpdate = action.update("GV01", "Nguyen Van A (Update)");
        System.out.println("So dong da cap nhat: " + checkUpdate);
        
     // Thử xóa giáo viên có mã GV05
        int checkDel = action.delete("GV05");
        System.out.println("So dong da xoa: " + checkDel);

        // Thử thêm và kiểm tra kết quả
        int checkIns = action.insert("GV07", "Tran Van E", "Cu nhan", "Nam", 3.0, 10000000, "CNTT");
        System.out.println("So dong da them: " + checkIns);

        System.out.println("\n--- DANH SACH GV NAM KHOA CNTT ---");
        action.listNamCNTT();
        
        System.out.println("\n>>> CHUONG TRINH DA KET THUC."); // Thêm dòng này
    }
}