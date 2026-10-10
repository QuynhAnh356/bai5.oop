
public class Printer extends Device {
    private String loaiMayIn;       // Laser hoac Phun
    private int soTrangDaIn;        // So trang da in
    private boolean laMayInMau;     // Co phai may in mau hay khong

    public Printer(String maThietBi, String tenThietBi, int namSuDung, double giaMua,
                   DeviceStatus trangThai, String loaiMayIn, int soTrangDaIn, boolean laMayInMau) {
        super(maThietBi, tenThietBi, namSuDung, giaMua, trangThai);

        // kiem tra tinh hop le của du lieu
        if (loaiMayIn == null || loaiMayIn.trim().isEmpty()) {
            throw new IllegalArgumentException("Loai may in khong duoc de trong!");
        }
        if (soTrangDaIn < 0) {
            throw new IllegalArgumentException("So trang da in khong hop le!");
        }

        this.loaiMayIn = loaiMayIn.trim();
        this.soTrangDaIn = soTrangDaIn;
        this.laMayInMau = laMayInMau;
    }

    @Override
    public double chiPhiBaoTri() {
        // 4% gia mua
        double chiPhi = getGiaMua() * 0.04;

        // Cong them 500.000 neu so trang da in > 100.000
        if (soTrangDaIn > 100000) {
            chiPhi += 500000;
        }

        // Cong them 300.000 neu la may in mau
        if (laMayInMau) {
            chiPhi += 300000;
        }

        return chiPhi;
    }

    @Override
    public String toString() {
        return super.toString() + " | Loai in: " + loaiMayIn + " | Da in: " + soTrangDaIn + " trang | In mau: " + (laMayInMau ? "Co" : "Khong");
    }
}