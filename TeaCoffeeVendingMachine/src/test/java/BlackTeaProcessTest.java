import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tcvm.data.ContainerData;
import com.tcvm.exception.ContainerEmptyException;
import com.tcvm.process.BlackTeaProcessImpl;

public class BlackTeaProcessTest {

	BlackTeaProcessImpl blackTeaprocess=new BlackTeaProcessImpl();
	boolean result=false;
	ContainerData container =new ContainerData();

	@Test
	public void ShouldReturnTrueIfQuantityOfTeaIsNotEmpty()
	{
		 result=blackTeaprocess.makeDrink(container,2);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfQuantityIsNull()
	{
		 result=blackTeaprocess.makeDrink(container,null); 
	}

	@Test
	public void ShouldReturnTrueIfTeaContainerCapacityIsNotEmptyForBlackTea()
	{
		 result=blackTeaprocess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfTeaContainerIsEmptyForBlackTea()
	{
		 result=blackTeaprocess.makeDrink(container,500); 
	}
	
	@Test
	public void ShouldReturnTrueIfWaterContainerIsNotEmptyForBlackTea()
	{
		 result=blackTeaprocess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfWaterContainerIsEmptyForBlackTea()
	{
		 result=blackTeaprocess.makeDrink(container,231); 
	}
	 
	@Test
	public void ShouldReturnTrueIfSugarContainerIsNotEmptyForBlackTea()
	{
		 result=blackTeaprocess.makeDrink(container,1);
		assertEquals(true, result);
	}
	
	@Test(expected = ContainerEmptyException.class)
	public void ShouldReturnContainerExceptionIfSugarContainerIsEmptyForBlackTea()
	{
		 result=blackTeaprocess.makeDrink(container,471); 
		 assertEquals(true, result);
	}
	
	
}
