import java.text.DecimalFormat;

// Tạo class Employee kế thừa class Staff
public class Employee extends Staff implements ICalculator {
    private int gioLamThem;
    private double luong;

    // Tạo constructor
    public Employee(int maNhanVien, String ten, int tuoi, double heSoLuong, int ngayVaoLam, int soNgayNghiPhep,
                    int gioLamThem) {
        super(maNhanVien, ten, tuoi, heSoLuong, ngayVaoLam, soNgayNghiPhep);
        this.gioLamThem = gioLamThem;
    }

    // Tạo getter setter
    public double getLuong() {
        return luong;
    }
    public void setLuong(double luong) {
        this.luong = luong;
    }
    public int getGioLamThem() {
        return gioLamThem;
    }

    public void setGioLamThem(int gioLamThem) {
        this.gioLamThem = gioLamThem;
    }

    // override phương thức calculateSalary
    public double calculateSalary() {
        return super.getHeSoLuong() * 3000000 + gioLamThem * 200000;
    }

    // override hàm displayInformation
    public void displayInformation() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Mã nhân viên: " + super.getMaNhanVien() + ", Tên: " + super.getTen() + ", Tuổi: "
                + super.getTuoi() + ", Hệ số lương: " + super.getHeSoLuong() + ", Ngày vào làm: "
                + super.getNgayVaoLam() + ", Bộ phận: " + super.getBoPhan().getTenBoPhan() + ", Số ngày nghỉ phép: "
                + super.getSoNgayNghiPhep() + ", Giờ làm thêm: " + gioLamThem + ", Lương: "
                + df.format(calculateSalary()));
    }

}
