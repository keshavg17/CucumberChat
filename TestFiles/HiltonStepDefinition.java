package artOfTesting.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HiltonStepDefinition {
	protected WebDriver driver;
	protected WebDriver AssistDriver;

	@Before
	public void setup1() {
		/*System.setProperty("webdriver.gecko.driver", "D:\\Cucumber\\geckodriver.exe");
		 driver =new FirefoxDriver();*/
		System.out.println("Test");
	}

	@Given("^I use chrome1 browser$")
	public void I_use_chrome_browser(){
		DesiredCapabilities capabilities = new DesiredCapabilities();

		System.setProperty("webdriver.chrome.driver", "D:\\Keshav_My Files\\Selenium_Files\\chromedriver.exe");
		driver = new  ChromeDriver(capabilities); 
		driver.manage().window().maximize();
	}

	@Given("^I open Hilton Service$")
	public void I_open_Hilton_Service() {
		//Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://hilton-stg.hilton.com/en/hi/customersupport/index.jhtml?xch=164166,13wJZkpGy8ftTYMnNp6Kgmd1v1SLcwWz7vY5H2PxPVxqn0dYRcz1!1204597712!1495539204682&");
	}

	//@When("^I enter \"([^\"]*)\" in search textbox$")
	@When ("^during office hours$")
	public void during_office_hours() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}

	//@Then("^I should get result as \"([^\"]*)\"$")
	@Then("^Chat Invite is accepted$")
	public void Chat_Invit_is_accepted() throws InterruptedException {
		//Get result from calculator
		driver.findElement(By.id("247chat_button_id")).click();
	}
	
	@When("^Agent is available to take chat$")
	public void Agent_is_available_to_take_chat() throws InterruptedException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.AssistDriver", "D:\\Keshav_My Files\\Selenium_Files\\chromedriver.exe");
		AssistDriver = new  ChromeDriver(capabilities);
		AssistDriver.manage().window().maximize();
		AssistDriver.get("https://hilton.portal.assist.staging.247-inc.net/en/console");
		AssistDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("hilton.test");
		AssistDriver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Ilabs@135");
		AssistDriver.findElement(By.xpath("//*[@id=\"breezesso\"]/div/div/div[5]/input[6]")).click();
		Thread.sleep(10000);
		Thread.sleep(5000);
		Thread.sleep(3000);
		AssistDriver.findElement(By.xpath("//*[@id=\"container_TabContainer_rightMenuView_StatusDropDown\"]/div[1]")).click();
		try{
		AssistDriver.findElement(By.xpath("//*[@id=\"container_TabContainer_rightMenuView_StatusDropDown\"]/div[2]/ul/li[1]/span")).click();}
		catch (Exception e){
			System.out.println("inside catch");
		}
	}
	
	@Then("^Agent Sends a message")
	public void Agent_sends_a_message() throws InterruptedException{
		AssistDriver.findElement(By.xpath("//*[@id=\"navigDiv_chatApp_label\"]")).click();
		Thread.sleep(5000);
		Thread.sleep(2000);
		AssistDriver.switchTo().frame(AssistDriver.findElement(By.xpath("//iframe[contains(@id, 'typingBox')]")));
		AssistDriver.findElement(By.id("dijitEditorBody")).sendKeys("Test message from Agent side");
		AssistDriver.findElement(By.id("dijitEditorBody")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	@Then("^Submit the PCF$")
	public void Submit_the_PCF() throws InterruptedException{
		driver.switchTo().frame("by247ChatFrame");
		driver.findElement(By.xpath("//*[@value='hilton-Standard-HHonors-Inquiries-Desktop']")).click();
		driver.findElement(By.xpath("//*[@id=\"chat-send-btn\"]")).click();
		Thread.sleep(10000);
	}

	@Then("^I enter \"(.*?)\" in textbox$")
	public void I_enter_in_textbox(String expectedResult) {
		//driver.switchTo().frame("sn_iframe");
		driver.findElement(By.xpath("//*[@id=\"chat-input-textarea\"]")).sendKeys(expectedResult);
		driver.findElement(By.xpath("//*[@id=\"chat-send-btn\"]")).click();
		//driver.close();
	}
	
	@Then("^End the chat from Visitor$")
	public void End_the_chat_from_Visitor(){
		//End the chat
		driver.findElement(By.xpath("//*[@id=\"chat-toolbar-endchat\"]/a")).click();	}

	@Then("^Submit the Exit Survey And \"(.*?)\" message should be displayed$")
	public void Submit_the_Exit_Survey_And_message_should_be_displayed(String expectedResult){
		//Did I resolve the issue - Yes, on first chat contact
				driver.findElement(By.xpath("//*[@id=\"chat-widget-Q01_Is_your_query_now_resolved-A01_Yes,_on_first_chat_contact-0\"]")).click();
				// How satisfied - Selected 5 star
				driver.findElement(By.xpath("//*[@id=\"chat-widget-Q02_How_satisfied_are_you_with_the_service_I_provi\"]/div[2]/fieldset/label[1]")).click();
				//how would have conatcted - Selected email
				driver.findElement(By.xpath("//*[@id=\"chat-widget-Q03_How_would_you_have_contacted_us_if_you_had_not-A01_I_would_have_emailed-0\"]")).click();
				//Suggestions
				driver.findElement(By.xpath("//*[@id=\"chat-widget-textarea-Q04_To_make_chat_better_any_suggestion_Free_Text\"]")).sendKeys("Test Chat");
				//Submit
				driver.findElement(By.xpath("//*[@id=\"chat-send-btn\"]")).click();
				//Verify Thank you message
				String a = driver.findElement(By.xpath("//*[@id=\"aria-description-email\"]/div[2]/b")).getText().toString();
				Assert.assertEquals(a, expectedResult);
	}
	
	@Then("^Close the chat window$")
	public void Close_the_chat_window(){
		driver.findElement(By.xpath("//*[@id=\"chat-toolbar-endchat\"]/a")).click();
		System.out.println("CHat window closed without any issues");
		
	}
	
	@After
	public void closeBrowser1() {
		driver.quit();
	}
}