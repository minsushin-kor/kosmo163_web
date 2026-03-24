package com.google.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.app.util.DBConnection;

public class CountriesDAO {
	
	public void list() throws Exception {
		//1. DB 연결
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		//2. query 문 작성
		String sql = "SELECT * FROM COUNTRIES";
		
		//3. query 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값을 세팅
		
		
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()){
			String name = rs.getString("COUNTRY_NAME");
			int id = rs.getInt("COUNTRY_ID");
			
			System.out.println(name + " : " + id);
			
		}
		
		//6. 연결 해제
		rs.close();
		st.close();
		con.close();
		
	}
	
	public void detail(String countryID) throws Exception {
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();

		// 특정한 값을 위해 ? 설정
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, countryID);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("COUNTRY_NAME");
			System.out.println(name);
		}
		else {
			System.out.println("일치하는 나라가 없다.");
		}
		
		rs.close();
		st.close();
		con.close();
	}
	
}
