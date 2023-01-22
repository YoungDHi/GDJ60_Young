package com.iu.main;

import com.iu.main.countries.CountryCountroller;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		
		FrontController fc = new FrontController();
		
		
		try {
			fc.start();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finish");

	}

}
