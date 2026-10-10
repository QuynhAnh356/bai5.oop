

public class Projector extends Device {
    private int doSang;                 // Do sang (lumen)
    private int soGioSuDungBongDen;     // So gio da su dung bong den

    public Projector(String maThietBi, String tenThietBi, int namSuDung, double giaMua,
                     DeviceStatus trangThai, int doSang, int soGioSuDungBongDen) {
        super(maThietBi, tenThietBi, namSuDung, giaMua, trangThai);

        // kiem tra tinh hop le của du lieu
        if (doSang <= 0) {
            throw new IllegalArgumentException("Do sang phai lon hon 0!");
        }
        if (soGioSuDungBongDen < 0) {
            throw new IllegalArgumentException("So gio su dung bong den khong hop le!");
        }

        this.doSang = doSang;
        this.soGioSuDungBongDen = soGioSuDungBongDen;
    }

    // Cong thuc: 3% gia mua + 1.500.000 VND neu bong den da su dung tren 3.000 gio
    @Override
    public double chiPhiBaoTri() {
        // 3% gia mua
        double chiPhi = getGiaMua() * 0.03;
        // Cong them 1.500.000 neu bong den da su dung tren 3.000 gio
        if (soGioSuDungBongDen > 3000) {
            chiPhi += 1500000;
        }
        return chiPhi;
    }

    @Override
    public String toString() {
        return super.toString() + " | Do sang: " + doSang + " lumens | Gio da dung: " + soGioSuDungBongDen + "h";
    }
}