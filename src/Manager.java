import java.text.DecimalFormat;

// Tạo class Manager kế thừa class Staff
public class Manager extends Staff implements ICalculator {
    private String chucDanh;

    // Tạo constructor
    public Manager(int maNhanVien, String ten, int tuoi, double heSoLuong, int ngayVaoLam, int soNgayNghiPhep,
                   String chucDanh) {
        super(maNhanVien, ten, tuoi, heSoLuong, ngayVaoLam, soNgayNghiPhep);
        this.chucDanh = chucDanh;
    }

    // Tạo getter setter
    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    // override phương thức calculateSalary
    public double calculateSalary() {
        if (chucDanh.equals("Business leader")) {
            return super.getHeSoLuong() * 5000000 + 8000000;
        } else if (chucDanh.equals("Project leader")) {
            return super.getHeSoLuong() * 5000000 + 5000000;
        } else {
            return super.getHeSoLuong() * 5000000 + 6000000;
        }
    }

    // override hàm displayInformation
    public void displayInformation() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Mã nhân viên: " + super.getMaNhanVien() + ", Tên: " + super.getTen() + ", Tuổi: "
                + super.getTuoi() + ", Chức danh: " + chucDanh + ", Hệ số lương: " + super.getHeSoLuong()
                + ", Ngày vào làm: " + super.getNgayVaoLam() + ", Bộ phận: " + super.getBoPhan().getTenBoPhan()
                + ", Số ngày nghỉ phép: " + super.getSoNgayNghiPhep() + ", Lương: " + df.format(calculateSalary()));
    }
}
