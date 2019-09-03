import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.data.Camscanner;
import com.tcvm.data.ContainerData;
import com.tcvm.exception.ContainerEmptyException;
import com.tcvm.process.DrinkProcess;
import com.tcvm.service.TeaCoffeeVendingService;

@RunWith(MockitoJUnitRunner.class)
public class TeaCoffeeVendingServiceTest {

	@InjectMocks
	TeaCoffeeVendingService teaCoffeevendingservice;

	@Mock
	Camscanner scanner;

	@Mock
	ContainerData containerData;

	@Mock
	DrinkProcess drinkService;
	
	@Mock
	Logger logger;


	boolean isOptions = false;
	boolean isDrinkOptions = false;

	@Test
	public void shouldReturnDisplayMainContainerOptions() {
		teaCoffeevendingservice.displayContainerSelectionMenu();
		verify(logger, times(1)).info("0.Close");
	}

	@Test
	public void shouldReturnDisplayMakeDrinkOptions() {
		teaCoffeevendingservice.displayDrinkSelectionMenu();
		verify(logger, times(1)).info("0.Close");

	}

	@Test
	public void shouldReturnCallDrinkProcessMenuOfMainContainerProcess() {
		when(scanner.nextInt()).thenReturn(1, 0, 2);
		teaCoffeevendingservice.mainContainerOptionSelectionProcess(false, false);
	}

	@Test
	public void shouldReturnCallContainerRefillingDataOfMainContainerProcess() {

		when(scanner.nextInt()).thenReturn(2);
		teaCoffeevendingservice.mainContainerOptionSelectionProcess(isOptions, isDrinkOptions);
	}

	@Test
	public void shouldReturnCallContainerStatusInfoOfMainContainerProcess() {
		when(scanner.nextInt()).thenReturn(3);
		doNothing().when(containerData).showContainerStatus();
		teaCoffeevendingservice.mainContainerOptionSelectionProcess(isOptions, isDrinkOptions);
		verify(containerData).showContainerStatus();
	}

	@Test
	public void shouldReturnCallTotalWastageInfoOfDrinkOfMainContainerProcess() {
		when(scanner.nextInt()).thenReturn(4);
		doNothing().when(containerData).showTotalWastage();
		teaCoffeevendingservice.mainContainerOptionSelectionProcess(isOptions, isDrinkOptions);
		verify(containerData).showTotalWastage();
	}

	@Test
	public void shouldReturnCheckTotalDrinkSaleCountOfMainContainerProcess() {
		when(scanner.nextInt()).thenReturn(5);
		doNothing().when(containerData).showTotalSales();
		teaCoffeevendingservice.mainContainerOptionSelectionProcess(isOptions, isDrinkOptions);
		verify(containerData).showTotalSales();
	}

	@Test
	public void shouldReturnExitStatusIfSwitchReturnExitOfMainContainerProcess() {

		when(scanner.nextInt()).thenReturn(0);
		teaCoffeevendingservice.mainContainerOptionSelectionProcess(isOptions, isDrinkOptions);
	}

	@Test
	public void shouldReturnResetCondionStatusOfMainContainerProcess() {

		when(scanner.nextInt()).thenReturn(6);
		teaCoffeevendingservice.mainContainerOptionSelectionProcess(isOptions, isDrinkOptions);
	}

	@Test
	public void shouldReturnDefaultCondionStatusOfMainContainerProcess() {

		when(scanner.nextInt()).thenReturn(7);
		teaCoffeevendingservice.mainContainerOptionSelectionProcess(isOptions, isDrinkOptions);
	}

	// for Drink process

	@Test
	public void shouldReturnTrueIfTeaDrinkProcessIsComplete() {

		when(scanner.nextInt()).thenReturn(1, 2);
		when(containerData.getTeaContainerCapacity()).thenReturn(2000);
		when(containerData.getMilkContainerCapacity()).thenReturn(10000);
		when(containerData.getSugarContainerCapacity()).thenReturn(8000);
		when(containerData.getWaterContainerCapacity()).thenReturn(15000);
		when(drinkService.makeDrink(containerData, 2)).thenReturn(true);
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
		drinkService.makeDrink(containerData, 500);
		verify(drinkService, times(1)).makeDrink(containerData, 500);
	}

	@Test
	public void shouldReturnTrueIfTeaDrinkProcessGetContainerException() {

		when(scanner.nextInt()).thenReturn(1, 500);
		when(drinkService.makeDrink(containerData, 500)).thenThrow(new ContainerEmptyException("Tea drink process get refill container exception"));
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
	}

	@Test
	public void shouldReturnTrueIfBlackTeaDrinkProcessIsComplete() {

		when(scanner.nextInt()).thenReturn(2, 2);
		when(containerData.getTeaContainerCapacity()).thenReturn(2000);
		when(containerData.getSugarContainerCapacity()).thenReturn(8000);
		when(containerData.getWaterContainerCapacity()).thenReturn(15000);
		when(drinkService.makeDrink(containerData, 2)).thenReturn(true);

		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
		drinkService.makeDrink(containerData, 2);

		verify(drinkService, times(1)).makeDrink(containerData, 2);
	}

	@Test
	public void shouldReturnTrueIfBlackTeaDrinkProcessGetContainerException() {

		when(scanner.nextInt()).thenReturn(2, 500);
		when(drinkService.makeDrink(containerData, 500)).thenThrow(new ContainerEmptyException(" Black tea drink process get refill container exception"));
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
		
	}

	
	@Test
	public void shouldReturnTrueIfCoffeeDrinkProcessIsComplete() {

		when(scanner.nextInt()).thenReturn(3, 2);
		when(containerData.getCoffeeContainerCapacity()).thenReturn(2000);
		when(containerData.getMilkContainerCapacity()).thenReturn(10000);
		when(containerData.getSugarContainerCapacity()).thenReturn(8000);
		when(containerData.getWaterContainerCapacity()).thenReturn(15000);
		when(drinkService.makeDrink(containerData, 2)).thenReturn(true);
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
		drinkService.makeDrink(containerData, 2);
		verify(drinkService, times(1)).makeDrink(containerData, 2);
	}
	
	@Test
	public void shouldReturnTrueIfCoffeeDrinkProcessGetContainerException() {

		when(scanner.nextInt()).thenReturn(3, 500);
		when(drinkService.makeDrink(containerData, 500)).thenThrow(new ContainerEmptyException("Coffee drink process get refill container exception"));
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
		
	}

	@Test
	public void shouldReturnTrueIfBlackCoffeeDrinkProcessIsComplete() {

		when(scanner.nextInt()).thenReturn(4, 2);
		when(containerData.getCoffeeContainerCapacity()).thenReturn(2000);
		when(containerData.getSugarContainerCapacity()).thenReturn(8000);
		when(containerData.getWaterContainerCapacity()).thenReturn(15000);
		when(drinkService.makeDrink(containerData, 2)).thenReturn(true);
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
		drinkService.makeDrink(containerData, 2);

		verify(drinkService, times(1)).makeDrink(containerData, 2);
	}
	
	@Test
	public void shouldReturnTrueIfBlackCoffeeDrinkProcessGetContainerException() {

		when(scanner.nextInt()).thenReturn(4, 500);
		when(drinkService.makeDrink(containerData, 500)).thenThrow(new ContainerEmptyException(" Black coffee drink process get refill container exception"));
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
		
	}

	@Test
	public void shouldReturnTrueIfRunExitConditionOfMakeDrinkSelectionProcess() {

		when(scanner.nextInt()).thenReturn(0);
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
	}

	@Test
	public void shouldReturnTrueIfRunDefaultContionOfMakeDrinkSelectionProcess() {

		when(scanner.nextInt()).thenReturn(5);
		teaCoffeevendingservice.makeDrinkSelectionProcess(isDrinkOptions);
	}

	@Test
	public void shouldReturnCheckDisplayRefillMenu() {
		teaCoffeevendingservice.displayRefillMenu();
		verify(logger, times(1)).info("0.Close");
	}

	@Test
	public void shouldReturnCheckRefillTeaContainerService() {
		teaCoffeevendingservice.manageRefillContainer(containerData, 1);
	}

	@Test
	public void shouldReturnCheckRefillCoffeeContainerService() {
		teaCoffeevendingservice.manageRefillContainer(containerData, 2);
	}

	@Test
	public void shouldReturnCheckRefillSugarContainerService() {
		teaCoffeevendingservice.manageRefillContainer(containerData, 3);
	}

	@Test
	public void shouldReturnCheckRefillWaterContainerService() {
		teaCoffeevendingservice.manageRefillContainer(containerData, 4);
	}

	@Test
	public void shouldReturnCheckRefillMilkContainerService() {
		teaCoffeevendingservice.manageRefillContainer(containerData, 5);
	}

	@Test
	public void shouldReturnCheckRefillDefaultConditionService() {
		teaCoffeevendingservice.manageRefillContainer(containerData, 6);
	}

}
