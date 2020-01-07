package com.mindtree.company.controller;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.company.entity.Department;
import com.mindtree.company.entity.Employee;
import com.mindtree.company.entitydto.DepartmentDto;
import com.mindtree.company.entitydto.EmployeeDto;
import com.mindtree.company.service.CompanyService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CompanyAppControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CompanyService companyservice;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddDepartmentWithEmployees() throws Exception
	{
		List<EmployeeDto> employeeList = new ArrayList<EmployeeDto>();
		
		EmployeeDto e1= new  EmployeeDto(1,67877,"kalyan",678,null);
		EmployeeDto e2= new  EmployeeDto(2,67877,"kalyan",678,null);
		employeeList.add(e1);
		employeeList.add(e2);
		DepartmentDto d =new DepartmentDto(1,"dept1",employeeList);
		
		
		ObjectMapper objectMapper =new ObjectMapper();
		String json = objectMapper.writeValueAsString(d);
		Mockito.when(
				companyservice.addDepartmentWithUsers(Mockito.any(DepartmentDto.class))).thenReturn(d);
		
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);
        	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
   
            MockHttpServletResponse response = result.getResponse();
       
            assertEquals(HttpStatus.OK.value(), response.getStatus());
				
		
	}
	

}
