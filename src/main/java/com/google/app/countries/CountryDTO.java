package com.google.app.countries;

public class CountryDTO {
	// COUNTRY_ID, COUNTRY_NAME, REGION_ID
	private String countryId;
	private String countryName;
	private int regionId;
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
}
