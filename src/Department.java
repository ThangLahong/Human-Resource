// Tạo class Department chứa thông tin về bộ phận
public class Department {
    private String maBoPhan;
    private String tenBoPhan;
    private int soNhanVien;

    // Tạo constructor để khởi tạo các đối tượng
    public Department(String maBoPhan, String tenBoPhan) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
    }

    // Tạo các getter setter để lấy ra, cập nhật các giá trị của các thuộc tính
    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public int getSoNhanVien() {
        return soNhanVien;
    }

    public void setSoNhanVien(int soNhanVien) {
        this.soNhanVien = soNhanVien;
    }

    // Tạo phương thức toString để hiển thị thông tin về bộ phận
    public String toString() {
        return "Mã bộ phận: " + maBoPhan + ", Tên bộ phận: " + tenBoPhan + ", Số lượng nhân viên: " + soNhanVien;
    }
}
