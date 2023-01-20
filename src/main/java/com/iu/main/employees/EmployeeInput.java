package com.iu.main.employees;

import java.util.Scanner;

public class EmployeeInput {
	
	private Scanner sc;
	
	public EmployeeInput() {
		sc = new Scanner(System.in);
	}
	
	public EmployeeDTO updateDate() throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		System.out.println("수정할  사원번호  입력");
		employeeDTO.setEmployee_id(sc.nextInt());
		System.out.println("전화번호 수정내용 입력");
		employeeDTO.setPhone_number(sc.next());
		System.out.println("월급  수정내용   입력");
		employeeDTO.setSalary(sc.nextDouble());
		return employeeDTO;
		
		
	}
	
	public EmployeeDTO deleteData() throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		System.out.println("삭제할 사원번호 입력");
		employeeDTO.setEmployee_id(sc.nextInt());
		
		return employeeDTO;
		
	}

	public EmployeeDTO setData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		System.out.println("성     입력");
		employeeDTO.setFirst_name(sc.next());
		System.out.println("이름   입력");
		employeeDTO.setLast_name(sc.next());
		System.out.println("이메일  입력");
		employeeDTO.setEmail(sc.next());
		System.out.println("전화번호 입력");
		employeeDTO.setPhone_number(sc.next());
		System.out.println("날짜 입력");
		employeeDTO.setHire_date(sc.next());
		System.out.println("직급    입력");
		employeeDTO.setJob_id(sc.next());
		System.out.println("월급    입력");
		employeeDTO.setSalary(sc.nextDouble());
		System.out.println("수당율  입력");
		employeeDTO.setCommission_pct(sc.nextDouble());
		System.out.println("상사    입력");
		employeeDTO.setManager_id(sc.nextInt());
		System.out.println("부서번호 입력");
		employeeDTO.setDepartment_id(sc.nextInt());
		
		return employeeDTO;
	}
	
}
