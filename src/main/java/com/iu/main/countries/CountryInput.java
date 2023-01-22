package com.iu.main.countries;

import java.util.Scanner;

public class CountryInput {
	private Scanner sc;
	
	public CountryInput() {
		sc = new Scanner(System.in);
	}
	
	public CountryDTO updateData() {
		CountryDTO countryDTO = new CountryDTO();
		System.out.println("수정할 나라 ID 입력");
		countryDTO.setCountry_id(sc.next());
		System.out.println("나라이름 수정내용 입력");
		countryDTO.setCountry_name(sc.next());
		System.out.println("대륙번호 수정내용 입력");
		countryDTO.setRegion_id(sc.nextInt());
		
		return countryDTO;

		
	}
	
	public CountryDTO setData() {
		CountryDTO countryDTO = new CountryDTO();
		System.out.println("나라 ID 입력");
		countryDTO.setCountry_id(sc.next());
		System.out.println("나라 이름 입력");
		countryDTO.setCountry_name(sc.next());
		System.out.println("대륙 ID 입력");
		countryDTO.setRegion_id(sc.nextInt());
		
		return countryDTO;
		
		
	}
	public CountryDTO deleteData() {
		CountryDTO countryDTO = new CountryDTO();
		System.out.println("삭제할 나라ID 입력");
		countryDTO.setCountry_id(sc.next());
		
		return countryDTO;
		
	}
	
}
