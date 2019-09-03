package com.tcvm.process;

import static com.tcvm.data.Constant.TEA;
import static com.tcvm.data.Constant.WATER;
import static com.tcvm.data.Constant.MILK;
import static com.tcvm.data.Constant.SUGAR;
import java.util.Map;

import com.tcvm.data.ContainerData;
import com.tcvm.data.MaterialDataSpecification;
import com.tcvm.entity.Materials;
import com.tcvm.exception.ContainerEmptyException;

public class TeaProcessImpl implements DrinkProcess {

	public boolean makeDrink(ContainerData container, Integer quantity) throws ContainerEmptyException {
		// TODO Auto-generated method stub
		Integer teaContainerCapacity = container.getTeaContainerCapacity();
		Integer waterContainerCapacity = container.getWaterContainerCapacity();
		Integer milkContainerCapacity = container.getMilkContainerCapacity();
		Integer sugarContainerCapcity = container.getSugarContainerCapacity();

		Integer requiredTea, requiredWater, requiredMilk, requiredSugar;
		Map<String, Materials> teaMap = MaterialDataSpecification.getTeaMaterialMap();

		if (quantity != null) {

			requiredTea = (teaMap.get(TEA).getConsumptionMaterial() + teaMap.get(TEA).getWasteMaterial()) * quantity;
			requiredWater = (teaMap.get(WATER).getConsumptionMaterial() + teaMap.get(WATER).getWasteMaterial())
					* quantity;
			requiredMilk = (teaMap.get(MILK).getConsumptionMaterial() + teaMap.get(MILK).getWasteMaterial()) * quantity;
			requiredSugar = (teaMap.get(SUGAR).getConsumptionMaterial() + teaMap.get(SUGAR).getWasteMaterial())
					* quantity;

		} else {
			throw new ContainerEmptyException("Quantity Should Not be Null");
		}

		if (sugarContainerCapcity < requiredSugar) {
			throw new ContainerEmptyException("Sugar Container should not be Empty");
		} else if (teaContainerCapacity < requiredTea) {
			throw new ContainerEmptyException("Container Should Not be Null");
		} else if (waterContainerCapacity < requiredWater) {
			throw new ContainerEmptyException("Water Container should not be Empty");
		} else if (milkContainerCapacity < requiredMilk) {
			throw new ContainerEmptyException("Milk Container should not be Empty");
		} else {

			container.setTeaContainerCapacity((teaContainerCapacity - (requiredTea)));
			container.setWaterContainerCapacity((waterContainerCapacity - (requiredWater)));
			container.setMilkContainerCapacity((milkContainerCapacity - (requiredMilk))); 
			container.setSugarContainerCapacity((sugarContainerCapcity - (requiredSugar)));

			MaterialDataSpecification.getDrinkSpeficWastageDetails(teaMap.get(TEA).getWasteMaterial() * quantity,
					teaMap.get(WATER).getWasteMaterial() * quantity, teaMap.get(MILK).getWasteMaterial() * quantity,
					teaMap.get(SUGAR).getWasteMaterial() * quantity, 0);

			MaterialDataSpecification.checkTotalDrinkSpecificSales(TEA, quantity);
			return true;
		}
	}

}
