package com.iu.main.countries;

import java.util.ArrayList;
import java.util.Scanner;

public class CountryCountroller {
	private Scanner sc;
	private CountryDAO countryDAO;
	private CountryView countryView;
	private CountryInput countryInput;
	public CountryCountroller() {
		sc = new Scanner(System.in);
		countryDAO = new CountryDAO();
		countryView = new CountryView();
		countryInput = new CountryInput();
		
	}
	
	public void start() throws Exception{
		boolean check = true;
		while(check) {
			System.out.println("1. 나라정보리스트");
			System.out.println("2. 개별나라정보");
			System.out.println("3. 나라 추가");
			System.out.println("4. 나라 삭제");
			System.out.println("5. 나라 수정");
			System.out.println("6. 종    료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				ArrayList<CountryDTO> ar = countryDAO.getList();
				countryView.view(ar);
				break;
			case 2:
				System.out.println("나라ID를 입력하세요");
				String id = sc.next();
				CountryDTO countryDTO =  countryDAO.getDetail(id);
				if(countryDTO != null) {
					countryView.view(countryDTO);
					
				} else {
					countryView.view("Data가 없습니다");
				}
				break;
			case 3:
				countryDTO = countryInput.setData();
				select = countryDAO.setData(countryDTO);
				if(select>0) {
					countryView.view("추가 성공");
				} else {
					countryView.view("추가 실패");
				}
				break;
			case 4:
				countryDTO = countryInput.deleteData();
				select = countryDAO.deleteData(countryDTO);
				if(select>0) {
					countryView.view("삭제 성공");
				} else {
					countryView.view("삭제 실패");
				}
				break;
			case 5:
				countryDTO = countryInput.updateData();
				select = countryDAO.updateData(countryDTO);
				if(select>0) {
					countryView.view("수정 성공");
				} else {
					countryView.view("수정 실패");
				}
				break;
			default:
				check = false;
			
			}
			
		}
		
		
		
	}

}
