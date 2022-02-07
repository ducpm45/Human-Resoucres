public class Department {

	private String idOfDepartment; // ID of department
	private String nameOfDepartment; // Name of department
	private int numOfEmployee; // Number of employees in the department

	/*
	 * Default constructor
	 */
	public Department() {
	}

	/*
	 * Constructor with parameter
	 * 
	 * @param idOfDepartment
	 * @param nameOfDepartment
	 * @param numOfEmployee
	 */
	public Department(String idOfDepartment, String nameOfDepartment, int numOfEmployee) {
		this.idOfDepartment = idOfDepartment;
		this.nameOfDepartment = nameOfDepartment;
		this.numOfEmployee = numOfEmployee;
	}

	/*
	 * Add staff to the department
	 */
	public void addEmployee() {
		this.numOfEmployee++;
	}

	/*
	 * Displaying employees of each department.
	 */
	@Override
	public String toString() {
		return String.format("|%s%-4s|%s%-11s|%2s%-3d|\n", " ", this.getIdOfDepartment(), " ",
				this.getNameOfDepartment(), " ", this.getNumOfEmployee());
	}

	/*
	 * Getter and Setter methods
	 */
	public String getIdOfDepartment() {
		return idOfDepartment;
	}

	public void setIdOfDepartment(String idOfDepartment) {
		this.idOfDepartment = idOfDepartment;
	}

	public String getNameOfDepartment() {
		return nameOfDepartment;
	}

	public void setNameOfDepartment(String nameOfDepartment) {
		this.nameOfDepartment = nameOfDepartment;
	}

	public int getNumOfEmployee() {
		return numOfEmployee;
	}

	public void setNumOfEmployee(int numOfEmployee) {
		this.numOfEmployee = numOfEmployee;
	}

}
