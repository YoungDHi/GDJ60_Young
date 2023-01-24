package com.iu.main.regions;

import java.util.ArrayList;
import java.util.Scanner;

public class RegionController {
	
	private Scanner sc;
	private RegionDAO regionDAO;
	private RegionView regionView;
	private RegionInput regionInput;
	
	public RegionController() {
		sc = new Scanner(System.in);
		regionDAO = new RegionDAO();
		regionView = new RegionView();
		regionInput = new RegionInput();
	}
	
	public void start() throws Exception {
		boolean check = true;
		ArrayList<RegionDTO> ar = new ArrayList<RegionDTO>();
		while(check) {
			System.out.println("1. 대륙정보리스트");
			System.out.println("2. 개별대륙정보");
			System.out.println("3. 대륙 추가");
			System.out.println("4. 대륙 삭제");
			System.out.println("5. 대륙 수정");
			System.out.println("6. 종료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				ar = regionDAO.getList();
				regionView.view(ar);				
				break;
			case 2:
				System.out.println("대륙 번호를 입력해주세요");
				select = sc.nextInt();
				RegionDTO regionDTO = regionDAO.getDetail(select);
				if (regionDTO != null) {
					regionView.view(regionDTO);
				} else {
					regionView.view("Data가 없습니다");
				}
				break;
			case 3:
				regionDTO = regionInput.setData();
				select = regionDAO.setData(regionDTO);
				if(select>0) {
					regionView.view("추가성공");
				} else {
					regionView.view("추가 실패");
				}
				
				break;
			case 4:
				regionDTO =  regionInput.deleteData();
				select = regionDAO.deleteData(regionDTO);
				if(select>0) {
					regionView.view("삭제 성공");
				} else {
					regionView.view("삭제 실패");
				}
				break;
			case 5:
				regionDTO = regionInput.updateData();
				select = regionDAO.updateData(regionDTO);
				if(select>0) {
					regionView.view("수정 성공");
				} else {
					regionView.view("수정 실패");
				}
				break;
			default:
			check = false;
			
			}
			
		}
		
		
	}
	
	
}
