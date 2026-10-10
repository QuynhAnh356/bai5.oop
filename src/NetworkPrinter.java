public class NetworkPrinter extends Printer implements INetworkable {
    private String ipAddress;
    private boolean isConnected;
    public NetworkPrinter(String maThietBi, String tenThietBi, int namSuDung, double giaMua,
                          DeviceStatus trangThai, String loaiMayIn, int soTrangDaIn, boolean laMayInMau) {
        super(maThietBi, tenThietBi, namSuDung, giaMua, trangThai, loaiMayIn, soTrangDaIn, laMayInMau);
        this.isConnected = false;
        this.ipAddress = null;
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
        if (ipAddress == null || ipAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Dia chi IP khong duoc de trong!");
        }
        if (this.isConnected) {
            throw new IllegalStateException("May in mang da duoc ket noi truoc do!");
        }
        this.ipAddress = ipAddress.trim();
        this.isConnected = true;
    }
    @Override
    public void disconnect() {
        this.isConnected = false;
        this.ipAddress = null;
    }
    @Override
    public String toString() {
        return super.toString() + " | IP: " + (isConnected ? ipAddress : "Chua ket noi");
    }
}