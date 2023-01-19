package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.employees.EmployeeDTO;
import com.iu.main.util.DBConnection;

public class LocationDAO {
	
	public int updateDate(LocationDTO locationDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS =?, POSTAL_CODE=? "
				+ "WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setInt(3, locationDTO.getLocation_id());
		
		DBConnection.disconnert(st, connection);
		
		int result = st.executeUpdate();
		
		return result;
		
		
	}
	
	public int deleteData(LocationDTO locationDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "DELETE LOCATIONS WHERE LOCATION_ID = ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, locationDTO.getLocation_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disconnert(st, connection);
		
		return result;
		
	}
	
	public int setData(LocationDTO locationDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) "
				+ "VALUES (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());
		
		int result = st.executeUpdate();
		DBConnection.disconnert(st, connection);
		
		return result;
		
		
	}
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, "%" + search + "%");
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
			
			
		}
		DBConnection.disconnect(rs, st, connection);
		
		return ar;
		
		
	}
	
	public LocationDTO getDetail(int location_id) throws Exception{
		
		LocationDTO locationDTO = null;
		
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, location_id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			System.out.println(rs.getInt("LOCATION_ID"));
			System.out.println(rs.getString("STREET_ADDRESS"));
			System.out.println(rs.getString("POSTAL_CODE"));
			System.out.println(rs.getString("CITY"));
			System.out.println(rs.getString("STATE_PROVINCE"));
			System.out.println(rs.getString("COUNTRY_ID"));
		}
		
		DBConnection.disconnect(rs, st, connection);
		
		return locationDTO;
	}
	
	public ArrayList<LocationDTO> getList() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		
		Connection connection = DBConnection.getConnection();
		
		
		
		//3. query문 생성
		
		String sql = "SELECT * FROM LOCATIONS";
		
		
		//4. query문 미리 전송
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		
		//5. ? 세팅
		
		//6. 최종 전송 및 결과 처리
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
			
		}
		
		//7. 연결해제
		DBConnection.disconnect(rs, st, connection);
		
		return ar;
		
	}

}
