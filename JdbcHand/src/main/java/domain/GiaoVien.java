package domain;
public class GiaoVien {
    private String maGV, hoTen, hocVi, hoCham, gioiTinh, maKhoa;
    private double heSo, mucLuong;

    // Constructor, Getter và Setter (Bạn có thể dùng Alt+Insert trong IDE để tạo nhanh)
    public GiaoVien(String maGV, String hoTen, String hocVi, String gioiTinh, double heSo, double mucLuong, String maKhoa) {
        this.maGV = maGV;
        this.hoTen = hoTen;
        this.hocVi = hocVi;
        this.gioiTinh = gioiTinh;
        this.heSo = heSo;
        this.mucLuong = mucLuong;
        this.maKhoa = maKhoa;
    }
    // ... Thêm các Getter/Setter nếu cần thiết ...
    @Override
    public String toString() {
        return "GV: " + maGV + " | Ten: " + hoTen + " | Gioi Tinh: " + gioiTinh + " | Khoa: " + maKhoa;
    }
}