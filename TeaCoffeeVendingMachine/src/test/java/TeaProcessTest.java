import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tcvm.data.ContainerData;
import com.tcvm.exception.ContainerEmptyException;
import com.tcvm.process.TeaProcessImpl;

public class TeaProcessTest {

	TeaProcessImpl teaprocess=new TeaProcessImpl();
	boolean result=false; 
	ContainerData container =new ContainerData();
	 
	@Test
	public void ShouldReturnTrueIfQuantityOfTeaIsNotEmpty()
	{
		result=teaprocess.makeDrink(container,2);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfQuantityIsNull()
	{
		 result=teaprocess.makeDrink(container,null); 
	}
	
	@Test
	public void ShouldReturnTrueIfTeaContainerCapacityIsNotEmptyForTea()
	{
		 result=teaprocess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfTeaContainerIsEmptyForTea()
	{
		 result=teaprocess.makeDrink(container,334); 
	}
	
	@Test
	public void ShouldReturnTrueIfWaterContainerIsNotEmptyForTea()
	{
		 result=teaprocess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfWaterContainerIsEmptyForTea()
	{
		 result=teaprocess.makeDrink(container,231); 
	}
	
	@Test
	public void ShouldReturnTrueIfMilkContainerIsNotEmptyForTea()
	{
		 result=teaprocess.makeDrink(container,1);
		assertEquals(true, result); 
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfMilkContainerIsEmptyForTea()
	{
		 result=teaprocess.makeDrink(container,228); 
	}
	
	@Test
	public void ShouldReturnTrueIfSugarContainerIsNotEmptyForTea()
	{
		 result=teaprocess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfSugarContainerIsEmptyForTea()
	{
		 result=teaprocess.makeDrink(container,471); 
		 assertEquals(true, result);
	}
	
	
}
