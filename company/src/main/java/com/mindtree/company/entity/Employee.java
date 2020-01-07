package com.mindtree.company.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String employeeName;
	private int employeeExperience;
	private int employeeSalary;
	@ManyToOne
	Department department;

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeExperience="
				+ employeeExperience + ", employeeSalary=" + employeeSalary + ", department=" + department + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeName, int employeeExperience, int employeeSalary,
			Department department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeExperience = employeeExperience;
		this.employeeSalary = employeeSalary;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeExperience() {
		return employeeExperience;
	}

	public void setEmployeeExperience(int employeeExperience) {
		this.employeeExperience = employeeExperience;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
 

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
