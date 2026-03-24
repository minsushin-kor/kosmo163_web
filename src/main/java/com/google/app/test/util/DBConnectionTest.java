package com.google.app.test.util;

import java.sql.Connection;

import com.google.app.departments.DepartmentDAO;
import com.google.app.util.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
//		DBConnection connection = new DBConnection();
//		try {
//			Connection con = connection.getConnection();
//			if(con != null) {
//				System.out.println("연결 성공");
//			}
//			else {
//				System.out.println("연결 실패");
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		DepartmentDAO dao = new DepartmentDAO();
		try {
			dao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
