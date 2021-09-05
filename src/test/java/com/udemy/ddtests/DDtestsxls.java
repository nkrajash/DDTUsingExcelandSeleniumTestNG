package com.udemy.ddtests;

import java.io.IOException;
import java.util.ArrayList;

public class DDtestsxls {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DDTests_ExcelUdemy ddt = new DDTests_ExcelUdemy();
		ArrayList<String> data = ddt.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(4));
	}
}

