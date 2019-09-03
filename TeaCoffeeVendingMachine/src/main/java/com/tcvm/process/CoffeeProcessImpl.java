package com.tcvm.process;

import static com.tcvm.data.Constant.MILK;
import static com.tcvm.data.Constant.SUGAR;
import static com.tcvm.data.Constant.COFFEE;
import static com.tcvm.data.Constant.WATER;

import java.util.Map;

import com.tcvm.data.ContainerData;
import com.tcvm.data.MaterialDataSpecification;
import com.tcvm.entity.Materials;
import com.tcvm.exception.ContainerEmptyException;

public class CoffeeProcessImpl implements DrinkProcess {

	public boolean makeDrink(ContainerData container, Integer quantity) throws ContainerEmptyException {
		// TODO Auto-generated method stub

		Integer coffeeContainerCapacity = container.getCoffeeContainerCapacity();
		Integer waterContainerCapacity = container.getWaterContainerCapacity();
		Integer milkContainerCapacity = container.getMilkContainerCapacity();
		Integer sugarContainerCapcity = container.getSugarContainerCapacity();

		Integer requiredCoffee, requiredWater, requiredMilk, requiredSugar;
		Map<String, Materials> coffeeMap = MaterialDataSpecification.getCoffeeMaterialMap();

		if (quantity != null) {

			requiredCoffee = (coffeeMap.get(COFFEE).getConsumptionMaterial() + coffeeMap.get(COFFEE).getWasteMaterial())
					* quantity;
			requiredWater = (coffeeMap.get(WATER).getConsumptionMaterial() + coffeeMap.get(WATER).getWasteMaterial())
					* quantity;
			requiredMilk = (coffeeMap.get(MILK).getConsumptionMaterial() + coffeeMap.get(MILK).getWasteMaterial())
					* quantity;
			requiredSugar = (coffeeMap.get(SUGAR).getConsumptionMaterial() + coffeeMap.get(SUGAR).getWasteMaterial())
					* quantity;

		} else {
			throw new ContainerEmptyException("Quantity Should Not be Null");
		}

		 if (waterContainerCapacity < requiredWater) {
			throw new ContainerEmptyException("Water Container should not be Empty");
		}else if (sugarContainerCapcity < requiredSugar) {
			throw new ContainerEmptyException("Sugar Container should not be Empty");
		}  else if(coffeeContainerCapacity < requiredCoffee) {
			throw new ContainerEmptyException("Coffee Container Should Not be Null");
		} else if (milkContainerCapacity < requiredMilk) {
			throw new ContainerEmptyException("Milk Container should not be Empty");
		} else {

			container.setCoffeeContainerCapacity((coffeeContainerCapacity - (requiredCoffee)));
			container.setWaterContainerCapacity((waterContainerCapacity - (requiredWater)));
			container.setMilkContainerCapacity((milkContainerCapacity - (requiredMilk)));
			container.setSugarContainerCapacity((sugarContainerCapcity - (requiredSugar)));

			MaterialDataSpecification.getDrinkSpeficWastageDetails(0,
					coffeeMap.get(WATER).getWasteMaterial() * quantity,
					coffeeMap.get(MILK).getWasteMaterial() * quantity,
					coffeeMap.get(SUGAR).getWasteMaterial() * quantity,
					coffeeMap.get(COFFEE).getWasteMaterial() * quantity);

			MaterialDataSpecification.checkTotalDrinkSpecificSales(COFFEE, quantity);
			return true;
		}
	}

}
