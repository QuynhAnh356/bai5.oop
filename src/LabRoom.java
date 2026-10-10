// Ma sinh vien: 202418841
// Ho ten: Duong Thi Quynh Anh
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
public class LabRoom {
    private String maPhong;
    private String tenPhong;
    private int sucChua;
    private List<Device> danhSachThietBi;

    public LabRoom(String maPhong, String tenPhong, int sucChua) {
        if (maPhong == null || maPhong.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma phong khong duoc de trong!");
        }
        if (tenPhong == null || tenPhong.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten phong khong duoc de trong!");
        }
        if (sucChua <= 0) {
            throw new IllegalArgumentException("Suc chua phai lon hon 0!");
        }
        this.maPhong = maPhong.trim();
        this.tenPhong = tenPhong.trim();
        this.sucChua = sucChua;
        this.danhSachThietBi = new ArrayList<>();
    }

    public String getMaPhong() {
        return maPhong;
    }
    public String getTenPhong() {
        return tenPhong;
    }
    public List<Device> getDanhSachThietBi() {
        return danhSachThietBi;
    }

    // 1. Them thiet bi vao phong
    public void addDevice(Device device) {
        // Khong chap nhan doi tuong thiet bi null
        if (device == null) {
            throw new IllegalArgumentException("Khong the them thiet bi null vao phong!");
        }
        // Khong them hai thiet bi co cung ma vao mot phong
        if (findDevice(device.getMaThietBi()) != null) {
            throw new IllegalArgumentException("Thiet bi voi ma [" + device.getMaThietBi() + "] da ton tai trong phong " + maPhong + "!");
        }
        // Kiem tra suc chua toi da cua phong
        if (danhSachThietBi.size() >= sucChua) {
            throw new IllegalStateException("Phong " + maPhong + " da day, khong the them thiet bi moi!");
        }
        danhSachThietBi.add(device);
    }


    // 2. Xoa thiet bi theo ma
    public boolean removeDevice(String deviceId) {
        Device device = findDevice(deviceId);
        if (device != null) {
            danhSachThietBi.remove(device);
            return true;
        }
        return false;
    }


    // 3. Tim thiet bi theo ma
    public Device findDevice(String deviceId) {
        if (deviceId == null) return null;
        for (Device d : danhSachThietBi) {
            if (d.getMaThietBi().equalsIgnoreCase(deviceId.trim())) {
                return d;
            }
        }
        return null;
    }


    // 4. Tinh tong chi phi bao tri ca phong
    public double calculateAnnualMaintenanceCost() {
        double tongChiPhi = 0;
        for (Device d : danhSachThietBi) {
            // Goi truc tiep ham chiPhiBaoTri() thong qua da hinh
            tongChiPhi += d.chiPhiBaoTri();
        }
        return tongChiPhi;
    }


    // 5. Loc cac thiet bi can bao tri (Dang UnderMaintenance HOAC su dung tren 5 nam)
    public List<Device> getDevicesRequiringMaintenance() {
        List<Device> ketQua = new ArrayList<>();
        int namHienTai = Year.now().getValue();
        for (Device d : danhSachThietBi) {
            // May dang o trang thai UnderMaintenance hoac may da su dung tren 5 nam
            if (d.getTrangThai() == Device.DeviceStatus.UNDER_MAINTENANCE) {
                ketQua.add(d);
            } else if (namHienTai - d.getNamSuDung() > 5) {
                ketQua.add(d);
            }
        }
        return ketQua;
    }


    @Override
    public String toString() {
        return "Phong [" + maPhong + "] " + tenPhong + " (Suc chua: " + danhSachThietBi.size() + "/" + sucChua + " thiet bi)";
    }
}