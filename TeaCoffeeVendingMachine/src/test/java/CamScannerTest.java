import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.tcvm.data.Camscanner;

public class CamScannerTest {

	Camscanner camscanner=new Camscanner();
	
	@Test
	public void ShouldReturnStringIfScannerGetStringMethod()
	{
		String input = "string";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    String result=camscanner.nextLine();
	    assertEquals("string", result);	    
	}
	
	@Test
	public void ShouldReturnIntegerIfScannerGetIntegerMethod()
	{
		Integer input = 1;
	    InputStream in = new ByteArrayInputStream((input+"").getBytes());
	    System.setIn(in);
	    Integer result=camscanner.nextInt();
	    assertEquals(input, result);	    
	}
	
	 
}
