package com.tcvm.data;

import java.util.Scanner;

public class Camscanner {

	public static Scanner scanner=null;
	
	public String nextLine()
	{
		scanner=new Scanner(System.in);
		return scanner.nextLine(); 
	}
	
	public Integer nextInt()
	{
		scanner=new Scanner(System.in);
		return scanner.nextInt();
	}
}
