package nhanvien.com;

import java.util.Scanner;

public class Nhanvien {
    private String ho;
    private String ten;
    private int soSP;

    // Constructor
    public Nhanvien(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        setSoSP(soSP); // Dùng hàm set để kiểm tra số âm ngay từ đầu
    }

    // Getter / Setter
    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public int getSoSP() { return soSP; }
    public void setSoSP(int soSP) {
        this.soSP = (soSP < 0) ? 0 : soSP;
    }

    // Hàm tính lương theo bảng đơn giá
    public double getLuong() {
        double donGia;
        if (soSP >= 600) donGia = 0.65;
        else if (soSP >= 400) donGia = 0.6;
        else if (soSP >= 200) donGia = 0.55;
        else if (soSP >= 1) donGia = 0.5;
        else donGia = 0;
        
        return soSP * donGia;
    }

    // Hàm so sánh LonHon
    public boolean LonHon(Nhanvien nv2) {
        return this.soSP > nv2.soSP;
    }

    // Hàm main để chạy chương trình (Gộp chung vào đây)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập nhân viên 1
        System.out.println("Nhập thông tin nhân viên 1:");
        System.out.print("Họ: "); String h1 = sc.nextLine();
        System.out.print("Tên: "); String t1 = sc.nextLine();
        System.out.print("Số sản phẩm: "); int s1 = sc.nextInt();
        sc.nextLine(); // Fix lỗi trôi dòng
        Nhanvien nv1 = new Nhanvien(h1, t1, s1);

        // Nhập nhân viên 2
        System.out.println("\nNhập thông tin nhân viên 2:");
        System.out.print("Họ: "); String h2 = sc.nextLine();
        System.out.print("Tên: "); String t2 = sc.nextLine();
        System.out.print("Số sản phẩm: "); int s2 = sc.nextInt();
        Nhanvien nv2 = new Nhanvien(h2, t2, s2);

        // Xuất lương
        System.out.println("\n--- Kết quả ---");
        System.out.println("Lương " + nv1.getTen() + ": " + nv1.getLuong());
        System.out.println("Lương " + nv2.getTen() + ": " + nv2.getLuong());

        // So sánh cách 1: Dùng hàm LonHon
        System.out.print("\nCách 1 (Dùng LonHon): ");
        if (nv1.LonHon(nv2)) {
            System.out.println(nv1.getTen() + " nhiều hơn " + (nv1.getSoSP() - nv2.getSoSP()) + " SP");
        } else if (nv2.LonHon(nv1)) {
            System.out.println(nv2.getTen() + " nhiều hơn " + (nv2.getSoSP() - nv1.getSoSP()) + " SP");
        } else {
            System.out.println("Hai người bằng nhau");
        }

        // So sánh cách 2: Không dùng hàm LonHon
        System.out.print("Cách 2 (Không dùng LonHon): ");
        if (nv1.getSoSP() > nv2.getSoSP()) {
            System.out.println(nv1.getTen() + " nhiều hơn " + (nv1.getSoSP() - nv2.getSoSP()) + " SP");
        } else if (nv2.getSoSP() > nv1.getSoSP()) {
            System.out.println(nv2.getTen() + " nhiều hơn " + (nv2.getSoSP() - nv1.getSoSP()) + " SP");
        } else {
            System.out.println("Hai người bằng nhau");
        }
        
        sc.close();
    }
}