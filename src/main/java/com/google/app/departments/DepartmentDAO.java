package com.google.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.app.util.DBConnection;

public class DepartmentDAO {
	public void list() throws Exception {
		// 1. DB 연결
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		// 2. 쿼리문 작성
		String sql = "SELECT * FROM DEPARTMENTS";
		
		// 3. 쿼리문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. ?값을 세팅 
		
		// 5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("DEPARTMENT_NAME");
			int id = rs.getInt("DEPARTMENT_ID");
			
			System.out.println(name + " : " + id);
		}
		
		// 6. 연결 해제
		
		rs.close();
		st.close();
		con.close();
	}
}
