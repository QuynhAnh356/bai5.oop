// Ma sinh vien: 202418841
// Ho ten: Duong Thi Quynh Anh

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Them du lieu vao phong
        System.out.println("1. Them du lieu vao phong");
        // May tinh
        Computer pc1 = new Computer("PC01", "May tinh 01", 2022, 12000000,
                Device.DeviceStatus.ACTIVE, 16, "Core i5", false);
        Computer pc2 = new Computer("PC02", "May tinh 02", 2023, 20000000,
                Device.DeviceStatus.ACTIVE, 32, "Core i7", true);
        Computer pc3 = new Computer("PC03", "May tinh 03", 2017, 10000000,
                Device.DeviceStatus.UNDER_MAINTENANCE, 8, "Core i3", false);
        Computer pc4 = new Computer("PC04", "May tinh 04", 2021, 15000000,
                Device.DeviceStatus.ACTIVE, 16, "Core i5", true);

        // May in
        Printer pr1 = new Printer("PR01", "May in laser", 2021, 3500000,
                Device.DeviceStatus.ACTIVE, "Laser", 45000, false);
        NetworkPrinter pr2 = new NetworkPrinter("PR02", "May in mang", 2019, 8000000,
                Device.DeviceStatus.ACTIVE, "Laser", 120000, true);
        Printer pr3 = new Printer("PR03", "May in phun mau", 2022, 5000000,
                Device.DeviceStatus.ACTIVE, "Phun", 15000, true);

        // May chieu
        Projector proj1 = new Projector("PJ01", "May chieu giang duong", 2018, 15000000,
                Device.DeviceStatus.UNDER_MAINTENANCE, 3500, 3200);
        Projector proj2 = new Projector("PJ02", "May chieu hoi truong", 2022, 18000000,
                Device.DeviceStatus.ACTIVE, 4000, 800);

        // 2 phong thuc hanh
        LabRoom lab1 = new LabRoom("LAB01", "Phong Lab 01", 30);
        LabRoom lab2 = new LabRoom("LAB02", "Phong Lab 02", 30);

        // Add thiet bi vao cac phong
        lab1.addDevice(pc1);
        lab1.addDevice(pc2);
        lab1.addDevice(pr1);
        lab1.addDevice(proj1);

        lab2.addDevice(pc3);
        lab2.addDevice(pc4);
        lab2.addDevice(pr2);
        lab2.addDevice(pr3);
        lab2.addDevice(proj2);
        System.out.println();


        // 2. Thu them thiet bi trung ma
        System.out.println("2. Thu them thiet bi trung ma");
        try {
            Computer pcTrung = new Computer("PC01", "May tinh 03", 2024, 10000000,
                    Device.DeviceStatus.ACTIVE, 8, "Core i3", false);
            lab1.addDevice(pcTrung);
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
        System.out.println();


        // 3. In danh sach thiet bi trong tung phong
        System.out.println("3. In danh sach thiet bi trong tung phong");
        System.out.println(lab1);
        for (Device d : lab1.getDanhSachThietBi()) {
            System.out.println(d);
        }
        System.out.println();
        System.out.println(lab2);
        for (Device d : lab2.getDanhSachThietBi()) {
            System.out.println(d);
        }
        System.out.println();


        // 4. Chi phi bao tri tung phong
        System.out.println("4. Chi phi bao tri tung phong");
        System.out.println("Lab 1: " + lab1.calculateAnnualMaintenanceCost() + " VND");
        System.out.println("Lab 2: " + lab2.calculateAnnualMaintenanceCost() + " VND");
        System.out.println();


        // 5. Thiet bi can bao tri
        System.out.println("5. Thiet bi can bao tri");
        System.out.println("Lab 1:");
        for (Device d : lab1.getDevicesRequiringMaintenance()) {
            System.out.println(d);
        }
        System.out.println("Lab 2:");
        for (Device d : lab2.getDevicesRequiringMaintenance()) {
            System.out.println(d);
        }
        System.out.println();


        // 6. Ket noi mang
        System.out.println("6. Ket noi mang ");
        pc1.connect("ip1");
        pc2.connect("ip2");
        pc3.connect("ip3");
        pc4.connect("ip4");
        pr2.connect("ip5");

        System.out.println("PC01 IP: " + pc1.getIpAddress());
        System.out.println("PC02 IP: " + pc2.getIpAddress());
        System.out.println("PC03 IP: " + pc3.getIpAddress());
        System.out.println("PC04 IP: " + pc4.getIpAddress());
        System.out.println("PR02 IP: " + pr2.getIpAddress());
        System.out.println();


        // 7. Duyet thiet bi qua interface INetworkable
        System.out.println("7. Duyet thiet bi qua interface INetworkable");
        List<INetworkable> dsMang = new ArrayList<>();
        dsMang.add(pc1);
        dsMang.add(pc2);
        dsMang.add(pc3);
        dsMang.add(pc4);
        dsMang.add(pr2);
        for (INetworkable tb : dsMang) {
            System.out.println("IP: " + tb.getIpAddress() + " | Ket noi: " + tb.isConnected());
            tb.disconnect();
            System.out.println("Sau khi ngat: IP = " + tb.getIpAddress() + " | Ket noi: " + tb.isConnected());
        }
    }
}