
import java.time.Year;

public class Computer extends Device implements INetworkable{
    private int ram;            // Dung luong RAM (GB)
    private String cpu;         // Loai bo xu ly
    private boolean coGpuRoi;   // Co GPU roi hay khong

    // them thuoc tinh cua interface
    private String ipAddress;       // Dia chi IP hien tai
    private boolean isConnected;    // Trang thai ket noi

    public Computer(String maThietBi, String tenThietBi, int namSuDung, double giaMua,
                    DeviceStatus trangThai, int ram, String cpu, boolean coGpuRoi) {
        super(maThietBi, tenThietBi, namSuDung, giaMua, trangThai);

        // kiem tra tinh hop le của du lieu
        if (ram <= 0) {
            throw new IllegalArgumentException("Dung luong RAM phai lon hon 0!");
        }
        if (cpu == null || cpu.trim().isEmpty()) {
            throw new IllegalArgumentException("Loai CPU khong duoc de trong!");
        }

        this.ram = ram;
        this.cpu = cpu.trim();
        this.coGpuRoi = coGpuRoi;
    }

    @Override
    public double chiPhiBaoTri() {
        // 5% gia mua
        double chiPhi = getGiaMua() * 0.05;

        // Cong them 2% gia mua neu co GPU roi
        if (coGpuRoi) {
            chiPhi += getGiaMua() * 0.02;
        }

        // Neu thiet bi da su dung tren 5 nam, cong them 1% gia mua
        int namHienTai = Year.now().getValue();
        if (namHienTai - getNamSuDung() > 5) {
            chiPhi += getGiaMua() * 0.01;
        }

        return chiPhi;
    }

    // them phuong thuc cua interface
    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public void connect(String ipAddress) {
        // 1. Dia chi IP khong duoc rong
        if (ipAddress == null || ipAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Dia chi IP khong duoc de trong!");
        }
        // 2. Khong cho phep ket noi lai khi thiet bi dang ket noi
        if (this.isConnected) {
            throw new IllegalStateException("Thiet bi da duoc ket noi mang truoc do! Hay ngat ket noi truoc.");
        }

        this.ipAddress = ipAddress.trim();
        this.isConnected = true;
    }

    @Override
    public void disconnect() {
        // Sau khi ngat ket noi, isConnected ve false va khong con dia chi IP
        this.isConnected = false;
        this.ipAddress = null;
    }

    @Override
    public String toString() {
        return super.toString() + " | RAM: " + ram + "GB | CPU: " + cpu + " | GPU roi: " + (coGpuRoi ? "Co" : "Khong");
    }
}