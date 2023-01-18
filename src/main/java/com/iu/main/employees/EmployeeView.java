package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	
	public void view(String msg) {
		
		System.out.println(msg);
		
	}
	
	public void view(EmployeeDTO employeeDTO) {
		
		System.out.println("EMPLOYEE_ID : "+employeeDTO.getEmployee_id());
		System.out.println("FIRST_NAME : "+employeeDTO.getFirst_name());
		System.out.println("LAST_NAME : "+employeeDTO.getLast_name());
		System.out.println("EMAIL : "+employeeDTO.getEmail());
		System.out.println("PHONE_NUMBER : "+employeeDTO.getPhone_number());
		System.out.println("HIRE_DATE : "+employeeDTO.getHire_date());
		System.out.println("JOB_ID : "+employeeDTO.getJob_id());
		System.out.println("SALARY : "+employeeDTO.getSalary());
		System.out.println("COMMISSION_PCT : "+employeeDTO.getCommission_pct());
		System.out.println("MANAGER_ID : "+employeeDTO.getManager_id());
		System.out.println("DEMARTMENT_ID : "+employeeDTO.getDepartment_id());
		System.out.println("===========================");
		
		
	}

	public void view(ArrayList<EmployeeDTO> ar) {
		
		for(EmployeeDTO employeeDTO:ar) {
			System.out.println("EMPLOYEE_ID : "+employeeDTO.getEmployee_id());
			System.out.println("LAST_NAME : "+employeeDTO.getLast_name());
			System.out.println("FIRST_NAME : "+employeeDTO.getFirst_name());
			System.out.println("JOB_ID : "+employeeDTO.getJob_id());
			System.out.println("DEMARTMENT_ID : "+employeeDTO.getDepartment_id());
			System.out.println("===========================");
			
		}
		
	}
	
	
}
