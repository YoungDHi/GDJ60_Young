package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private EmployeeInput employeeInput;
	public EmployeeController() {
		sc = new Scanner(System.in);
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		employeeInput = new EmployeeInput();
	}
	
	
	public void start() throws Exception{
		boolean check=true;
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		while(check) {	
			System.out.println("1. 사원정보리스트");
			System.out.println("2. 개별사원정보");
			System.out.println("3. 사원 검색");
			System.out.println("4. 사원 추가");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 사원 수정");
			System.out.println("7. 종료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
			case 2:
				System.out.println("사원번호를 입력하세요");
				select = sc.nextInt();
				EmployeeDTO employeeDTO = employeeDAO.getDetail(select);
				if(employeeDTO != null) {
					employeeView.view(employeeDTO);
				}else {
					employeeView.view("Data가 없습니다");
				}
				break;
			case 3:
				System.out.println("사원의 이름을 검색해주세요");
				String add = sc.next();
				ar = employeeDAO.getFind(add);
				if(ar.size() != 0) {
					employeeView.view(ar);
				}else {
					System.out.println("Data가 없습니다");
				}
				
				break;
			case 4:
				employeeDTO = employeeInput.setData();
				select = employeeDAO.setData(employeeDTO);
				if(select>0) {
					employeeView.view("추가 성공");
				} else {
					employeeView.view("추가 실패");
				}
				
				break;
			case 5:
				employeeDTO = employeeInput.deleteData();
				select = employeeDAO.deleteData(employeeDTO);
				if(select>0) {
					employeeView.view("삭제 성공");
				} else {
					employeeView.view("삭제 실패");
				}
				break;
			case 6:
				employeeDTO = employeeInput.updateDate();
				select = employeeDAO.update(employeeDTO);
				if(select>0) {
					employeeView.view("삭제 성공");
				} else {
					employeeView.view("삭제 실패");
				}
				break;
			default:
				check = false;
			}
				
			
				
				
				
				
					
		}
			
		
		
		
			
			
			
		
		
		
	}

}
