package artOfTesting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ExitSurvey {
	WebDriver driver;

	@Test
	public void main() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Keshav_My Files\\Selenium_Files\\chromedriver.exe");
		driver = new  ChromeDriver(); 
		driver.get("http://uatwww.siriusxm.com/contactus#!");
		Thread.sleep(20000);
		 JavascriptExecutor js = (JavascriptExecutor)driver;	
		 js.executeScript("_tfs.startInteraction({},{\"triggerAppId\":\"Proactive_invite\",\"type\":\"proactive\",\"ruleId\":\"my_proactive\","
		 		+ "\"queue\":\"sirius-account-default-queue-SiriusXM-General-Desktop\",\"appId\":\"desktopAuth_VA\"});");	
		
		
		try{
		Thread.sleep(5000);
		//driver.findElement(By.id("//*[@id=\"tfs_invite_Proactive_invite_context2\"]")).sendKeys(Keys.F12);
		driver.findElement(By.xpath("//*[@id=\"tfs_invite_Proactive_invite_context2\"]")).getText().equalsIgnoreCase("Chat with a live expert.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs_invite_Proactive_invite_action1\"]")).click();
		Thread.sleep(10000);
		driver.switchTo().frame("tfs_interaction_iframe");
		}catch(Exception e){
		if(driver.findElement(By.xpath("//*[@id=\"tfs_invite_DockedInvite_action0\"]")).isDisplayed()){
			driver.findElement(By.xpath("//*[@id=\"tfs_invite_DockedInvite_action0\"]")).click();
		}else if(driver.findElement(By.xpath("//*[@id=\"tfs_invite_mvp_invite_action0\"]")).isDisplayed()){
			driver.findElement(By.xpath("//*[@id=\"tfs_invite_mvp_invite_action0\"]")).click();
		}
		//Wait for chat to get connected to agent
		Thread.sleep(10000);
		driver.switchTo().frame("tfs_interaction_iframe");
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-submit\"]")).click();
		Thread.sleep(30000);}
		boolean TextArea = driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).isEnabled();
		if(TextArea){
			System.out.println("Chat Connected to agent, proceed with the UDE sanity");
		}else{
			System.out.println("Text area is not enabled, please check with the UI");
			driver.close();
		}
		
	/*	CheckReply("Hi, I'm the SiriusXM virtual agent. I can help you with many things. If I can't, I'll connect you with someone who can.");
		CheckReply("May I have your first and last name?");*/
		
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("nope");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[1]/div[2]/button")).click();
		Thread.sleep(5000);
		/*CheckReply("Okay, No worries. We can skip that part.");
		CheckReply("How can I help you?");*/
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("I would like to cancel my subscription");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		/*CheckReply("Okay, I may be able to help you with that."
				+ "May I ask why you wish to cancel your subscription?");*/
		
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("I lost my car");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[1]/div[2]/button")).click();
		/*CheckReply("To cancel your subscription, call 888-601-6302 and speak to a specialist who will gladly help you with that."
				+ "Is there anything else I can do for you?");*/
		Thread.sleep(2000);
		CheckReply();
		
		
		
		List<String> allIds = new ArrayList<String>();
		//Parent class for tfs-dialog tfs-dialog-survey
		//changing the tdElement xpath for AIVA card value
		WebElement tdElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]"));
		List<WebElement> allDivElements = tdElement.findElements(By.tagName("div"));
		for(int i = 0; i<allDivElements.size(); i++){
			try{
				String id = allDivElements.get(i).getAttribute("class");
				if(id.contains("tfs-widget-rating")){
					String id1 = allDivElements.get(i).getAttribute("id");
					if(id1.contains("tfs-widget-Q0")){
						driver.findElement(By.xpath("//*[@id=\""+id1.toString()+"\"]/div[2]/fieldset/div/span/span[5]")).click();}
				}
				else if (id.contains("tfs-widget-select")){
					String id1 = allDivElements.get(i).getAttribute("id");
					if(id1.contains("tfs-widget-Q0")){
						List<WebElement> DDL= driver.findElements(By.xpath("//*[@id=\"tfs-widget-Q03 What was your chat inquiry about\"]/div[2]/select/option"));   
						System.out.println("Total number of drop down values:::::::::" + DDL.size() );
						for (int i1=1;i1<DDL.size();i1++){
							System.out.println("the drop down values are : " +  DDL .get(i1).getText());
							driver.findElement(By.xpath("//*[@id=\""+id1.toString()+"\"]/div[2]/select/option"+"["+i1+"]")).click();
						}}}
				else if (id.contains("tfs-widget tfs-widget-listinput")){
					String id1 = allDivElements.get(i).getAttribute("id");
					if(id1.contains("tfs-widget-Q0")){
						driver.findElement(By.xpath("//*[@id="+id1.toString().trim()+"-A01 Yes]")).click();
					}
				}
				allIds.add(id );

			} catch(Exception e) {}
			driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-submit\"]")).click();}
		
		
		/*driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-show-va-chat-invite\"]")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[3]/div[2]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='tfs-widget-input-primary-endchat']")).click();
		Thread.sleep(3000);*/
		}

	public void CheckReply(){
		List<WebElement> element = driver.findElements(By.className("tfs-message-wrapper"));
		System.out.println(element.size());
			for(int i1 = 0; i1<element.size(); i1++){
			try{
			String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div/div[2]/div["+i1+"]")).getText();
			
			
			//if(text){
				System.out.println("Chat Transcript:::   "+text);
			/*}else{
				System.out.println("text is :::"+text);
			}
			*/
			}
			catch(Exception e){
				System.out.println("value of i is ");
			}}
			
			
			
			
		//}
	}
	
	
}