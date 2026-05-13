package thryt.com;

import java.util.Scanner;

// ----- LỚP TRỪU TƯỢNG -----
abstract class Hinh {
    protected String mau;

    public Hinh(String mau) {
        this.mau = mau;
    }

    public abstract double tinhDienTich();

    public abstract double tinhChuVi();

    public String layThongTin() {
        return "Màu sắc: " + mau;
    }
}

// ----- HÌNH CHỮ NHẬT -----
class HinhChuNhat extends Hinh {

    protected double chieuDai;
    protected double chieuRong;

    public HinhChuNhat(String mau, double chieuDai, double chieuRong) {
        super(mau);
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    @Override
    public double tinhChuVi() {
        return (chieuDai + chieuRong) * 2;
    }

    @Override
    public String layThongTin() {
        return super.layThongTin()
                + ", Hình Chữ Nhật [Dài: " + chieuDai
                + ", Rộng: " + chieuRong
                + "], Diện tích: " + tinhDienTich()
                + ", Chu vi: " + tinhChuVi();
    }
}

// ----- HÌNH VUÔNG -----
class HinhVuong extends HinhChuNhat {

    public HinhVuong(String mau, double canh) {
        super(mau, canh, canh);
    }

    @Override
    public String layThongTin() {
        return "Màu sắc: " + mau
                + ", Hình Vuông [Cạnh: " + chieuDai
                + "], Diện tích: " + tinhDienTich()
                + ", Chu vi: " + tinhChuVi();
    }
}

// ----- HÌNH TRÒN -----
class HinhTron extends Hinh {

    private double banKinh;

    public HinhTron(String mau, double banKinh) {
        super(mau);
        this.banKinh = banKinh;
    }

    @Override
    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }

    @Override
    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    @Override
    public String layThongTin() {
        return super.layThongTin()
                + ", Hình Tròn [Bán kính: " + banKinh
                + "], Diện tích: " + String.format("%.2f", tinhDienTich())
                + ", Chu vi: " + String.format("%.2f", tinhChuVi());
    }
}

// ----- CLASS MAIN -----
public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int chon;

        do {

            System.out.println("\n----- CHƯƠNG TRÌNH TÍNH CHU VI & DIỆN TÍCH -----");
            System.out.println("1. Tính Hình Chữ Nhật");
            System.out.println("2. Tính Hình Vuông");
            System.out.println("3. Tính Hình Tròn");
            System.out.println("0. Thoát");

            System.out.print("Mời bạn chọn (0-3): ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {

                case 1:

                    System.out.print("Nhập màu sắc: ");
                    String mauHCN = sc.nextLine();

                    System.out.print("Nhập chiều dài: ");
                    double dai = sc.nextDouble();

                    System.out.print("Nhập chiều rộng: ");
                    double rong = sc.nextDouble();

                    Hinh hcn = new HinhChuNhat(mauHCN, dai, rong);

                    System.out.println("\nKẾT QUẢ:");
                    System.out.println(hcn.layThongTin());

                    break;

                case 2:

                    System.out.print("Nhập màu sắc: ");
                    String mauHV = sc.nextLine();

                    System.out.print("Nhập cạnh: ");
                    double canh = sc.nextDouble();

                    Hinh hv = new HinhVuong(mauHV, canh);

                    System.out.println("\nKẾT QUẢ:");
                    System.out.println(hv.layThongTin());

                    break;

                case 3:

                    System.out.print("Nhập màu sắc: ");
                    String mauHT = sc.nextLine();

                    System.out.print("Nhập bán kính: ");
                    double r = sc.nextDouble();

                    Hinh ht = new HinhTron(mauHT, r);

                    System.out.println("\nKẾT QUẢ:");
                    System.out.println(ht.layThongTin());

                    break;

                case 0:

                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;

                default:

                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (chon != 0);

        sc.close();
    }
}