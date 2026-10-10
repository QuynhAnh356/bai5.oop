
public interface INetworkable {
    // Lay dia chi IP hien tai
    String getIpAddress();

    // Kiem tra xem co dang ket noi mang hay khong
    boolean isConnected();

    // Thuc hien ket noi mang
    void connect(String ipAddress);

    // Ngat ket noi mang
    void disconnect();
}