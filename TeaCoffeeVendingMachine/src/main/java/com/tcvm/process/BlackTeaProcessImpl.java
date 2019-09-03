package com.tcvm.process;

import static com.tcvm.data.Constant.BLACK_TEA;
import static com.tcvm.data.Constant.SUGAR;
import static com.tcvm.data.Constant.TEA;
import static com.tcvm.data.Constant.WATER;

import java.util.Map;

import com.tcvm.data.ContainerData;
import com.tcvm.data.MaterialDataSpecification;
import com.tcvm.entity.Materials;
import com.tcvm.exception.ContainerEmptyException;

public class BlackTeaProcessImpl implements DrinkProcess {

	public boolean makeDrink(ContainerData container, Integer quantity) throws ContainerEmptyException {
		// TODO Auto-generated method stub
		Integer teaContainerCapacity = container.getTeaContainerCapacity();
		Integer waterContainerCapacity = container.getWaterContainerCapacity();
		Integer sugarContainerCapcity = container.getSugarContainerCapacity();

		Integer requiredTea, requiredWater, requiredSugar;
		Map<String, Materials> blackTeaMap = MaterialDataSpecification.getBlackTeaMaterialMap();

		if (quantity != null) {

			requiredTea = (blackTeaMap.get(TEA).getConsumptionMaterial() + blackTeaMap.get(TEA).getWasteMaterial())
					* quantity;
			requiredWater = (blackTeaMap.get(WATER).getConsumptionMaterial()
					+ blackTeaMap.get(WATER).getWasteMaterial()) * quantity;
			requiredSugar = (blackTeaMap.get(SUGAR).getConsumptionMaterial()
					+ blackTeaMap.get(SUGAR).getWasteMaterial()) * quantity;

		} else {
			throw new ContainerEmptyException("Quantity Should Not be Null");
		}

		 if (teaContainerCapacity < requiredTea) {
			throw new ContainerEmptyException("Tea Container Should Not be Empty");
		}else if (sugarContainerCapcity < requiredSugar) {
			throw new ContainerEmptyException("Sugar Container should not be Empty");
		} else if (waterContainerCapacity < requiredWater) {
			throw new ContainerEmptyException("WAater Container should not be Empty");
		}  else {

			container.setTeaContainerCapacity((teaContainerCapacity - (requiredTea)));
			container.setWaterContainerCapacity((waterContainerCapacity - (requiredWater)));
			container.setSugarContainerCapacity((sugarContainerCapcity - (requiredSugar)));

			MaterialDataSpecification.getDrinkSpeficWastageDetails(blackTeaMap.get(TEA).getWasteMaterial() * quantity,
					blackTeaMap.get(WATER).getWasteMaterial() * quantity, 0,
					blackTeaMap.get(SUGAR).getWasteMaterial() * quantity, 0);

			MaterialDataSpecification.checkTotalDrinkSpecificSales(BLACK_TEA, quantity);
			return true;
		}
	}

}
