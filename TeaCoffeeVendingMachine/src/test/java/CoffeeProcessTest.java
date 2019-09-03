import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tcvm.data.ContainerData;
import com.tcvm.exception.ContainerEmptyException;
import com.tcvm.process.CoffeeProcessImpl;

public class CoffeeProcessTest {

	
	CoffeeProcessImpl coffeeProcess=new CoffeeProcessImpl(); 
	boolean result=false; 
	ContainerData container =new ContainerData();
	 
	@Test
	public void ShouldReturnTrueIfQuantityOfTeaIsNotEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,2); 
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfQuantityIsNullForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,null); 
	}
	
	@Test
	public void ShouldReturnIfQuantityAndAllMaterialCapacityIsAvailableForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,2);
		 assertEquals(true, result);
	}
	
	@Test
	public void ShouldReturnTrueIfCoffeeContainerCapacityIsNotEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfCoffeeContainerIsEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,470); 
	}
	
	@Test
	public void ShouldReturnTrueIfWaterContainerIsNotEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfWaterContainerIsEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,700); 
	}
	
	@Test
	public void ShouldReturnTrueIfMilkContainerIsNotEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfMilkContainerIsEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,228); 
	}
	
	@Test
	public void ShouldReturnTrueIfSugarContainerIsNotEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfSugarContainerIsEmptyForCoffee()
	{
		 result=coffeeProcess.makeDrink(container,500); 
		 assertEquals(true, result);
	}
	
	
}
