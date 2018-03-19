package artOfTesting;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TracingAIVAMessageForValidation {
	WebDriver driver;

	@Test
	public void main() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "D:\\Keshav_My Files\\Selenium_Files\\chromedriver.exe");
		driver = new  ChromeDriver(); 
		driver.get("http://anvil.tellme.com/~rvenkatar/siriusxm/ude/#start");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"start-va\"]")).click();
		Thread.sleep(10000);
		driver.switchTo().frame("tfs_interaction_iframe");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("Keshav Kumar");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/button")).click();
		//now validate the aiva messages code
		Thread.sleep(3000);
		ReadInputs("Thanks, may I also have your phone number, including your area code?");
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("9964202472");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/button")).click();
		ReadInputs("Thanks, again.");
		ReadInputs("How can I help you?");
		/*}catch(Exception e){}
		}*/
	}

	public void ReadInputs(String Text1) throws InterruptedException{
		Thread.sleep(5000);
		List<WebElement> element = driver.findElements(By.className("tfs-message-content"));
		int ElementSize = element.size();
		System.out.println("New Size of element is "+ElementSize);
		for(int i1 = 0; i1<=ElementSize; i1++){
			//String id = element.get(i1).getAttribute("class");
			//System.out.println("class Names are: "+id);
			try{
			String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div["+i1+"]")).getText();
			//System.out.println(text);
			if(text.contains(Text1)){
					System.out.println("Matched with the string "+Text1);
					System.out.println("String found at the position of "+i1);
			}
		}catch(Exception e){}
	}
}
}