package com.iu.main.locations;

import java.util.Scanner;

public class LocationInput {

	Scanner sc;
	
	public LocationInput() {
		
		sc = new Scanner(System.in);
		
	}
	
	public LocationDTO updateData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("수정할 주소번호 입력");
		locationDTO.setLocation_id(sc.nextInt());
		System.out.println("수정될 주소    입력");
		locationDTO.setStreet_address(sc.next());
		System.out.println("수정될 우편번호 입력");
		locationDTO.setPostal_code(sc.next());
		
		return locationDTO;
		
	}
	
	public LocationDTO deleteData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("삭제할 주소번호 입력");
		locationDTO.setLocation_id(sc.nextInt());
		return locationDTO;
	}
	
	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("주소    입력");
		locationDTO.setStreet_address(sc.next());
		System.out.println("우편번호 입력");
		locationDTO.setPostal_code(sc.next());
		System.out.println("도시    입력");
		locationDTO.setCity(sc.next());
		System.out.println("지역    입력");
		locationDTO.setState_province(sc.next());
		System.out.println("나라    입력");
		locationDTO.setCountry_id(sc.next());
		return locationDTO;
	}
	
}
