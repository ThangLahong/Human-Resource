// Tạo abstract class Staff implements ICalculator
public abstract class Staff {
    private int maNhanVien;
    private String ten;
    private int tuoi;
    private double heSoLuong;
    private int ngayVaoLam;
    private Department boPhan;
    private int soNgayNghiPhep;

    // Tạo constructor để khởi tạo các đối tượng
    public Staff(int maNhanVien, String ten, int tuoi, double heSoLuong, int ngayVaoLam,
                 int soNgayNghiPhep) {
        this.maNhanVien = maNhanVien;
        this.ten = ten;
        this.tuoi = tuoi;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    // Tạo các getter setter
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(int ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public Department getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(Department boPhan) {
        this.boPhan = boPhan;
    }

    public int getSoNgayNghiPhep() {
        return soNgayNghiPhep;
    }

    public void setSoNgayNghiPhep(int soNgayNghiPhep) {
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    // Tạo hàm abstract displayInformation
    public abstract void displayInformation();
}
