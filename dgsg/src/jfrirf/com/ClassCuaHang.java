package jfrirf.com;

import java.util.ArrayList;
import java.util.Scanner;

// Lớp Invoice theo yêu cầu của đề bài
class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // Constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    // Getters và Setters
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }

    public String getPartDescription() { return partDescription; }
    public void setPartDescription(String partDescription) { this.partDescription = partDescription; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = (quantity > 0) ? quantity : 0;
    }

    public double getPricePerItem() { return pricePerItem; }
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = (pricePerItem > 0) ? pricePerItem : 0.0;
    }

    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("Mã: %-10s | Mô tả: %-20s | SL: %-5d | Đơn giá: %,.2f | Tổng: %,.2f", 
                partNumber, partDescription, quantity, pricePerItem, getInvoiceAmount());
    }
}

public class ClassCuaHang {
    private static ArrayList<Invoice> danhSach = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Tạo dữ liệu giả ban đầu
        duLieuGia();

        int luaChon;
        do {
            System.out.println("\n---------- QUẢN LÝ CỬA HÀNG MÁY TÍNH ----------");
            System.out.println("1. Nhập danh sách Invoice (ít nhất 10 cái)");
            System.out.println("2. Xuất danh sách Invoice");
            System.out.println("3. Sắp xếp theo Mã mặt hàng (Bubble Sort)");
            System.out.println("4. Tìm kiếm Invoice theo Mã mặt hàng");
            System.out.println("5. Xóa Invoice theo Mã mặt hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            
            try {
                luaChon = scanner.nextInt();
                scanner.nextLine(); // Clear bộ nhớ đệm

                switch (luaChon) {
                    case 1: nhapDanhSach(); break;
                    case 2: xuatDanhSach(); break;
                    case 3: sapXepNoiBot(); break;
                    case 4: timKiemInvoice(); break;
                    case 5: xoaInvoice(); break;
                    case 0: System.out.println("Cảm ơn bạn đã sử dụng chương trình!"); break;
                    default: System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                scanner.nextLine();
                luaChon = -1;
            }
        } while (luaChon != 0);
    }

    // 1. Hàm tạo dữ liệu giả (MOCK DATA) - Đã sửa lỗi thiếu hàm này
    private static void duLieuGia() {
        danhSach.add(new Invoice("MSI01", "Mainboard MSI", 5, 3500000));
        danhSach.add(new Invoice("LOG02", "Mouse Logitech", 15, 450000));
        danhSach.add(new Invoice("ASU03", "Laptop Asus Vivobook", 2, 18000000));
        danhSach.add(new Invoice("DEL04", "Monitor Dell 24 inch", 8, 4200000));
        danhSach.add(new Invoice("COR05", "Ram Corsair 16GB", 20, 1200000));
        danhSach.add(new Invoice("SAM06", "SSD Samsung 500GB", 12, 1550000));
        danhSach.add(new Invoice("RAZ07", "Keyboard Razer", 4, 2800000));
        danhSach.add(new Invoice("NVI08", "VGA RTX 3060", 3, 9500000));
        danhSach.add(new Invoice("SEA09", "HDD Seagate 2TB", 6, 1400000));
        danhSach.add(new Invoice("COO10", "Case Cooler Master", 10, 1100000));
        System.out.println("Đã khởi tạo 10 dữ liệu mẫu.");
    }

    // Hàm hỗ trợ tìm kiếm theo mã (Dùng cho cả nhập, tìm kiếm và xóa)
    private static Invoice timInvoiceTheoMa(String ma) {
        for (Invoice inv : danhSach) {
            if (inv.getPartNumber().equalsIgnoreCase(ma)) {
                return inv;
            }
        }
        return null;
    }

    private static void nhapDanhSach() {
        System.out.print("Bạn muốn nhập thêm bao nhiêu hóa đơn? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin hóa đơn thứ " + (danhSach.size() + 1) + ":");
            String ma;
            while (true) {
                System.out.print(" - Mã mặt hàng: ");
                ma = scanner.nextLine();
                if (timInvoiceTheoMa(ma) == null) break;
                System.out.println("Lỗi: Mã đã tồn tại! Vui lòng nhập mã khác.");
            }
            System.out.print(" - Mô tả: ");
            String moTa = scanner.nextLine();
            System.out.print(" - Số lượng: ");
            int sl = scanner.nextInt();
            System.out.print(" - Đơn giá: ");
            double gia = scanner.nextDouble();
            scanner.nextLine();

            danhSach.add(new Invoice(ma, moTa, sl, gia));
        }
    }

    private static void xuatDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách đang trống!");
            return;
        }
        System.out.println("\nDANH SÁCH HÓA ĐƠN HIỆN TẠI:");
        for (Invoice inv : danhSach) {
            System.out.println(inv);
        }
    }

    private static void sapXepNoiBot() {
        int n = danhSach.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (danhSach.get(j).getPartNumber().compareToIgnoreCase(danhSach.get(j + 1).getPartNumber()) > 0) {
                    Invoice temp = danhSach.get(j);
                    danhSach.set(j, danhSach.get(j + 1));
                    danhSach.set(j + 1, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp xong danh sách theo Mã mặt hàng.");
    }

    private static void timKiemInvoice() {
        System.out.print("Nhập mã mặt hàng cần tìm: ");
        String ma = scanner.nextLine();
        Invoice found = timInvoiceTheoMa(ma);
        if (found != null) {
            System.out.println("Đã tìm thấy: " + found);
        } else {
            System.out.println("Không tìm thấy hóa đơn có mã: " + ma);
        }
    }

    // 5. Hàm xóa - Đã sửa lỗi viết dở
    private static void xoaInvoice() {
        System.out.print("Nhập mã mặt hàng cần xóa: ");
        String ma = scanner.nextLine();
        Invoice found = timInvoiceTheoMa(ma);
        if (found != null) {
            danhSach.remove(found);
            System.out.println("Đã xóa hóa đơn thành công!");
        } else {
            System.out.println("Không tìm thấy hóa đơn có mã: " + ma + " để xóa.");
        }
    }
}