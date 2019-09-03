package com.tcvm.data;

import static com.tcvm.data.Constant.BLACK_COFFEE;
import static com.tcvm.data.Constant.BLACK_COFFEE_PRICE;
import static com.tcvm.data.Constant.BLACK_TEA;
import static com.tcvm.data.Constant.BLACK_TEA_PRICE;
import static com.tcvm.data.Constant.COFFEE;
import static com.tcvm.data.Constant.COFFEE_PRICE;
import static com.tcvm.data.Constant.MILK;
import static com.tcvm.data.Constant.SUGAR;
import static com.tcvm.data.Constant.TEA;
import static com.tcvm.data.Constant.TEA_PRICE;
import static com.tcvm.data.Constant.WATER;

import java.util.Map;
import java.util.logging.Logger;

public class ContainerData {

	Camscanner camscanner = new Camscanner();
	private Logger logger = Logger.getLogger(ContainerData.class.getName());


	private Integer teaContainerCapacity;
	private Integer coffeeContainerCapacity;
	private Integer sugarContainerCapacity;
	private Integer waterContainerCapacity;
	private Integer milkContainerCapacity;

	public ContainerData() {

		this.teaContainerCapacity = 2000;
		this.coffeeContainerCapacity = 2000;
		this.sugarContainerCapacity = 8000;
		this.waterContainerCapacity = 15000;
		this.milkContainerCapacity = 10000;
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n\u001B[30m");


	}

	public Integer getTeaContainerCapacity() {
		return teaContainerCapacity;
	}

	public void setTeaContainerCapacity(Integer teaContainerCapacity) {
		this.teaContainerCapacity = teaContainerCapacity;
	}

	public Integer getCoffeeContainerCapacity() {
		return coffeeContainerCapacity;
	}

	public void setCoffeeContainerCapacity(Integer coffeeContainerCapacity) {
		this.coffeeContainerCapacity = coffeeContainerCapacity;
	}

	public Integer getSugarContainerCapacity() {
		return sugarContainerCapacity;
	}

	public void setSugarContainerCapacity(Integer sugarContainerCapacity) {
		this.sugarContainerCapacity = sugarContainerCapacity;
	}

	public Integer getWaterContainerCapacity() {
		return waterContainerCapacity;
	}

	public void setWaterContainerCapacity(Integer waterContainerCapacity) {
		this.waterContainerCapacity = waterContainerCapacity;
	}

	public Integer getMilkContainerCapacity() {
		return milkContainerCapacity;
	}

	public void setMilkContainerCapacity(Integer milkContainerCapacity) {
		this.milkContainerCapacity = milkContainerCapacity;
	}

	public void reSetContainer() {

		
		teaContainerCapacity = 2000;
		coffeeContainerCapacity = 2000;
		sugarContainerCapacity = 8000;
		waterContainerCapacity = 15000;
		milkContainerCapacity = 10000;
		MaterialDataSpecification.drinkSalesDetails.clear();
		MaterialDataSpecification.refillContainerMap.clear();
		MaterialDataSpecification.wastageDetailsMap.clear();
		logger.info("Reset Container Successfully...");

	}

	public void showContainerStatus() {
		logger.info("-------------CONTAINER STATUS----------------");
		logger.info("Tea Container Capacity......." + teaContainerCapacity);
		logger.info("coffee Container Capacity...." + coffeeContainerCapacity);
		logger.info("sugar Container Capacity....." + sugarContainerCapacity);
		logger.info("water Container Capacity....." + waterContainerCapacity);
		logger.info("milk Container Capacity......" + milkContainerCapacity);
		logger.info("******************************************");
		logger.info("-----------Container Refill Details-----------");
		showRefillDetails();
		logger.info("....Container Status....");
	}

	public boolean showRefillDetails() {
		int totalRefill = 0;
		Map<String, Integer> refillMap = MaterialDataSpecification.refillContainerMap;
		refillMap.putIfAbsent(TEA, 0);
		refillMap.putIfAbsent(COFFEE, 0);
		refillMap.putIfAbsent(WATER, 0);
		refillMap.putIfAbsent(MILK, 0);
		//refillMap.putIfAbsent(SUGAR, 0);
		
		totalRefill = refillMap.values().stream().mapToInt(s -> s).sum();
		logger.info("******************************************");
		refillMap.forEach((k, v) -> logger.info(" " + k + " = " + v));
		logger.info("******************************************");
		logger.info("Total Refill Count =" + totalRefill);
		return true;
	}

	public void showTotalWastage() {
		Integer totalWastage = 0;
		Map<String, Integer> wastageMap = MaterialDataSpecification.wastageDetailsMap;
		wastageMap.putIfAbsent(TEA, 0);
		wastageMap.putIfAbsent(COFFEE, 0);
		wastageMap.putIfAbsent(WATER, 0);
		wastageMap.putIfAbsent(MILK, 0);
		wastageMap.putIfAbsent(SUGAR, 0);

		totalWastage = wastageMap.values().stream().mapToInt(s -> s).sum();
		logger.info("----------------Wastage Details--------------");
		logger.info("******************************************");
		wastageMap.forEach((k, v) -> logger.info(k + " = " + v));
		logger.info("******************************************");
		logger.info("Total Wastage =" + totalWastage);
		logger.info("Wastage details done...");
	}

	public void showTotalSales() {

		Integer totalSale = 0;
		Map<String, Integer> totalDrinkSalesDetails = MaterialDataSpecification.drinkSalesDetails;
		totalDrinkSalesDetails.putIfAbsent(TEA, 0);
		totalDrinkSalesDetails.putIfAbsent(BLACK_TEA, 0);
		totalDrinkSalesDetails.putIfAbsent(COFFEE, 0);
		totalDrinkSalesDetails.putIfAbsent(BLACK_COFFEE, 0);

		totalSale = totalDrinkSalesDetails.values().stream().mapToInt(s -> s).sum();
		logger.info("----------------Sales Details---------------");
		logger.info("******************************************");
		logger.info(TEA + "...........:" + totalDrinkSalesDetails.get(TEA) + ":..Cost..=:"
				+ totalDrinkSalesDetails.get(TEA) * TEA_PRICE);
		logger.info(BLACK_TEA + ".....:" + totalDrinkSalesDetails.get(BLACK_TEA) + ":..Cost..=:"
				+ totalDrinkSalesDetails.get(BLACK_TEA) * BLACK_TEA_PRICE);
		logger.info(COFFEE + "........:" + totalDrinkSalesDetails.get(COFFEE) + ":..Cost..=:"
				+ totalDrinkSalesDetails.get(COFFEE) * COFFEE_PRICE);
		logger.info(BLACK_COFFEE + "..:" + totalDrinkSalesDetails.get(BLACK_COFFEE) + ":..Cost..=:"
				+ totalDrinkSalesDetails.get(BLACK_COFFEE) * BLACK_COFFEE_PRICE);
		logger.info("******************************************");
		logger.info("Total Sales =" + totalSale);
		logger.info("Sales details done...");
	}

}