package com.google.app.departments;

public class DepartmentDTO {
	// ID, 이름, manager_id, location_id
	// int로 선언했을 경우 null 값이 들어올때 오류가 발생할 수 있음 > Integer로 선언 권장	
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	

	
}
