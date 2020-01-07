package com.mindtree.company.service;

import java.util.List;

import com.mindtree.company.entity.Department;
import com.mindtree.company.entity.Employee;
import com.mindtree.company.entitydto.DepartmentDto;

public interface CompanyService {

	public DepartmentDto addDepartmentWithUsers(DepartmentDto departmentdto);

	public List<DepartmentDto> getEmployees();

}
