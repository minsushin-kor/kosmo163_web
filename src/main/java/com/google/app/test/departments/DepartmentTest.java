package com.google.app.test.departments;

import com.google.app.departments.DepartmentDAO;

public class DepartmentTest {

	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		
		try {
//			dao.list();
			dao.detail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
