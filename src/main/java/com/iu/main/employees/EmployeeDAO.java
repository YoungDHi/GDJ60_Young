package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.iu.main.util.DBConnection;

public class EmployeeDAO {
	
	public HashMap<String, Double> getAvg() throws Exception {
		
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT AVG(SALARY) A, SUM(SALARY) S FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		System.out.println(rs.getDouble(1));
		System.out.println(rs.getInt(2));
		
//		1. list, Array
//		ArrayList<Double> result = new ArrayList<Double>();
//		double [] result = {rs.getDouble(1), rs.getInt(2)};
//		2. DTO (Class)
//		3. map(Key, Value)
		map.put("avg", rs.getDouble("A"));
		map.put("sum", rs.getDouble(2));
		
		
		
		
		
		DBConnection.disconnect(rs, st, connection);
		
		return map;
	}
	
	public int update(EmployeeDTO employeeDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "UPDATE EMPLOYEES SET PHONE_NUMBER = ?, SALARY = ? "
				+ "WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, employeeDTO.getPhone_number());
		st.setDouble(2, employeeDTO.getSalary());
		st.setInt(3, employeeDTO.getEmployee_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disconnert(st, connection);
		
		return result;
		
	}
	
	public int deleteData(EmployeeDTO employeeDTO) throws Exception{
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID = ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getEmployee_id());
		
		int result = st.executeUpdate();
		
		return result;
		
	}
	
	public int setData(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) "
				+ "VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setString(3, employeeDTO.getEmail());
		st.setString(4, employeeDTO.getPhone_number());
		st.setString(5, employeeDTO.getHire_date());
		st.setString(6, employeeDTO.getJob_id());
		st.setDouble(7, employeeDTO.getSalary());
		st.setDouble(8, employeeDTO.getCommission_pct());
		st.setInt(9, employeeDTO.getManager_id());
		st.setInt(10, employeeDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		return result;
	}
	
	//method 1개 : query 1개 
	
	public ArrayList<EmployeeDTO> getFind(String search) throws Exception {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
		//String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE '%'||?||'%'";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, "%"+ search + "%");
		//st.setString(1, search);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
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
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}
		DBConnection.disconnect(rs, st, connection);
		return employeeDTO;
	}
	
	//list
	public ArrayList<EmployeeDTO> getList() throws Exception{
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID "
				+ "FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		//항상 SELECT의 결과물을 가지고 코드를 짠다.
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
