package com.google.app.community;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.app.util.DBConnection;

public class CommunityDAO {
	
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
}
