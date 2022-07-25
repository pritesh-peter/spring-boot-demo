package com.dailycode.Springboot.demo.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dailycode.Springboot.demo.entity.Department;
import com.dailycode.Springboot.demo.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		
		Department department = Department.builder()
								.departmentName("IT")
								.departmentCode("CE")
								.departmentId(1L)
								.build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
				.thenReturn(department);
	}
	
	@Test
	public void whenValidDepartmentName_thenDepartentShouldFound() {
		String departmentName = "IT";
		Department departmentFound = departmentService.fetchDepartmentByName(departmentName);
		
		assertEquals(departmentName, departmentFound.getDepartmentName());
	
	
	}

}
