package com.google.app.test.countries;

import java.util.Scanner;

import com.google.app.countries.CountriesDAO;

public class CountriesTest {

	public static void main(String[] args) {
		System.out.println("찾고싶은 나라를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		String scCountry = sc.next();
		
		CountriesDAO dao = new CountriesDAO();
		try {	
			dao.detail(scCountry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
