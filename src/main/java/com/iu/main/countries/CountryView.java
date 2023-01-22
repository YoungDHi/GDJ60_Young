package com.iu.main.countries;

import java.util.ArrayList;

public class CountryView {
	
	public void view(String msg) {
		
		System.out.println(msg);
		
		
	}
	
	public void view(CountryDTO countryDTO) {
		
		System.out.println("COUNTRY_ID : "+countryDTO.getCountry_id());
		System.out.println("COUNTRY_NAME : "+countryDTO.getCountry_name());
		System.out.println("REGION_ID : "+countryDTO.getRegion_id());
		
		
	}
	
	public void view(ArrayList<CountryDTO> ar) {
	
		for(CountryDTO countryDTO:ar) {
			this.view(countryDTO);
		}
		
	}

}
