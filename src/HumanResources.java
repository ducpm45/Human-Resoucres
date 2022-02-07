import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HumanResources {
	static Scanner sc = new Scanner(System.in);

	static {
		menu();
		System.out.println();
	}

	static ArrayList<Staff> list = new ArrayList<>();
	static ArrayList<Department> listdp = new ArrayList<>();

	static Department dp1 = new Department("BU", "Kinh Doanh", 0);
	static Department dp2 = new Department("PR", "Dự Án", 0);
	static Department dp3 = new Department("TE", "Kĩ Thuật", 0);

	public static void main(String[] args) {
		listdp.add(dp1);
		listdp.add(dp2);
		listdp.add(dp3);
		Employee nv1 = new Employee("001", "Nguyễn Văn A", 22, 3, 2.5, "22-02-2020", "Kinh Doanh", 18);
		nv1.calculateSalary();
		list.add(nv1);
		dp1.addEmployee();
		Manager nv2 = new Manager("002", "Phạm Thị B", 28, 1, 3.1, "22-02-2019", "Dự Án", "Project Leader");
		nv2.calculateSalary();
		list.add(nv2);
		dp2.addEmployee();
		Employee nv3 = new Employee("003", "Nguyễn Văn C", 26, 0, 2.8, "22-02-2018", "Kĩ Thuật", 24);
		nv3.calculateSalary();
		list.add(nv3);
		dp3.addEmployee();

		int select;
		do {
			System.out.print("Chọn chức năng bạn muốn sử dụng: ");
			select = sc.nextInt();
			switch (select) {
			case 0:
				menu();
				break;
			case 1:
				displayInfo();
				break;
			case 2:
				displayDepartment();
				break;
			case 3:
				displayByDepartment();
				break;
			case 4:
				inputInfo();
				break;
			case 5:
				System.out.print("Chọn 1 - Tìm kiếm theo Mã NV, Chọn 2 - Tìm kiếm theo Tên NV: ");
				int find = sc.nextInt();
				sc.nextLine();
				if (find == 1) {
					findById();
				}
				sc.nextLine();
				if (find == 2) {

					findByName();
				}
				break;
			case 6:
				System.out.println("Bảng lương theo thứ tự tăng dần: ");
				System.out.println();
				ascendingSalary();
				break;
			case 7:
				System.out.println("Bảng lương theo thứ tự giảm dần: ");
				System.out.println();
				descendingSalary();
				break;
			default:
				break;
			}
		} while (select != 8);
	}

	/*
	 * Introduce the function and usage of the application
	 */
	public static void menu() {
		System.out.println("Các chức năng và cách sử dụng của ứng dụng:");
		System.out.println("Chọn 1 - Hiển thị danh sách nhân viên hiện có của công ty.");
		System.out.println("Chọn 2 - Hiển thị các bộ phận của công ty.");
		System.out.println("Chọn 3 - Hiển thị nhân viên theo từng bộ phận.");
		System.out.println("Chọn 4 - Thêm nhân viên mới vào công ty.");
		System.out.println("Chọn 5 - Tìm kiếm thông tin nhân viên theo tên hoặc mã NV");
		System.out.println("Chọn 6 - Hiển thị bảng lương theo thứ tự tăng dần.");
		System.out.println("Chọn 7 - Hiển thị bảng lương theo thứ tự giảm dần.");
		System.out.println("Chọn 8 - Thoát khỏi ứng dụng !");
		System.out.println("Chọn 0 - Hiển thị Menu hướng dẫn !");
	}

	/*
	 * Display a list of the company's existing employees
	 */
	public static void displayInfo() {
		System.out.println("Danh sách nhân viên hiện có của công ty:");
		System.out.println();
		System.out.printf("|%-5s|%6s%-12s|%-4s|%-12s|%3s%-10s|%7s%-14s|\n", "Mã NV", " ", "Tên NV", "Tuổi",
				"Ngày vào cty", " ", "Bộ phận", " ", "Chức vụ");
		for (Staff st : list) {
			st.displayInformation();
		}
	}

	/*
	 * Showing departments in the company
	 */
	public static void displayDepartment() {
		System.out.printf("|%-5s|%3s%-9s|%-5s|\n", "Mã BP", " ", "Tên BP", "Số NV");
		for (Department dp : listdp) {
			System.out.print(dp);
		}

	}

	/*
	 * Showing employees of each department
	 */
	public static void displayByDepartment() {
		for (Department dp : listdp) {
			System.out.println("Bộ phận " + dp.getNameOfDepartment());
			System.out.printf("|%-5s|%6s%-12s|%-4s|%-12s|%3s%-10s|%7s%-14s|\n", "Mã NV", " ", "Tên NV", "Tuổi",
					"Ngày vào cty", " ", "Bộ phận", " ", "Chức vụ");
			for (Staff st : list) {
				if (st.getDepartment().equals(dp.getNameOfDepartment())) {
					st.displayInformation();
				}
			}
			System.out.println();
		}
	}

	/*
	 * Add new employee to the company
	 */
	public static void inputInfo() {
		System.out.print("Chọn 1- Thêm NV Bình thường, Chọn 2- Thêm NV Quản Lý ");
		int choice = sc.nextInt();
		if (choice == 1) {
			Employee st1 = new Employee();
			System.out.print("Mã NV: ");
			st1.setId(sc.next());
			sc.nextLine();
			System.out.print("Tên NV: ");
			st1.setName(sc.nextLine());
			sc.nextLine();
			System.out.print("Tuổi: ");
			st1.setAge(sc.nextInt());
			sc.nextLine();
			System.out.print("Ngày vào công ty (dd-MM-yyyy): ");
			st1.setStartDate(sc.nextLine());
			sc.nextLine();
			System.out.print("Chọn 1- Bộ phận Kinh Doanh, Chọn 2- Bộ phận Dự Án, " + "Chọn 3- Bộ phận Kĩ Thuật ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				st1.setDepartment(dp1.getNameOfDepartment());
				dp1.addEmployee();
				break;
			case 2:
				st1.setDepartment(dp2.getNameOfDepartment());
				dp2.addEmployee();
				break;
			case 3:
				st1.setDepartment(dp3.getNameOfDepartment());
				dp3.addEmployee();
			default:
				break;

			}
			System.out.print("Hệ số lương: ");
			st1.setPayRate(sc.nextDouble());
			System.out.print("Số ngày nghỉ: ");
			st1.setNumDayOff(sc.nextInt());
			st1.calculateSalary();
			list.add(st1);

		} else if (choice == 2) {
			Manager st2 = new Manager();
			System.out.print("Mã NV: ");
			st2.setId(sc.next());

			sc.nextLine();
			System.out.print("Tên NV: ");
			st2.setName(sc.nextLine());
			sc.nextLine();
			System.out.print("Tuổi: ");
			st2.setAge(sc.nextInt());
			sc.nextLine();
			System.out.print("Ngày vào công ty (dd-MM-yyyy): ");
			st2.setStartDate(sc.nextLine());
			sc.nextLine();
			System.out.print("Chọn 1- Bộ phận Kinh Doanh, Chọn 2- Bộ phận Dự Án, " + "Chọn 3- Bộ phận Kĩ Thuật ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				st2.setDepartment(dp1.getNameOfDepartment());
				dp1.addEmployee();
				st2.setPosition("Business Leader");
				break;
			case 2:
				st2.setDepartment(dp2.getNameOfDepartment());
				dp2.addEmployee();
				st2.setPosition("Project Leader");
				break;
			case 3:
				st2.setDepartment(dp3.getNameOfDepartment());
				dp3.addEmployee();
				st2.setPosition("Technical Leader");
			default:
				break;
			}
			System.out.print("Hệ số lương: ");
			st2.setPayRate(sc.nextDouble());
			System.out.print("Số ngày nghỉ: ");
			st2.setNumDayOff(sc.nextInt());
			st2.calculateSalary();
			list.add(st2);
		} else {
			System.err.println("Chỉ chọn 1 hoặc 2 !");
			sc.nextLine();
		}

	}

	/*
	 * Finding employee information by employee id
	 */
	public static void findById() {
		System.out.print("Nhập Mã NV cần tìm: ");
		String id = sc.nextLine();
		int count = 0;
		for (Staff st : list) {
			if (st.getId().equals(id)) {
				System.out.printf("|%-5s|%6s%-12s|%-4s|%-12s|%3s%-10s|%7s%-14s|\n", "Mã NV", " ", "Tên NV", "Tuổi",
						"Ngày vào cty", " ", "Bộ phận", " ", "Chức vụ");
				st.displayInformation();
				count++;
			}
		}
		if (count == 0) {
			System.err.println("Không có nhân viên này trong công ty !");
		}
	}

	/*
	 * Finding employee information by employee name
	 */
	public static void findByName() {
		System.out.print("Nhập tên NV cần tìm: ");
		String name = sc.nextLine();
		int count = 0;
		for (Staff st : list) {
			if (st.getName().toLowerCase().equals(name.toLowerCase())) {
				System.out.printf("|%-5s|%6s%-12s|%-4s|%-12s|%3s%-10s|%7s%-14s|\n", "Mã NV", " ", "Tên NV", "Tuổi",
						"Ngày vào cty", " ", "Bộ phận", " ", "Chức vụ");
				st.displayInformation();
				count++;
			}
		}
		if (count == 0) {
			System.err.println("Không có nhân viên này trong công ty !");
		}
	}

	/*
	 * Sorting payroll in ascending order
	 */
	public static void ascendingSalary() {
		System.out.printf("|%-5s|%6s%-12s|%3s%-10s|%7s%-14s|%-11s|%-7s|%2s%-12s|\n", "Mã NV", " ", "Tên NV", " ",
				"Bộ phận", " ", "Chức vụ", "Hệ số lương", "Tăng ca", " ", "Lương(VND)");
		Collections.sort(list, (a, b) -> (int) (a.calculateSalary() - b.calculateSalary()));
		for (Staff st : list) {
			st.displaySalary();
		}
	}

	/*
	 * Sorting payroll in descending order
	 */
	public static void descendingSalary() {
		System.out.printf("|%-5s|%6s%-12s|%3s%-10s|%7s%-14s|%-11s|%-7s|%2s%-12s|\n", "Mã NV", " ", "Tên NV", " ",
				"Bộ phận", " ", "Chức vụ", "Hệ số lương", "Tăng ca", " ", "Lương(VND)");
		Collections.sort(list, (a, b) -> (int) (b.calculateSalary() - a.calculateSalary()));
		for (Staff st : list) {
			st.displaySalary();
		}
	}

}
