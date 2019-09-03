
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.data.ContainerData;

@RunWith(MockitoJUnitRunner.class)
public class ContainerDataTest {

	@InjectMocks
	ContainerData container;

	@Mock
	Logger logger;

	@Test
	public void shuoldReturnTrueIfContainerDataNeedNotBeRefill() {
		container.reSetContainer();
		verify(logger, times(1)).info("Reset Container Successfully...");
	}

	@Test
	public void shouldReturnContainerStatus() {
		container.showContainerStatus();
		verify(logger).info("....Container Status....");

	}

	@Test
	public void shouldReturnWastageDetails() {
		container.showTotalWastage();
		verify(logger).info("Wastage details done...");
	}

	@Test
	public void shouldReturnTotalSalesDetails() {
		container.showTotalSales();
		verify(logger).info("Sales details done...");

	} 
	
	@Test
	public void shouldReturnCheckRefillContainerProcessStatus() {
		Boolean result=container.showRefillDetails();
		assertEquals(true, result);

	} 

}
