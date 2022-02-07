public class Manager extends Staff {

	private String position; // Manager's position
	private double responsibSalary; // Responsibility salary

	/*
	 * Default constructor
	 */
	public Manager() {
	}

	/*
	 * Constructor with parameters
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @param numDayOff
	 * @param payRate
	 * @param startDate
	 * @param department
	 * @param position
	 */
	public Manager(String id, String name, int age, int numDayOff, double payRate, String startDate, String department,
			String position) {
		super(id, name, age, numDayOff, payRate, startDate, department);
		this.position = position;
	}

	/*
	 * Displaying the employee information
	 */
	@Override
	public void displayInformation() {

		System.out.printf("|%s%-4s|%2s%-16s|%s%-3d|%s%-11s|%s%-12s|%2s%-19s|\n", " ", getId(), " ", getName(), " ",
				getAge(), " ", getStartDate(), " ", getDepartment(), " ", getPosition());
	}

	/*
	 * Salary calculation method
	 */
	@Override
	public double calculateSalary() {
		if (getDepartment().equals("Kinh Doanh")) {
			responsibSalary = 8000000;
		}
		if (getDepartment().equals("Dá»± Ã�n")) {
			responsibSalary = 5000000;
		}
		if (getDepartment().equals("KÄ© Thuáº­t")) {
			responsibSalary = 6000000;
		}
		super.salary = getPayRate() * MANAGER + responsibSalary;
		return super.salary;
	}

	/*
	 * Displaying the payroll
	 */
	public void displaySalary() {
		System.out.printf("|%s%3s%s|%2s%-16s|%s%-12s|%2s%-19s|%4s%-7.1f|%2s%-5.1f|%s%-13.2f|\n", " ", getId(), " ", " ",
				getName(), " ", getDepartment(), " ", getPosition(), " ", getPayRate(), " ", 0.0, " ", getSalary());
	}

	/*
	 * Getter and Setter methods
	 */
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getResponsibSalary() {
		return responsibSalary;
	}

	public void setResponsibSalary(double responsibSalary) {
		this.responsibSalary = responsibSalary;
	}

}
