package com.tvcm.main;

import com.tcvm.service.TeaCoffeeVendingService;

public class MainTeaCoffeeVendingProcess {

	public static void main(String[] args) {

		TeaCoffeeVendingService teaCoffeeVendingService = new TeaCoffeeVendingService();
		teaCoffeeVendingService.mainContainerOptionSelectionProcess(true,true);
	} 
   
}
  