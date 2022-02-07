public abstract class Staff implements ICalculator {

	private String id; // Employee ID
	private String name; // Employee name
	private String department; // The department where the employee is working
	private String startDate; // Date of joining the company
	private int age; // Employee age
	private int numDayOff; // Number of days of leave
	private double payRate; // Coefficients salary
	protected double salary; // Amount of salary received

	/*
	 * Default constructor
	 */
	public Staff() {
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
	 */
	public Staff(String id, String name, int age, int numDayOff, double payRate, String startDate, String department) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.numDayOff = numDayOff;
		this.payRate = payRate;
		this.startDate = startDate;
		this.department = department;
	}

	/*
	 * Displaying the employee information
	 */
	public abstract void displayInformation();

	/*
	 * Displaying the payroll
	 */
	public abstract void displaySalary();

	/*
	 * Getter and Setter methods
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumDayOff() {
		return numDayOff;
	}

	public void setNumDayOff(int numDayOff) {
		this.numDayOff = numDayOff;
	}

	public double getPayRate() {
		return payRate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
