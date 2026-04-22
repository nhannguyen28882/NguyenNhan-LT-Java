package qweueh.com;

public class TimbaiHat {

	public static void main(String[] args) {
		String duongDan = "D:/music/bolero/longme.mp3";
		
		// 1. Hãy lấy longme.mp3
		// Dùng lastIndexOf để tìm vị trí dấu gạch chéo cuối cùng
		int viTriGachCheoCuoi = duongDan.lastIndexOf("/");
		
		// Dùng substring để cắt từ sau dấu gạch chéo đến hết chuỗi
		String tenCoDuoi = duongDan.substring(viTriGachCheoCuoi + 1);
		
		System.out.println("Đường dẫn gốc: " + duongDan);
		System.out.println("- Tên bài hát đầy đủ: " + tenCoDuoi);

		// 2. Hãy lấy longme
		// Tìm thêm vị trí dấu chấm cuối cùng (phân cách tên và phần mở rộng)
		int viTriDauChamCuoi = duongDan.lastIndexOf(".");
		
		// Dùng substring với 2 đối số để cắt đoạn giữa
		// Cắt từ sau dấu "/" đến trước dấu "."
		String tenKhongDuoi = duongDan.substring(viTriGachCheoCuoi + 1, viTriDauChamCuoi);
		
		System.out.println("- Tên bài hát không kèm đuôi: " + tenKhongDuoi);
	}

}