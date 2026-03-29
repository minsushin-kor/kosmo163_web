package com.google.app.community;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.app.util.DBConnection;

public class CommunityDAO {
	
	private DBConnection connection;

	public CommunityDAO() {
		this.connection = new DBConnection();
	}
	
	public ArrayList<CommunityDTO> list() throws Exception {
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM COMMUNITY";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<CommunityDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			CommunityDTO communityDTO = new CommunityDTO();
			
			int cnum = rs.getInt("NUM");
			String ctitle = rs.getString("TITLE");
			String cname = rs.getString("NAME");
			Date ctime = rs.getDate("CREATE_TIME");
			String ccontents = rs.getString("CONTENTS");
			int cstar = rs.getInt("STAR");
			
			communityDTO.setNum(cnum);
			communityDTO.setTitle(ctitle);
			communityDTO.setName(cname);
			communityDTO.setCreateTime(ctime);
			communityDTO.setContents(ccontents);
			communityDTO.setStar(cstar);
			
			ar.add(communityDTO);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	public CommunityDTO detail(int communityNum) throws Exception {
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM COMMUNITY WHERE NUM =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		//? 세팅
		st.setInt(1, communityNum);
		
		ResultSet rs = st.executeQuery();
		CommunityDTO dto=null;
		if(rs.next()) {
			dto = new CommunityDTO();
			dto.setNum(rs.getInt("NUM"));
			dto.setTitle(rs.getString("TITLE"));
			dto.setName(rs.getString("NAME"));
			dto.setCreateTime(rs.getDate("CREATE_TIME"));
			dto.setContents(rs.getString("CONTENTS"));
			dto.setStar(rs.getInt("STAR"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return dto;
	}
	
	public int delete(CommunityDTO communityDTO) throws Exception {
		Connection con = connection.getConnection();
		
		String sql ="DELETE COMMUNITY WHERE NUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, communityDTO.getNum());
				
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int create(CommunityDTO communityDTO) throws Exception{
		Connection con = connection.getConnection();
		String sql="""
					INSERT INTO COMMUNITY 
					VALUES (COMM_SEQ.NEXTVAL, ?, ?, sysdate, ?, ?)
					""";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, communityDTO.getTitle());
		st.setString(2, communityDTO.getName());
		st.setString(3, communityDTO.getContents());
		st.setInt(4, communityDTO.getStar());
		
		int result = st.executeUpdate();
				
		st.close();
		con.close();
		
		return result;
	}
	
	public int update(CommunityDTO communityDTO) throws Exception {
		Connection con = connection.getConnection();
		
		String sql = """
				UPDATE COMMUNITY SET 
						TITLE=?,
						NAME=?,
						CREATE_TIME = sysdate,
						CONTENTS = ?,
						STAR = ?
					WHERE NUM=?
				
			""";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, communityDTO.getTitle());
	st.setString(2, communityDTO.getName());
	st.setString(3, communityDTO.getContents());
	st.setInt(4, communityDTO.getStar());
	st.setLong(5, communityDTO.getNum());
	
	int result = st.executeUpdate();
	
	st.close();
	con.close();
	
	return result;
	
	}
}
