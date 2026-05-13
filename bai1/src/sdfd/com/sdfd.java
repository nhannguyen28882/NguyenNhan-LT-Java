package sdfd.com;

import java.util.Scanner;

public class sdfd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// --- 1. Tìm ước số chung lớn nhất của a và b ---
		System.out.println("1. TÌM ƯỚC SỐ CHUNG LỚN NHẤT");
		System.out.print("Nhập số nguyên dương a: ");
		int a = sc.nextInt();
		System.out.print("Nhập số nguyên dương b: ");
		int b = sc.nextInt();
		System.out.println("=> UCLN của " + a + " và " + b + " là: " + timUCLN(a, b));

		// --- 2. Kiểm tra số hoàn thiện ---
		System.out.println("\n2. KIỂM TRA SỐ HOÀN THIỆN");
		System.out.print("Nhập n: ");
		int n1 = sc.nextInt();
		if (isSoHoanThien(n1)) {
			System.out.println("=> " + n1 + " là số hoàn thiện.");
		} else {
			System.out.println("=> " + n1 + " KHÔNG phải là số hoàn thiện.");
		}

		// --- 3. Kiểm tra các chữ số toàn là số chẵn ---
		System.out.println("\n3. KIỂM TRA CHỮ SỐ TOÀN CHẴN");
		System.out.print("Nhập n: ");
		int n2 = sc.nextInt();
		if (isToanChuSoChan(n2)) {
			System.out.println("=> " + n2 + " có các chữ số toàn là số chẵn.");
		} else {
			System.out.println("=> " + n2 + " có chứa chữ số lẻ.");
		}

		// --- 4. Tính biểu thức S(x, n) ---
		System.out.println("\n4. TÍNH BIỂU THỨC S(x, n)");
		System.out.print("Nhập x: ");
		double x = sc.nextDouble();
		System.out.print("Nhập n: ");
		int n3 = sc.nextInt();
		double ketQua = tinhS(x, n3);
		System.out.printf("=> Giá trị S(%.2f, %d) = %.6f\n", x, n3, ketQua);

		sc.close();
	}

	// Hàm tìm UCLN (Thuật toán Euclid)
	public static int timUCLN(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	// Hàm kiểm tra số hoàn thiện
	public static boolean isSoHoanThien(int n) {
		if (n <= 0) return false;
		int tong = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				tong += i;
			}
		}
		return tong == n;
	}

	// Hàm kiểm tra toàn chữ số chẵn
	public static boolean isToanChuSoChan(int n) {
		n = Math.abs(n); // Xử lý trường hợp số âm
		if (n == 0) return true;
		while (n > 0) {
			int chuSo = n % 10;
			if (chuSo % 2 != 0) {
				return false; // Nếu thấy 1 chữ số lẻ thì sai luôn
			}
			n /= 10;
		}
		return true;
	}

	// Hàm tính giai thừa (phục vụ câu 4)
	public static double tinhGiaiThua(int k) {
		double gt = 1;
		for (int i = 1; i <= k; i++) {
			gt *= i;
		}
		return gt;
	}

	// Hàm tính S(x, n) = x + x^3/3! + ... + x^(2n+1)/(2n+1)!
	public static double tinhS(double x, int n) {
		double tong = 0;
		for (int i = 0; i <= n; i++) {
			int mu = 2 * i + 1;
			tong += Math.pow(x, mu) / tinhGiaiThua(mu);
		}
		return tong;
	}
}