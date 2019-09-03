import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tcvm.data.ContainerData;
import com.tcvm.exception.ContainerEmptyException;
import com.tcvm.process.BlackCoffeeProcessImpl;

public class BlackCoffeeProcessTest {

		BlackCoffeeProcessImpl blackCoffeeProcessImpl=new BlackCoffeeProcessImpl();
		boolean result=false;
		ContainerData container =new ContainerData();

		 
		@Test
		public void ShouldReturnTrueIfQuantityOfTeaIsNotEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,2);
			assertEquals(true, result);
		}
		
		@Test(expected = ContainerEmptyException.class)
		public void ShouldReturnContainerExceptionIfQuantityIsNullForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,null); 
		}
		
		@Test
		public void ShouldReturnIfQuantityAndAllMaterialCapacityIsAvailableForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,2);
			 assertEquals(true, result);
		}
		
		@Test
		public void ShouldReturnTrueIfCoffeeContainerCapacityIsNotEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,1);
			assertEquals(true, result);
		}
		
		@Test(expected = ContainerEmptyException.class)
		public void ShouldReturnContainerExceptionIfCoffeeContainerIsEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,1000); 
		}
		
		@Test
		public void ShouldReturnTrueIfWaterContainerIsNotEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,1);
			assertEquals(true, result);
		}
		
		@Test(expected = ContainerEmptyException.class)
		public void ShouldReturnContainerExceptionIfWaterContainerIsEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,231); 
		}
		
		@Test
		public void ShouldReturnTrueIfMilkContainerIsNotEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,1);
			assertEquals(true, result);
		}
		
		@Test(expected = ContainerEmptyException.class)
		public void ShouldReturnContainerExceptionIfMilkContainerIsEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,228); 
		}
		
		@Test
		public void ShouldReturnTrueIfSugarContainerIsNotEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,1);
			assertEquals(true, result);
		}
		
		@Test(expected = ContainerEmptyException.class)
		public void ShouldReturnContainerExceptionIfSugarContainerIsEmptyForBlackCoffee()
		{
			 result=blackCoffeeProcessImpl.makeDrink(container,471); 
			 assertEquals(true, result);
		}
		
		
	}


