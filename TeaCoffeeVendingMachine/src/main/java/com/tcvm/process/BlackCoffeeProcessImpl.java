package com.tcvm.process;

import static com.tcvm.data.Constant.BLACK_COFFEE;
import static com.tcvm.data.Constant.COFFEE;
import static com.tcvm.data.Constant.SUGAR;
import static com.tcvm.data.Constant.WATER;

import java.util.Map;

import com.tcvm.data.ContainerData;
import com.tcvm.data.MaterialDataSpecification;
import com.tcvm.entity.Materials;
import com.tcvm.exception.ContainerEmptyException;

public class BlackCoffeeProcessImpl implements DrinkProcess {

	public boolean makeDrink(ContainerData container, Integer quantity) throws ContainerEmptyException {
		// TODO Auto-generated method stub

		Integer coffeeContainerCapacity = container.getCoffeeContainerCapacity();
		Integer waterContainerCapacity = container.getWaterContainerCapacity();
		Integer sugarContainerCapcity = container.getSugarContainerCapacity();

		Integer requiredCoffee, requiredWater, requiredSugar;
		Map<String, Materials> blackCoffeeMap = MaterialDataSpecification.getBlackCoffeeMaterialMap();

		if (quantity != null) {

			requiredCoffee = (blackCoffeeMap.get(COFFEE).getConsumptionMaterial()
					+ blackCoffeeMap.get(COFFEE).getWasteMaterial()) * quantity;
			requiredWater = (blackCoffeeMap.get(WATER).getConsumptionMaterial()
					+ blackCoffeeMap.get(WATER).getWasteMaterial()) * quantity;
			requiredSugar = (blackCoffeeMap.get(SUGAR).getConsumptionMaterial()
					+ blackCoffeeMap.get(SUGAR).getWasteMaterial()) * quantity;
		} else {
			throw new ContainerEmptyException("Quantity Should Not be Null");
		}
		if (coffeeContainerCapacity < requiredCoffee) {
			throw new ContainerEmptyException("Coffee Container Should Not be Null");
		} else if (sugarContainerCapcity < requiredSugar) {
			throw new ContainerEmptyException("sugar Container should not be Empty");
		} else if (waterContainerCapacity < requiredWater) {
			throw new ContainerEmptyException("water Container should not be Empty");
		} else {

			container.setCoffeeContainerCapacity((coffeeContainerCapacity - (requiredCoffee)));
			container.setWaterContainerCapacity((waterContainerCapacity - (requiredWater)));
			container.setSugarContainerCapacity((sugarContainerCapcity - (requiredSugar)));

			MaterialDataSpecification.getDrinkSpeficWastageDetails(0,
					blackCoffeeMap.get(WATER).getWasteMaterial() * quantity, 0,
					blackCoffeeMap.get(SUGAR).getWasteMaterial() * quantity,
					blackCoffeeMap.get(COFFEE).getWasteMaterial() * quantity);

			MaterialDataSpecification.checkTotalDrinkSpecificSales(BLACK_COFFEE, quantity);
			return true;
		}
	}

}
