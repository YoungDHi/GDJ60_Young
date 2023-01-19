package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeeController;
import com.iu.main.employees.EmployeeDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.locations.LocationDTO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		LocationController lc = new LocationController();
		DepartmentController dc = new DepartmentController();
		EmployeeController ec = new EmployeeController();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		LocationDAO locationDAO = new LocationDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
//			double result[] = employeeDAO.getAvg();
			
//			System.out.println("Avg : "+result[0]);
//			System.out.println("Sum : "+result[1]);
			
			ec.start();
//			LocationDTO locationDTO = new LocationDTO();
//			locationDTO.setLocation_id(3300);
//			
//			
//			
//			int result = locationDAO.deleteData(locationDTO);
//			
//			
//			if(result>0) {
//			System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finish");

	}

}
