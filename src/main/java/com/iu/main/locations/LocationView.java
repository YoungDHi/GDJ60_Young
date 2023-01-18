package com.iu.main.locations;

import java.util.ArrayList;

public class LocationView {
	
	public void view(String msg) {
		
		System.out.println(msg);
		
	}
	
	public void view(LocationDTO locationDTO) {
		
			System.out.println("LOCATION_Id : "+locationDTO.getLocation_id());
			System.out.println("STRRET_ADDRESS : "+locationDTO.getStreet_address());
			System.out.println("POSTAL_CODE : "+locationDTO.getPostal_code());
			System.out.println("CITY : "+locationDTO.getCity());
			System.out.println("STATE_PROVINCE : "+locationDTO.getState_province());
			System.out.println("COUNTRY_ID : "+locationDTO.getCountry_id());
		
		
	}
	
	public void view(ArrayList<LocationDTO> ar) {
		
		for(LocationDTO locationDTO:ar) {
			
			this.view(locationDTO);
			
			
		}
		
	}

}
