package com.google.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.app.util.DBConnection;

public class DepartmentDAO {
	private DBConnection connection;
	
	public DepartmentDAO() {
		this.connection = new DBConnection();
	}
	
	public ArrayList<DepartmentDTO> list() throws Exception {
		// 1. DB 연결
		Connection con = connection.getConnection();
		
		// 2. 쿼리문 작성
		String sql = """
				SELECT * FROM DEPARTMENTS
				ORDER BY DEPARTMENT_ID DESC
				""";
		
		// 3. 쿼리문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. ?값을 세팅 
		
		// 5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		ArrayList<DepartmentDTO> ar = new ArrayList<>();
		while(rs.next()) {
			DepartmentDTO dto = new DepartmentDTO();
			
			String name = rs.getString("DEPARTMENT_NAME");
			int id = rs.getInt("DEPARTMENT_ID");
			int mid= rs.getInt("MANAGER_ID");
			int lid = rs.getInt("LOCATION_ID");
			
			dto.setDepartmentName(name);
			dto.setDepartmentId(id);
			dto.setManagerId(mid);
			dto.setLocationId(lid);
			
			ar.add(dto);
		}
		
		// 6. 연결 해제
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	public DepartmentDTO detail(int departmentID) throws Exception {
		
		Connection con = connection.getConnection();
		
		// 특정한 값을 찾기위해 ?로 설정
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		// ? 값 세팅
		st.setInt(1, departmentID);
		
		ResultSet rs = st.executeQuery();
		DepartmentDTO dto = null;
		
		if(rs.next()) {
			dto = new DepartmentDTO();
			dto.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
			dto.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
			dto.setManagerId(rs.getInt("MANAGER_ID"));
			dto.setLocationId(rs.getInt("LOCATION_ID"));
			}
		
		rs.close();
		st.close();
		con.close();
		
		return dto;
	}
}
