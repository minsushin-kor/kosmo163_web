package com.google.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.app.util.DBConnection;

public class MemberInfoDAO {
	//회원가입 메서드
	public int join(MemberInfoDTO dto) throws Exception {
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		String sql = """
				INSERT INTO MEMBER_INFO (ID, PASSWORD, NAME, EMAIL)
				VALUES (?, ?, ?, ?)
				""";
		
		PreparedStatement st = con.prepareStatement(sql);
				
		st.setString(1, dto.getId());
		st.setString(2, dto.getPassword());
		st.setString(3, dto.getName());
		st.setString(4, dto.getEmail());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	//로그인 메서드
	public MemberInfoDTO login(MemberInfoDTO dto) throws Exception {
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		String sql = """
					SELECT * FROM MEMBER_INFO
					WHERE ID=? AND PASSWORD=?
				""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getId());
		st.setString(2, dto.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			dto.setId("ID");
			dto.setPassword("PASSWORD");
			dto.setName("NAME");
			dto.setEmail("EMAIL");
			
			return dto;
		}
		
		return null;
	
	}
	
	
}
