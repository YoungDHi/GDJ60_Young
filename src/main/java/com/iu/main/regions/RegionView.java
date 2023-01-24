package com.iu.main.regions;

import java.util.ArrayList;

public class RegionView {
	
	public void view(String msg) {
		System.out.println(msg);
		
	}
	
	public void view(ArrayList<RegionDTO> ar) {
		
		for(RegionDTO regionDTO:ar) {
			this.view(regionDTO);
		}
		
	}

	public void view(RegionDTO regionDTO) {
		
		System.out.println("REGION_ID : "+regionDTO.getRegion_id());
		System.out.println("REGION_NAME : "+regionDTO.getRegion_name());
		
		
	}
	
}
