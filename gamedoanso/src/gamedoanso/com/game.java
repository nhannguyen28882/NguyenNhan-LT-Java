package gamedoanso.com;

import java.util.Random;
import java.util.Scanner;

public class game {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		while (true) {
			// 1. Máy tính ra 1 số ngẫu nhiên từ 0 đến 100
			int soCuaMay = random.nextInt(101); 
			int soLanDoanToiDa = 7;
			boolean daThang = false;

			System.out.println("\n========= GAME ĐOÁN SỐ =========");
			System.out.println("Máy đã chọn 1 số [0..100]. Bạn có 7 lần đoán!");

			// 2. Vòng lặp cho phép đoán tối đa 7 lần
			for (int i = 1; i <= soLanDoanToiDa; i++) {
				System.out.print("Lần " + i + " - Nhập số bạn đoán: ");
				int soNguoiChoi = scanner.nextInt();

				if (soNguoiChoi == soCuaMay) {
					System.out.println("Chúc mừng! Bạn đã đoán ĐÚNG số " + soCuaMay);
					daThang = true;
					break; // Thoát vòng lặp vì đã thắng
				} else if (soNguoiChoi < soCuaMay) {
					System.out.println("=> Sai rồi! Số bạn đoán NHỎ hơn số của máy.");
				} else  {
					System.out.println("=> Sai rồi! Số bạn đoán LỚN hơn số của máy.");
				}

				// Nếu đã đoán sai đến lần thứ 7
				if (i == soLanDoanToiDa) {
					System.out.println("Game Over nha thím! Bạn đã hết lượt.");
					System.out.println("Số đúng là: " + soCuaMay);
				}
			}

			// 3. Kết thúc game (WIN or LOST)
			if (daThang) {
				System.out.println("KẾT QUẢ: WIN!");
			} else {
				System.out.println("KẾT QUẢ: LOST!");
			}

			// 4. Hỏi xem Người chơi có muốn chơi nữa không
			System.out.print("\nBạn có muốn chơi tiếp không? (C: Tiếp tục / K: Thoát): ");
			String luaChon = scanner.next();
			
			if (luaChon.equalsIgnoreCase("K")) {
				System.out.println("Cảm ơn bạn đã chơi game. Tạm biệt!");
				break; // Thoát vòng lặp while để kết thúc chương trình
			}
		}
		
		scanner.close();
	}

}

