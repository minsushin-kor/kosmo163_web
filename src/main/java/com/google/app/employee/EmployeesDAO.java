package com.google.app.employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.app.util.DBConnection;

public class EmployeesDAO {
	private DBConnection connection;
	
	public EmployeesDAO() {
		this.connection = new DBConnection();
	}
	
	public void list() throws Exception {
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet re = st.executeQuery();
		
		while(re.next()) {
			String id = re.getString("EMPLOYEE_ID");
			String firstName = re.getString("FIRST_NAME");
			String lastName = re.getString("LAST_NAME");
			String email = re.getString("EMAIL");
			String pn = re.getString("PHONE_NUMBER");
			Date hd = re.getDate("HIRE_DATE");
			String jobID = re.getString("JOB_ID");
			int sal = re.getInt("SALARY");
			int cPct = re.getInt("COMMISSION_PCT");
			int mID = re.getInt("MANAGER_ID");
			int dID = re.getInt("DEPARTMENT_ID");
			
			System.out.println(id + " / " + firstName  + " / " + lastName + " / " +  email + " / " + pn + " / " + hd 
					+ " / " +  jobID + " / " + sal + " / " + cPct + " / " + mID + " / " + dID);
		}
		
		re.close();
		st.close();
		con.close();
	}
	
	public void detail(int employeeID) throws Exception {
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employeeID);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			System.out.println(firstName + " / " + lastName);
		}
		else {
			System.out.println("찾는 정보가 없다.");
		}
		rs.close();
		st.close();
		con.close();
	}
	
	
}
