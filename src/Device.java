// Ma sinh vien: 202418841
// Ho ten: Duong Thi Quynh Anh
import java.time.Year;

public abstract class Device {

    public enum DeviceStatus {
        ACTIVE,             // Dang hoat dong
        UNDER_MAINTENANCE,  // Dang bao tri
        RETIRED             // Da thanh ly
    }

    private final String maThietBi;
    private String tenThietBi;
    private int namSuDung;
    private double giaMua;
    private DeviceStatus trangThai;

    public Device(String maThietBi, String tenThietBi, int namSuDung, double giaMua, DeviceStatus trangThai) {
        // kiem tra tinh hop le của du lieu
        if (maThietBi == null || maThietBi.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma thiet bi khong duoc de trong!");
        }

        if (giaMua <= 0) {
            throw new IllegalArgumentException("Gia mua phai lon hon 0!");
        }

        int namHienTai = Year.now().getValue();
        if (namSuDung <= 0 || namSuDung > namHienTai) {
            throw new IllegalArgumentException("Nam su dung khong hop le!");
        }

        this.maThietBi = maThietBi.trim();
        this.tenThietBi = tenThietBi;
        this.namSuDung = namSuDung;
        this.giaMua = giaMua;
        this.trangThai = trangThai;
    }

    // Phuong thuc truu tuong tinh chi phi bao tri
    public abstract double chiPhiBaoTri();

    // Lay gia mua va nam su dung de lop con tinh phi bao tri
    public double getGiaMua() {
        return giaMua;
    }
    public int getNamSuDung() {
        return namSuDung;
    }

    // lay ma va trang thai de lam phan 5
    public String getMaThietBi() {
        return maThietBi;
    }
    public DeviceStatus getTrangThai() {
        return trangThai;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Nam SD: %d | Gia: %,.0f VND | Trang thai: %s",
                maThietBi, tenThietBi, namSuDung, giaMua, trangThai);
    }

}