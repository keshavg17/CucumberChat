/*package UDEUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import udeDefinition.UDE_Definition;

public class UDEUtilityFunctions extends UDE_Definition{
	
	

	public static void IS_ELEMENT_PRESENT(String ElementName, String Xpath) throws IOException{
		UDE_Definition.driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		boolean exists = driver.findElements(By.id(Xpath) ).size() != 0;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		if(exists){
			System.out.println("Element with ID  "+ElementName+"  Exists");
		}else{
			Take_ScreenShot();
		}
	}	

	public static void Take_ScreenShot() throws IOException
	{
		Date date = new Date();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot_"+date.toString()+".png"));

	}
}
*/