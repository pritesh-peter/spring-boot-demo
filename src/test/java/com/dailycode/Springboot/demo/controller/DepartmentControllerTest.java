package com.dailycode.Springboot.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dailycode.Springboot.demo.entity.Department;
import com.dailycode.Springboot.demo.service.DepartmentService;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		
		department = Department.builder()
							.departmentAddress("USA")
							.departmentCode("CE")
							.departmentName("Computer Engineering")
							.departmentId(1L)
							.build();
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department	inputDepartment = Department.builder()
					.departmentAddress("USA")
					.departmentCode("CE")
					.departmentName("Computer Engineering")
					.departmentId(1L)
					.build();
		
		Mockito.when(departmentService.saveDepartment(inputDepartment))
				.thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "\"departmentName\" : \"Computer Engineering\",\r\n"
						+ "\"departmentAddress\" : \"USA\",\r\n"
						+ "\"departmentCode\" : \"CE\"\r\n"
						+ "}"))
						.andExpect(MockMvcResultMatchers.status().isOk());
		
//		fail("Not yet implemented");
	}

	@Test
	void testFetchDepartmentById() {
//		fail("Not yet implemented");
	}

}
