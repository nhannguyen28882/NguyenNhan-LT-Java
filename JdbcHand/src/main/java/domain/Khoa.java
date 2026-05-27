package domain;
import java.sql.Date;

public class Khoa {
    private String maKhoa, tenKhoa, trgKhoa;
    private Date ngtLap;

    public Khoa() {}
    public Khoa(String maKhoa, String tenKhoa, Date ngtLap, String trgKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.ngtLap = ngtLap;
        this.trgKhoa = trgKhoa;
    }
    // Getter/Setter... (Bạn có thể tự gen thêm nếu cần)
}