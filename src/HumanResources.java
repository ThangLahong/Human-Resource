import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

// Tạo class HumanResources chứa hàm main
public class HumanResources {
    public static void main(String[] args) {
        int func = 0;
        Scanner sc = new Scanner(System.in);
        // Tạo ArrayList để chứa thông tin về bộ phận
        ArrayList<Staff> staffList = new ArrayList<>();
        ArrayList<Double> luong = new ArrayList<Double>();

        // Tạo ArrayList để quản lý toàn bộ nhân viên và quản lý
        ArrayList<Department> departmentList = new ArrayList<Department>();


        Department department1 = new Department("A01", "Kỹ thuật");
        Department department2 = new Department("B01", "Nhân sự");
        departmentList.add(department1);
        departmentList.add(department2);

        Employee emp1 = new Employee(1, "Long", 27, 3.0, 1, 1, 2);
        Employee emp2 = new Employee(2, "Tinh", 25, 3.0, 1, 3, 5);
        Employee emp3 = new Employee(3, "Thang", 25, 3.0, 1, 0, 0);
        Manager emp4 = new Manager(4, "Hong", 50, 3.5, 1, 0, "Business leader");
        emp1.setBoPhan(department1);
        emp2.setBoPhan(department2);
        emp3.setBoPhan(department1);
        emp4.setBoPhan(department2);
        emp1.setLuong(emp1.calculateSalary());
        staffList.add(emp1);
        staffList.add(emp2);
        staffList.add(emp3);
        staffList.add(emp4);
        luong.add(emp1.calculateSalary());
        luong.add(emp2.calculateSalary());
        luong.add(emp3.calculateSalary());
        luong.add(emp4.calculateSalary());

        // Dùng vòng lặp do while để yêu cầu chọn chức năng
        do {
            System.out.println("Hãy chọn chức năng (từ 0 - 8): ");
            System.out.println("1: Hiển thị danh sách nhân viên hiện có trong công ty.");
            System.out.println("2: Hiển thị các bộ phận trong công ty.");
            System.out.println("3: Hiển thị nhân viên theo từng bộ phận.");
            System.out.println("4: Thêm nhân viên mới vào công ty.");
            System.out.println("5: Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
            System.out.println("6: Hiển thị bảng lương của nhân viên toàn công ty.");
            System.out.println("7: Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
            System.out.println("8: Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.");
            System.out.println("9: Thêm bộ phận vào công ty.");
            System.out.println("khác : Thoát chương trình.");
            func = sc.nextInt();

            // Dùng switch case để gọi hàm tương ứng
            switch (func) {
                case 1:
                    //showAllStaff(staffList);
                    break;
                case 2:
                    //showAllDepartment(staffList, departmentList);
                    break;
                case 3:
                    //showDepartmentAndStaff(staffList, departmentList);
                    break;
                case 4:
                    //addStaff(sc, staffList, departmentList);
                    break;
                case 5:
                    //findStaff(staffList, sc);
                    break;
                case 6:
                    String message = "Bạn đã chọn 6: Hiển thị bảng lương của nhân viên toàn công ty.";
                    salary(staffList, luong, message);
                    break;
                case 7:
                    //showSalaryIncrease(staffList);
                    break;
                case 8:
                    //showSalaryDecrease(staffList);
                    break;
                case 9:
                    //addDepartment(sc, departmentList);
                    break;
                default:
                    // Nếu nhập giá trị khác 1 - 9 thì thoát chương trình
                    func = 0;
            }
        } while (func != 0);
    }

    // Tạo hàm hiển thị danh sách nhân viên hiện có trong công ty
    public static void showAllStaff(ArrayList<Staff> staffList) {
        System.out.println("Bạn đã chọn 1: Hiển thị danh sách nhân viên hiện có trong công ty.");
        // Nếu chưa có nhân viên thì yêu cầu thêm nhân viên vào
        if (staffList.size() == 0) {
            System.out.println("Chưa có nhân viên, vui lòng thêm nhân viên vào!");
            System.out.println();
            return;
        }
        // Gọi hàm sortById để sắp xếp nhân viên theo thứ tự mã nhân viên
        sortById(staffList);
        // Dùng vòng lặp for để hiển thị thông tin toàn bộ nhân viên
        for (int i = 0; i < staffList.size(); i++) {
            staffList.get(i).displayInformation();
        }
        System.out.println();
    }

    // Tạo hàm hiển thị các bộ phận trong công ty
    public static void showAllDepartment(ArrayList<Staff> staffList, ArrayList<Department> departmentList) {
        // Nếu chưa có bộ phận thì yêu cầu thêm vào
        if (departmentList.size() == 0) {
            System.out.println("Chưa có bộ phận, vui lòng thêm bộ phận!");
            System.out.println();
            return;
        }
        System.out.println("Bạn đã chọn 2: Hiển thị các bộ phận trong công ty.");
        // Gọi hàm totalStaff để tính số nhân viên trong mỗi bộ phận
        totalStaff(staffList);
        // Dùng vòng lặp for để hiển thị thông tin các bộ phận
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println(departmentList.get(i));
        }
        System.out.println();
    }

    // Tạo hàm hiển thị nhân viên theo từng bộ phận
    public static void showDepartmentAndStaff(ArrayList<Staff> staffList, ArrayList<Department> departmentList) {
        // Nếu chưa có bộ phận thì yêu cầu thêm vào
        if (departmentList.size() == 0) {
            System.out.println("Chưa có nhân viên và bộ phận, vui lòng thêm vào!");
            System.out.println();
            return;
        }
        System.out.println("Bạn đã chọn 3: Hiển thị nhân viên theo từng bộ phận.");
        // Gọi hàm sắp xếp thứ tự nhân viên theo mã nhân viên
        sortById(staffList);
        // Gọi hàm tính số nhân viên trong mỗi bộ phận
        totalStaff(staffList);
        // Dùng 2 vòng lặp for lồng nhau để hiển thị thông tin từng bộ phận và từng nhân viên trong mỗi bộ phận
        for (int i = 0; i < departmentList.size(); i++) {
            int temp = 0;
            System.out.println(departmentList.get(i));
            for (int j = 0; j < staffList.size(); j++) {
                if (staffList.get(j).getBoPhan().equals(departmentList.get(i))) {
                    staffList.get(j).displayInformation();
                    temp++;
                }
            }
            // Nếu bộ phận chưa có nhân viên thì thông báo
            if (temp == 0) {
                System.out.println("Bộ phận này chưa có nhân viên!");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Tạo hàm để thêm nhân viên mới vào công ty
    public static void addStaff(Scanner sc, ArrayList<Staff> staffList, ArrayList<Department> departmentList) {
        // Nếu chưa có bộ phận thì yêu cầu thêm bộ phận trước rồi thêm nhân viên sau
        if (departmentList.size() == 0) {
            System.out.println("Chưa có bộ phận, hãy thêm bộ phận trước!");
            System.out.println();
            return;
        }
        System.out.println("Bạn đã chọn 4: Thêm nhân viên mới vào công ty.");
        String chucDanh = "";
        // Mã nhân viên sẽ tự động được gán
        int maNhanVien = staffList.size() + 1;
        // Hỏi user muốn thêm nhân viên hay quản lý
        System.out.print("Bạn muốn thêm nhân viên hay quản lý (1: Nhân viên, 2: Quản lý)? ");
        int type = sc.nextInt();
        // Nếu user nhập sai thì yêu cầu nhập lại
        while (type != 1 && type != 2) {
            System.out.println("Vui lòng nhập số hợp lệ!");
            System.out.print("Bạn muốn thêm nhân viên hay quản lý (1: Nhân viên, 2: Quản lý)? ");
            type = sc.nextInt();
        }
        System.out.print("Tên? ");
        sc.nextLine();
        String ten = sc.nextLine();
        System.out.print("Tuổi? ");
        int tuoi = sc.nextInt();
        System.out.print("Hệ số lương? ");
        double heSoLuong = sc.nextDouble();
        System.out.print("Ngày vào làm? ");
        int ngayVaoLam = sc.nextInt();
        System.out.println("Bộ phận làm việc?");
        // Dùng vòng lặp for để đưa ra các bộ phận mà người dùng muốn thêm nhân viên mới vào
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println(i + 1 + ": " + departmentList.get(i).getTenBoPhan());
        }
        int boPhan = sc.nextInt();
        // Nếu user nhập sai thì yêu cầu nhập lại
        while (boPhan - 1 >= departmentList.size() || boPhan - 1 < 0) {
            System.out.println("Vui lòng nhập số hợp lệ!");
            System.out.println("Bộ phận làm việc?");
            for (int i = 0; i < departmentList.size(); i++) {
                System.out.println(i + 1 + ": " + departmentList.get(i).getTenBoPhan());
            }
            boPhan = sc.nextInt();
        }
        System.out.print("Số ngày nghỉ phép? ");
        int soNgayNghiPhep = sc.nextInt();
        // Nếu user muốn thêm nhân viên thì tạo đối tượng Employee mới
        if (type == 1) {
            System.out.print("Số giờ làm thêm? ");
            int gioLamThem = sc.nextInt();
            Employee emp = new Employee(maNhanVien, ten, tuoi, heSoLuong, ngayVaoLam, soNgayNghiPhep, gioLamThem);
            // Set bộ phận tương mà user đã chọn cho nhân viên mới
            emp.setBoPhan(departmentList.get(boPhan - 1));
            // Thêm nhân viên mới vào ArrayList để quản lý
            staffList.add(emp);
        } else {
            // Nếu user muốn thêm quản lý thì tạo đối tương Manager mới
            // Chọn chức danh cho quản lý mới
            System.out.print("Chức danh (1: Business leader, 2: Project leader, 3: Technical leader)? ");
            int temp = sc.nextInt();
            // Nếu user nhập sai thì yêu cầu nhập lại
            while (temp < 1 || temp > 3) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                System.out.print("Chức danh (1: Business leader, 2: Project leader, 3: Technical leader)? ");
                temp = sc.nextInt();
            }
            if (temp == 1) {
                chucDanh = "Business leader";
            } else if (temp == 2) {
                chucDanh = "Project leader";
            } else {
                chucDanh = "Technical leader";
            }
            Manager emp = new Manager(maNhanVien, ten, tuoi, heSoLuong, ngayVaoLam, soNgayNghiPhep, chucDanh);
            emp.setBoPhan(departmentList.get(boPhan - 1));
            staffList.add(emp);
        }
        System.out.println("Thêm nhân viên thành công!");
        System.out.println();
    }

    // Tạo hàm để tìm kiếm nhân viên theo mã nhân viên hoặc tên
    public static void findStaff(ArrayList<Staff> staffList, Scanner sc) {
        System.out.println("Bạn đã chọn 5: Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        int maNhanVien = 0;
        String ten = "";
        int ketQua = 0;
        // Hỏi user muốn tìm bằng phương thức nào
        System.out.print("Chọn phương thức tìm (1: Tìm theo mã, 2: Tìm theo tên)? ");
        int type = sc.nextInt();
        // Nếu user nhập sai thì yêu cầu nhập lại
        while (type != 1 && type != 2) {
            System.out.println("Vui lòng nhập số hợp lệ!");
            System.out.print("Chọn phương thức tìm (1: Tìm theo mã, 2: Tìm theo tên)? ");
            type = sc.nextInt();
        }
        if (type == 1) {
            System.out.print("Nhập mã nhân viên cần tìm? ");
            maNhanVien = sc.nextInt();
        } else {
            System.out.print("Nhập tên nhân viên cần tìm? ");
            sc.nextLine();
            ten = sc.nextLine();
        }
        System.out.println("Kết quả tìm kiếm:");
        // Dùng vòng lặp for để hiển thị kết quả tìm kiếm
        for (int i = 0; i < staffList.size(); i++) {
            // Hiển thị thông tin nhân viên tìm được
            if (staffList.get(i).getMaNhanVien() == maNhanVien || staffList.get(i).getTen().equalsIgnoreCase(ten)) {
                ketQua++;
                staffList.get(i).displayInformation();
            }
        }
        // Nếu nhân viên cần tìm không tồn tại thì thông báo
        if (ketQua == 0) {
            System.out.println("Nhân viên cần tìm không tồn tại!");
        }
        System.out.println();
    }

    // Tạo hàm hiển thị bảng lương của nhân viên toàn công ty
    public static void salary(ArrayList<Staff> staffList, ArrayList<Double> luong, String message) {
        // Nếu chưa có nhân viên thì yêu cầu thêm vào
        if (staffList.size() == 0) {
            System.out.println("Chưa có nhân viên, vui lòng thêm nhân viên vào!");
            System.out.println();
            return;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(message);

    }

    // Tạo hàm hiển thị bảng lương theo thứ tự tăng dần
    public static void showSalaryIncrease(ArrayList<Staff> staffList) {
        // Nếu chưa có nhân viên thì yêu cầu thêm vào
        if (staffList.size() == 0) {
            System.out.println("Chưa có nhân viên, vui lòng thêm nhân viên vào!");
            System.out.println();
            return;
        }
        // Sắp xếp thứ tự nhân viên theo lương tăng dần
        for (int i = 0; i < staffList.size(); i++) {
//            for (int j = i + 1; j < staffList.size(); j++) {
//                if (staffList.get(i).calculateSalary() > staffList.get(j).calculateSalary()) {
//                    Staff temp = staffList.get(i);
//                    staffList.set(i, staffList.get(j));
//                    staffList.set(j, temp);
//                }
//            }
        }
        String message = "Bạn đã chọn 7: Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.";
        // Gọi hàm hiển thị bảng lương
        //salary(staffList, message);
    }

    // Tạo hàm hiển thị bảng lương theo thứ tự giảm dần
    public static void showSalaryDecrease(ArrayList<Staff> staffList) {
        // Nếu chưa có nhân viên thì yêu cầu thêm vào
        if (staffList.size() == 0) {
            System.out.println("Chưa có nhân viên, vui lòng thêm nhân viên vào!");
            System.out.println();
            return;
        }
        // Sắp xếp nhân viên theo thứ tự lương giảm dần
//        for (int i = 0; i < staffList.size(); i++) {
//            for (int j = i + 1; j < staffList.size(); j++) {
//                if (staffList.get(i).calculateSalary() < staffList.get(j).calculateSalary()) {
//                    Staff temp = staffList.get(i);
//                    staffList.set(i, staffList.get(j));
//                    staffList.set(j, temp);
//                }
//            }
//        }
        String message = "Bạn đã chọn 8: Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.";
        // Gọi hàm hiển thị bảng lương
        //salary(staffList, message);
    }

    // Tạo hàm để thêm bộ phận mới vào công ty
    public static void addDepartment(Scanner sc, ArrayList<Department> departmentList) {
        System.out.println("Bạn đã chọn 9: Thêm bộ phận vào công ty.");
        String maBoPhan = "";
        String tenBoPhan = "";
        System.out.print("Nhập mã bộ phận? ");
        maBoPhan = sc.next();
        System.out.print("Nhập tên bộ phận? ");
        sc.nextLine();
        tenBoPhan = sc.nextLine();
        int eror = 0;
        // Kiểm tra mã và tên bộ phận user nhập vào có trùng với bộ phận có sẵn không
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getMaBoPhan().equalsIgnoreCase(maBoPhan)
                    || departmentList.get(i).getTenBoPhan().equalsIgnoreCase(tenBoPhan)) {
                eror++;
            }
        }
        // Nếu mã hoặc tên bộ phận bị trùng thì yêu cầu nhập lại
        while (eror != 0) {
            System.out.println("Tên hoặc mã bộ phận đã tồn tại, vui lòng nhập lại!");
            System.out.print("Nhập mã bộ phận? ");
            maBoPhan = sc.next();
            System.out.print("Nhập tên bộ phận? ");
            sc.nextLine();
            tenBoPhan = sc.nextLine();
            eror = 0;
            for (int i = 0; i < departmentList.size(); i++) {
                if (departmentList.get(i).getMaBoPhan().equalsIgnoreCase(maBoPhan)
                        || departmentList.get(i).getTenBoPhan().equalsIgnoreCase(tenBoPhan)) {
                    eror++;
                }
            }
        }
        // Tạo bộ phận mới
        Department newDepartment = new Department(maBoPhan, tenBoPhan);
        // Thêm bộ phận mới vào ArrayList để quản lý
        departmentList.add(newDepartment);
        System.out.println("Thêm bộ phận thành công!");
        System.out.println();
    }

    // Tạo hàm tính số nhân viên trong mỗi bộ phận
    public static void totalStaff(ArrayList<Staff> staffList) {
        // Set số nhân viên của mỗi bộ phận về 0
        for (int i = 0; i < staffList.size(); i++) {
            staffList.get(i).getBoPhan().setSoNhanVien(0);
        }
        // Duyệt qua mỗi nhân viên, nhân viên thuộc bộ phận nào thì tăng số nhân viên của bộ phận đó lên 1
        for (int i = 0; i < staffList.size(); i++) {
            staffList.get(i).getBoPhan().setSoNhanVien(staffList.get(i).getBoPhan().getSoNhanVien() + 1);
        }
    }

    // Tạo hàm sắp xếp thứ tự nhân viên theo mã nhân viên
    public static void sortById(ArrayList<Staff> staffList) {
        for (int i = 0; i < staffList.size(); i++) {
            for (int j = i + 1; j < staffList.size(); j++) {
                if (staffList.get(i).getMaNhanVien() > staffList.get(j).getMaNhanVien()) {
                    Staff temp = staffList.get(i);
                    staffList.set(i, staffList.get(j));
                    staffList.set(j, temp);
                }
            }
        }
    }
}
