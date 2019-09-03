package com.tcvm.service;

import static com.tcvm.data.Constant.COFFEE;
import static com.tcvm.data.Constant.MILK;
import static com.tcvm.data.Constant.SUGAR;
import static com.tcvm.data.Constant.TEA;
import static com.tcvm.data.Constant.WATER;

import java.util.logging.Logger;

import com.tcvm.data.Camscanner;
import com.tcvm.data.ContainerData;
import com.tcvm.data.MaterialDataSpecification;
import com.tcvm.exception.ContainerEmptyException;
import com.tcvm.process.BlackCoffeeProcessImpl;
import com.tcvm.process.BlackTeaProcessImpl;
import com.tcvm.process.CoffeeProcessImpl;
import com.tcvm.process.DrinkProcess;
import com.tcvm.process.TeaProcessImpl;

public class TeaCoffeeVendingService {

	ContainerData containerData = new ContainerData();
	Camscanner camscanner = new Camscanner();
	private Logger logger = Logger.getLogger(TeaCoffeeVendingService.class.getName());


	
	public void displayContainerSelectionMenu() {
		logger.info("***************************************************");
		logger.info("...........Tea-Coffee Vending Machine ...........");
		logger.info("Please select below Options");
		logger.info("1.Drink");
		logger.info("2.Refilling Container");
		logger.info("3.Show Container Status");
		logger.info("4.Show Wastage Details");
		logger.info("5.Show Total Sale");
		logger.info("6.Reset Container");
		logger.info("0.Close");
		logger.info("***************************************************");
	}

	public void mainContainerOptionSelectionProcess(boolean isOptions, boolean isDrinkOptions) {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n\u001B[30m");

		displayContainerSelectionMenu();
		int isRefill = 0;
		do {
			int containerOption = camscanner.nextInt();

			switch (containerOption) {
			case 1:
				makeDrinkSelectionProcess(isDrinkOptions);
				logger.info("******************************************");
				break;
			case 2:
				logger.info("******************************************");
				do {
					displayRefillMenu();
					int containerType = camscanner.nextInt();
					manageRefillContainer(containerData, containerType);
					logger.info("Do you want to Containue If yes press 1 otherwise 0");
					isRefill = camscanner.nextInt();
				} while (isRefill == 1);
				displayContainerSelectionMenu();
				break;
			case 3:
				logger.info("******************************************");
				containerData.showContainerStatus();
				logger.info("******************************************");
				displayContainerSelectionMenu();
				break;
			case 4:
				logger.info("******************************************");
				containerData.showTotalWastage();
				logger.info("******************************************");
				displayContainerSelectionMenu();
				break;
			case 5:
				logger.info("******************************************");
				containerData.showTotalSales();
				logger.info("******************************************");
				displayContainerSelectionMenu();
				break;
			case 6:
				logger.info("******************************************");
				containerData.reSetContainer();
				
				logger.info("**********Reset Container Successfully************");
				displayContainerSelectionMenu();
				break;
			case 0:
				isOptions = false;
				logger.info("...........Tea Coffee Vending Machine Exit...........");
				break;
			default:
				isOptions = false;
				logger.info("...........Tea Coffee Vending Machine Exit...........");
				break;
			}
		} while (isOptions != false);

	}

	public void displayDrinkSelectionMenu() {
		logger.info("******************************************");
		logger.info("Please select Order Drink:");
		logger.info("1.Tea");
		logger.info("2.Black Tea");
		logger.info("3.Coffee");
		logger.info("4.Black Coffee");
		logger.info("0.Close");
		logger.info("******************************************");
	}

	public void displayRefillMenu() {
		logger.info("******************************************");
		logger.info("Please Select Below Conatainer Options:");
		logger.info("1.Tea Conatainer");
		logger.info("2.Coffee Conatainer");
		logger.info("3.Sugar Conatainer");
		logger.info("4.Water Conatainer");
		logger.info("5.Milk Conatainer");
		logger.info("0.Close");
		logger.info("******************************************");
	}

	public void makeDrinkSelectionProcess(boolean isDrinkOptions) {
		DrinkProcess drink = null;
		Integer quantity = 0;
		displayDrinkSelectionMenu();

		do {
			int drinkType = camscanner.nextInt();
			switch (drinkType) {
			case 1:
				try {

					logger.info("******************************************");
					drink = new TeaProcessImpl();
					logger.info("How many tea you want?");
					quantity = camscanner.nextInt();
					drink.makeDrink(containerData, quantity);
					displayDrinkSelectionMenu();
					logger.info("*************Enjoy Your Drink***********");
				} catch (ContainerEmptyException e) {
					logger.info("Please Refilling Container");
					e.printStackTrace();
					e.getMessage();
					
				}
				break;
			case 2:
				try {

					logger.info("******************************************");
					drink = new BlackTeaProcessImpl();
					logger.info("How many black tea you want?");
					quantity = camscanner.nextInt();
					drink.makeDrink(containerData, quantity);
					displayDrinkSelectionMenu();
					logger.info("*************Enjoy Your Drink***********");
				} catch (ContainerEmptyException e) {
					e.printStackTrace();
//					logger.info("Please Refilling Container"); 
//					e.getMessage();
				}
				break;
			case 3:
				try {

					logger.info("******************************************");
					drink = new CoffeeProcessImpl();
					logger.info("How many coffee you want?");
					quantity = camscanner.nextInt();
					drink.makeDrink(containerData, quantity);
					displayDrinkSelectionMenu();
					logger.info("*************Enjoy Your Drink***********");
				} catch (ContainerEmptyException e) {
					e.printStackTrace();
					logger.info("Please Refilling Container");
					e.getMessage();
				}
				break;
			case 4:
				try {

					logger.info("******************************************");
					drink = new BlackCoffeeProcessImpl();
					logger.info("How many  black coffee you want?");
					quantity = camscanner.nextInt();
					drink.makeDrink(containerData, quantity);
					displayDrinkSelectionMenu();
					logger.info("*************Enjoy Your Drink***********");
				} catch (ContainerEmptyException e) {
					e.printStackTrace();
					logger.info("Please Refilling Container");
					e.getMessage();
				}
				break;
			case 0:
				logger.info(".................Drink Process Exit................");
				isDrinkOptions = false;
				displayContainerSelectionMenu();
				break;

			default:
				isDrinkOptions = false;
				break;
			}

		} while (isDrinkOptions);
	}

	public void manageRefillContainer(ContainerData container, Integer containerType) {

		switch (containerType) {
		case 1:
			container.setTeaContainerCapacity(2000);
			MaterialDataSpecification.saveRefillDetails(TEA);
			break;
		case 2:
			container.setCoffeeContainerCapacity(2000);
			MaterialDataSpecification.saveRefillDetails(COFFEE);
			break;
		case 3:
			container.setSugarContainerCapacity(8000);
			MaterialDataSpecification.saveRefillDetails(SUGAR);
			break;
		case 4:
			container.setWaterContainerCapacity(15000);
			MaterialDataSpecification.saveRefillDetails(WATER);
			break;
		case 5:
			container.setMilkContainerCapacity(10000);
			MaterialDataSpecification.saveRefillDetails(MILK);
			break;
		default:
			logger.info("Exit Refill Serivce");
			break;
		}
	}

}
