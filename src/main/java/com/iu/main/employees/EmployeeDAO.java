package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class EmployeeDAO {
	
	public ArrayList<EmployeeDTO> getFind(String search) throws Exception{
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, "%"+ search + "%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);
		}
		
		DBConnection.disconnect(rs, st, connection);
		
		return ar;
	}
	
	public EmployeeDTO getDetail(int department_id) throws Exception{
		EmployeeDTO employeeDTO = null;
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, department_id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}
		DBConnection.disconnect(rs, st, connection);
		return employeeDTO;
	}
	
	
	public ArrayList<EmployeeDTO> getList() throws Exception{
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT EMPLOYEE_ID, LAST_NAME, FIRST_NAME, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);
			
		}
		
		DBConnection.disconnect(rs, st, connection);
		
		
		return ar;
	}

}
