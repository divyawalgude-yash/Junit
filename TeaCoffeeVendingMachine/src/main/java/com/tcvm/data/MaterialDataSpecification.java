package com.tcvm.data;

import com.tcvm.entity.Materials;

import java.util.HashMap;
import java.util.Map;

import static com.tcvm.data.Constant.TEA;
import static com.tcvm.data.Constant.WATER;
import static com.tcvm.data.Constant.COFFEE;
import static com.tcvm.data.Constant.MILK;
import static com.tcvm.data.Constant.SUGAR;

public class MaterialDataSpecification {

	public static Map<String, Integer> wastageDetailsMap = new HashMap<String, Integer>();
	public static Map<String, Integer> drinkSalesDetails = new HashMap<String, Integer>();
	public static Map<String, Integer> refillContainerMap = new HashMap<String, Integer>();

	
	public static Map<String, Materials> getTeaMaterialMap() {
		Map<String, Materials> teaMap = new HashMap<String, Materials>();
		teaMap.put(TEA, new Materials(5, 1)); 
		teaMap.put(WATER, new Materials(60, 5));
		teaMap.put(MILK, new Materials(40, 4));
		teaMap.put(SUGAR, new Materials(15, 2));
		return teaMap;
	}

	public static Map<String, Materials> getBlackTeaMaterialMap() {
		Map<String, Materials> blackTeaMap = new HashMap<String, Materials>();
		blackTeaMap.put(TEA, new Materials(3, 0));
		blackTeaMap.put(WATER, new Materials(100, 12));
		blackTeaMap.put(SUGAR, new Materials(15, 2));
		return blackTeaMap;
	}

	public static Map<String, Materials> getCoffeeMaterialMap() {
		Map<String, Materials> coffeeMap = new HashMap<String, Materials>();
		coffeeMap.put(COFFEE, new Materials(4, 1));
		coffeeMap.put(WATER, new Materials(20, 3));
		coffeeMap.put(MILK, new Materials(80, 8));
		coffeeMap.put(SUGAR, new Materials(15, 2));
		return coffeeMap;
	}

	public static Map<String, Materials> getBlackCoffeeMaterialMap() {
		Map<String, Materials> blackCoffeeMap = new HashMap<String, Materials>();
		blackCoffeeMap.put(COFFEE, new Materials(3, 0));
		blackCoffeeMap.put(WATER, new Materials(100, 12));
		blackCoffeeMap.put(SUGAR, new Materials(15, 2));
		return blackCoffeeMap;
	}

	public static Map<String, Integer> getDrinkSpeficWastageDetails(int tea, int water, int milk, int sugar,
			int coffee) {

		if (MaterialDataSpecification.wastageDetailsMap.containsKey(TEA)) {
			wastageDetailsMap.put(TEA, wastageDetailsMap.get(TEA) + tea);
		} else {
			wastageDetailsMap.put(TEA, tea);
		}
		if (wastageDetailsMap.containsKey(WATER)) {
			wastageDetailsMap.put(WATER, wastageDetailsMap.get(WATER) + water);
		} else {
			wastageDetailsMap.put(WATER, water);
		}
		if (wastageDetailsMap.containsKey(MILK)) {
			wastageDetailsMap.put(MILK, wastageDetailsMap.get(MILK) + milk);
		} else {
			wastageDetailsMap.put(MILK, milk);
		}
		if (wastageDetailsMap.containsKey(SUGAR)) {
			wastageDetailsMap.put(SUGAR, wastageDetailsMap.get(SUGAR) + sugar);
		} else {
			wastageDetailsMap.put(SUGAR, sugar);
		}
		if (wastageDetailsMap.containsKey(COFFEE)) {
			wastageDetailsMap.put(COFFEE, wastageDetailsMap.get(COFFEE) + coffee);
		} else {
			wastageDetailsMap.put(COFFEE, coffee);
		}

		return wastageDetailsMap;
	}

	public static Map<String, Integer> checkTotalDrinkSpecificSales(String drinkType, Integer Sale) {
		if (drinkSalesDetails.containsKey(drinkType))
			drinkSalesDetails.put(drinkType, drinkSalesDetails.get(drinkType) + Sale);
		else
			drinkSalesDetails.put(drinkType, Sale);

		return drinkSalesDetails;
	}
	
	public static Map<String, Integer> saveRefillDetails (String containerType) {
		if (refillContainerMap.containsKey(containerType))
		    refillContainerMap.put(containerType, refillContainerMap.get(containerType) + 1);
		else
			refillContainerMap.put(containerType, 1);
		
		return refillContainerMap;
	}

	

}
