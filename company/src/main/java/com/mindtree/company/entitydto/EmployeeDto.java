package com.mindtree.company.entitydto;

public class EmployeeDto {

	private int employeeId;
	private int employeeSalary;
	private String employeeName;
	private int employeeExperience;

	DepartmentDto departmentdto;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(int employeeId, int employeeSalary, String employeeName, int employeeExperience,
			DepartmentDto departmentdto) {
		super();
		this.employeeId = employeeId;
		this.employeeSalary = employeeSalary;
		this.employeeName = employeeName;
		this.employeeExperience = employeeExperience;
		this.departmentdto = departmentdto;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", employeeSalary=" + employeeSalary + ", employeeName="
				+ employeeName + ", employeeExperience=" + employeeExperience + ", departmentdto=" + departmentdto
				+ "]";
	}

	public int getEmployeeExperience() {
		return employeeExperience;
	}

	public void setEmployeeExperience(int employeeExperience) {
		this.employeeExperience = employeeExperience;
	}

	public DepartmentDto getDepartmentdto() {
		return departmentdto;
	}

	public void setDepartmentdto(DepartmentDto departmentdto) {
		this.departmentdto = departmentdto;
	}

}
