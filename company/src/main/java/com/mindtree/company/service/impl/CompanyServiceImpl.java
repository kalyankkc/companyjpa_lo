package com.mindtree.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.company.entity.Department;
import com.mindtree.company.entity.Employee;
import com.mindtree.company.entitydto.DepartmentDto;
import com.mindtree.company.entitydto.EmployeeDto;
import com.mindtree.company.repository.DepartmentRepository;
import com.mindtree.company.repository.EmployeeRepository;
import com.mindtree.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	DepartmentRepository departmentrepo;

	@Autowired
	EmployeeRepository employeerepo;

	public DepartmentDto addDepartmentWithUsers(DepartmentDto departmentdto) {

		List<EmployeeDto> employeedtolist ;
		//= new ArrayList<EmployeeDto>();

		employeedtolist = departmentdto.getEmployeesdto();

		System.out.println(employeedtolist);

		Department department = convertDtoToEntity(departmentdto);

		departmentrepo.saveAndFlush(department);

		Employee employee;

		for (EmployeeDto edto : employeedtolist) {

			employee = new Employee();

			employee = convertDtoToEntity2(edto);

			employee.setEmployeeSalary(edto.getEmployeeExperience() * 200000);

			employee.setDepartment(department);

			employeerepo.save(employee);

		}

		return convertEntityToDto(department);
	}

	private Employee convertDtoToEntity2(EmployeeDto edto) {

		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(edto, Employee.class);

	}

	private EmployeeDto convertEntityToDto2(Employee employee) {

		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(employee, EmployeeDto.class);

	}

	private Department convertDtoToEntity(DepartmentDto departmentdto) {

		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(departmentdto, Department.class);
	}

	private DepartmentDto convertEntityToDto(Department department) {

		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(department, DepartmentDto.class);
	}

	public List<DepartmentDto> getEmployees() {

		List<Department> departmentlist = new ArrayList<Department>();

		DepartmentDto temp;
		
		EmployeeDto employeedto;

		List<Department> requireddepartmentlist = new ArrayList<Department>();

		List<DepartmentDto> result = new ArrayList<DepartmentDto>();
		
		
		List<EmployeeDto> employeedtolist = new ArrayList<EmployeeDto>();

		List<Employee> employeelist = new ArrayList<Employee>();

		departmentlist = departmentrepo.findAll();

		

		int sum = 0;
		for (Department department2 : departmentlist) {

			employeelist = department2.getEmployees();

			for (Employee employee : employeelist) {

				sum = sum + employee.getEmployeeSalary();

			}

			if (sum > 5000000) {
				requireddepartmentlist.add(department2);
			}
		}
		
		System.out.println(requireddepartmentlist);

		for (Department department : requireddepartmentlist) {

			temp = new DepartmentDto();

			temp = convertEntityToDto(department);
			
			for (Employee employee : department.getEmployees()  ) {
				
				employeedto=convertEntityToDto2(employee);
				
				employeedtolist.add(employeedto);
					
			}
			
			temp.setEmployeesdto(employeedtolist);

			result.add(temp);
		}

		return result;
	}

}
