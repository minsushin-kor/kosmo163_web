package com.google.app.test.employee;

import com.google.app.employee.EmployeesDAO;

public class EmployeesTest {

	public static void main(String[] args) {
		EmployeesDAO dao = new EmployeesDAO();
		try {
			dao.list();
			//dao.detail(102);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
