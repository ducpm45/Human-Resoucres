public class Employee extends Staff {
	private double overtimeHour; // Overtime hours

	/*
	 * Default constructor
	 */
	public Employee() {
	}

	/*
	 * Constructor with parameter
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @param numDayOff
	 * @param payRate
	 * @param startDate
	 * @param department
	 * @param overtimeHour
	 */
	public Employee(String id, String name, int age, int numDayOff, double payRate, String startDate, String department,
			double overtimeHour) {
		super(id, name, age, numDayOff, payRate, startDate, department);
		this.overtimeHour = overtimeHour;
	}

	/*
	 * Displaying the employee information
	 */
	@Override
	public void displayInformation() {

		System.out.printf("|%s%-4s|%2s%-16s|%s%-3d|%s%-11s|%s%-12s|%8s%-13s|\n", " ", getId(), " ", getName(), " ",
				getAge(), " ", getStartDate(), " ", getDepartment(), " ", "Không");
	}

	/*
	 * Salary calculation method
	 */
	@Override
	public double calculateSalary() {
		super.salary = getPayRate() * EMPLOYEE + overtimeHour * OVERTIME;
		return super.salary;
	}

	/*
	 * Displaying the payroll
	 */
	@Override
	public void displaySalary() {
		System.out.printf("|%s%3s%s|%2s%-16s|%s%-12s|%8s%-13s|%4s%-7.1f|%s%-6.1f|%s%-13.2f|\n", " ", getId(), " ", " ",
				getName(), " ", getDepartment(), " ", "Không", " ", getPayRate(), " ", getOvertimeHour(), " ",
				getSalary());
	}

	/*
	 * Getter and Setter methods
	 */
	public double getOvertimeHour() {
		return overtimeHour;
	}

	public void setOvertimeHour(double overtimeHour) {
		this.overtimeHour = overtimeHour;
	}

}
