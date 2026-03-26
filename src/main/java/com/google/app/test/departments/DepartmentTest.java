package com.google.app.test.departments;

import com.google.app.departments.DepartmentDAO;
import com.google.app.departments.DepartmentDTO;

public class DepartmentTest {

	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		
		try {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartmentName("class3");
			departmentDTO.setManagerId(100);
			departmentDTO.setLocationId(1700);
			
			dao.create(departmentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
