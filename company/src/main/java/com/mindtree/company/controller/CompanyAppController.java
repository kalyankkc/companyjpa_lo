package com.mindtree.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.company.apiresponse.ApiResponse;
import com.mindtree.company.entitydto.DepartmentDto;
import com.mindtree.company.service.CompanyService;

@RestController
public class CompanyAppController {

	@Autowired
	CompanyService companyservice;

	@PostMapping(path = "/addDepartmentWith")
	public ApiResponse addDepartmentWithUsers(@RequestBody DepartmentDto departmentdto) {

		String message = "";

		ApiResponse response = new ApiResponse();
		try {
			DepartmentDto temp = companyservice.addDepartmentWithUsers(departmentdto);

			response.setBody(temp);
			response.setError(false);
			response.setSucess(true);

			message = "Inserted sucessfully  with id" + departmentdto.getDepartmentId();

			response.setMessage(message);

		} catch (Exception e) {
			response.setBody("not inserted");

			response.setError(true);
			response.setSucess(false);
			response.setMessage(e.getMessage());

		}
		return response;
	}

	@GetMapping(path = "/getEmployees")
	public List<DepartmentDto> getEmployees() {
		return companyservice.getEmployees();

	}

}
