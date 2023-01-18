package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.employees.EmployeeController;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		LocationController lc = new LocationController();
		DepartmentController dc = new DepartmentController();
		EmployeeController ec = new EmployeeController();
		
		try {

			ec.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finish");

	}

}
