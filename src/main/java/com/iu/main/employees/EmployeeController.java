package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	public EmployeeController() {
		sc = new Scanner(System.in);
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
	}
	
	
	public void start() throws Exception{
		boolean check=true;
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		while(check) {	
			System.out.println("1. 사원정보리스트");
			System.out.println("2. 개별사원정보");
			System.out.println("3. 사원 검색");
			System.out.println("4. 종료");
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
				employeeView.view(ar);
				
				
				break;
			default:
				check = false;
			}
				
			
				
				
				
				
					
		}
			
		
		
		
			
			
			
		
		
		
	}

}
