package com.iu.main.regions;

import java.util.Scanner;

public class RegionInput {
	private Scanner sc;
	
	public RegionInput() {
		sc = new Scanner(System.in);
		
	}
	
	public RegionDTO updateData() {
		RegionDTO regionDTO = new RegionDTO();
		System.out.println("수정할 대륙번호 입력");
		regionDTO.setRegion_id(sc.nextInt());
		System.out.println("대륙이름 수정정보 입력");
		regionDTO.setRegion_name(sc.next());
		return regionDTO;
		
	}
	
	public RegionDTO deleteData() {
		RegionDTO regionDTO = new RegionDTO();
		System.out.println("삭제할 대륙번호 입력");
		regionDTO.setRegion_id(sc.nextInt());
		
		return regionDTO;
		
	}
	
	public RegionDTO setData() {
		RegionDTO regionDTO = new RegionDTO();
		System.out.println("대륙 번호 입력");
		regionDTO.setRegion_id(sc.nextInt());
		System.out.println("대륙 이름 입력");
		regionDTO.setRegion_name(sc.next());
		 return regionDTO;
		
		
	}
	
}
