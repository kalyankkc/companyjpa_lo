package com.mindtree.company.entitydto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.company.entity.Employee;

public class DepartmentDto {

	private int departmentId;

	@Override
	public String toString() {
		return "DepartmentDto [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employeesdto="
				+ employeesdto + "]";
	}

	private String departmentName;

	List<EmployeeDto> employeesdto;

	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentDto(int departmentId, String departmentName, List<EmployeeDto> employeesdto) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employeesdto = employeesdto;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
 
	@JsonIgnoreProperties("departmentdto")
	public List<EmployeeDto> getEmployeesdto() {
		return employeesdto;
	}

	public void setEmployeesdto(List<EmployeeDto> employeesdto) {
		this.employeesdto = employeesdto;
	}

}
