package artOfTesting.test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import artOfTesting.ReplaceText;
import artOfTesting.SiriusXMAIVA;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.lightbody.bmp.proxy.CaptureType;

public class SXMAIVA_Definition extends SiriusXMAIVA{
	protected static WebDriver driver;
	protected static WebDriver AssistDriver;

	@Given("^I use Chrome browser for Assist$")
	public void i_use_Chrome_browser_for_Assist() throws Throwable {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		AssistDriver = new  ChromeDriver(capabilities); 
		proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
		proxy.newHar("yahoo.com");
		AssistDriver.manage().window().maximize();

	}

	/*	@Given("^I launch \"(.*?)\" $")
	public void i_launch(String arg1) throws Throwable {
		if(arg1.contains("assist.staging.247-inc.net")){

	}*/


	@Given("^I launch \"(.*?)\"$")
	public void i_launch(String arg1) throws Throwable {
		/*if(arg1.contains("assist.staging.247-inc.net")){*/
		AssistDriver.get(arg1);
	}

	@Given("^I launch URL \"(.*?)\"$")
	public void i_launch_URL(String arg1) throws Throwable {

		driver.get(arg1);
	}


	@Given("^Invite type is Proactive$")
	public void invite_type_is_Proactive() throws Throwable {

	}

	@Then("^Login with credentials UserName \"(.*?)\" and Password \"(.*?)\"$")
	public void Login_with_credentials_UserName_and_Password(String arg1, String arg2) throws Throwable {
		AssistDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(arg1);
		AssistDriver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(arg2);
		Thread.sleep(2000);
		List<WebElement> DDL= AssistDriver.findElements(By.xpath("//*[@id=\"breezesso\"]/div/div/div[3]/div[2]/select/option"));   
		System.out.println("Total number of drop down values:::::::::" + DDL.size() );
		for (int i=1;i<DDL.size();i++){
			System.out.println("the drop down values are : " +  DDL .get(i).getText());
			String a = DDL.get(i).getText();
			if(a.equalsIgnoreCase("Available")){
				int a1= i+1;
				AssistDriver.findElement(By.xpath("//*[@id=\"breezesso\"]/div/div/div[3]/div[2]/select/option["+a1+"]")).click(); }
		}
		Thread.sleep(2000);		
		AssistDriver.findElement(By.xpath("//*[@id=\"breezesso\"]/div/div/div[5]/input[8]")).click();
		Thread.sleep(30000);
	}

	@Given("^I Set the stage cookie \"(.*?)\"$")
	public void i_Set_the_stage_cookie(String arg1) throws Throwable {
		driver.get(arg1);
	}

	/*@Given("^I Open UDE chat trigger page \"(.*?)\"$")
	public void i_Open_UDE_chat_trigger_page(String arg1) throws Throwable {


	}*/

	@Given("^Proactive Chat is accepted and connected to agent$")
	public void Proactive_chat_is_accepted_and_connected_to_agent() throws Throwable {
		//Click on ProActive or docked invite and accept the chat
		try{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"tfs_invite_Proactive_invite_context2\"]")).getText().equalsIgnoreCase("Chat with a live expert.");
			driver.findElement(By.xpath("//*[@id=\"tfs_invite_Proactive_invite_action1\"]")).click();
			//*[@id="tfs_invite_Proactive_invite_action1"]
			Thread.sleep(10000);
			driver.switchTo().frame("tfs_interaction_iframe");
		}catch (Exception e){
			Thread.sleep(10000);
			if(driver.findElement(By.xpath("//*[@id=\"tfs_invite_DockedInvite_action0\"]")).isDisplayed()){
				driver.findElement(By.xpath("//*[@id=\"tfs_invite_DockedInvite_action0\"]")).click();
			}else if(driver.findElement(By.xpath("//*[@id=\"tfs_invite_mvp_invite_action0\"]")).isDisplayed()){
				driver.findElement(By.xpath("//*[@id=\"tfs_invite_mvp_invite_action0\"]")).click();
			}
			//Wait for chat to get connected to agent
			Thread.sleep(20000);
			driver.switchTo().frame("tfs_interaction_iframe");
			boolean TextArea = driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).isEnabled();
			if(TextArea){
				System.out.println("Chat Connected to agent, proceed with the UDE sanity");
			}else{
				System.out.println("Text area is not enabled, please check with the UI");
				Take_ScreenShot("chat_is_accepted_and_connected_to_agent");
				driver.close();
			}}

	}


	@Then("^Click on Chat Escalate button$")
	public void Click_on_Chat_Escalate_button() throws InterruptedException, IOException{
		Take_ScreenShot("Click_on_Chat_Escalate_button");
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-show-va-chat-invite\"]")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[3]/div[2]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='tfs-widget-input-primary-endchat']")).click();
	}



	@Given("^Button Chat is accepted and connected to agent$")
	public void Button_chat_is_accepted_and_connected_to_agent() throws Throwable {
		//Click on ProActive or docked invite and accept the chat
		Take_ScreenShot("Button Chat is accepted and connected to agent");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"start-va\"]")).isDisplayed();
		driver.findElement(By.xpath("//*[@id=\"start-va\"]")).click();

		//Wait for chat to get connected to agent
		Thread.sleep(20000);
		driver.switchTo().frame("tfs_interaction_iframe");
		boolean TextArea = driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).isEnabled();
		if(TextArea){
			System.out.println("Chat Connected to agent, proceed with the UDE sanity");
		}else{
			System.out.println("Text area is not enabled, please check with the UI");
			Take_ScreenShot("chat_is_accepted_and_connected_to_agent");
			driver.close();
		}

	}


	@Then("^Validate the UI$")
	public void validate_the_UI() throws Throwable {
		IS_ELEMENT_PRESENT("Minimize Button", "//*[@id=\"root\"]/div/div[1]/div[2]/div[3]/div[1]");
		IS_ELEMENT_PRESENT("Close Button", "//*[@id=\"root\"]/div/div[1]/div[2]/div[3]/div[2]");
		IS_ELEMENT_PRESENT("Transcript Button", "//*[@id=\"root\"]/div/div[1]/div[2]/div[1]/div/div");
		IS_ELEMENT_PRESENT("Send Button", "//*[@id=\"root\"]/div/div[1]/div[3]/div[1]/div[2]/button");
	}

	@Then("^Validate the AIVA Welcome Message \"(.*?)\"$")
	public void validate_the_AIVA_Welcome_Message(String arg1) throws Throwable {
		//*[@id="tfs-message-6js79gh7ll"]/div/div
		String AIVAText = driver.findElement(By.xpath("//*[@class=\"tfs-message tfs-message-va tfs-message-success tfs-ui-left\"]")).getText();
		if(AIVAText.equals(arg1)){
			System.out.println("AIVA WELCOME MESSAGE IS AS PER EXPECTED");
		}else{
			System.out.println("MISMATCH FOUND IN AIVA WELCOME MESSAGE");
			Take_ScreenShot("validate_the_AIVA_Welcome_Message");
		}
	}
	@Given("^I use Chrome browser for Chat$")
	public void i_use_Chrome_browser_for_Chat() throws Throwable {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		System.setProperty("webdriver.chrome.driver", "D:\\\\WorkRelated\\\\Selenium\\\\chromedriver.exe");
		driver = new  ChromeDriver(capabilities); 
		proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
		proxy.newHar("yahoo.com");
		driver.manage().window().maximize();
	}

	@Then("^Select the latest order$")
	public void Select_the_latest_order(){
		int totalLinkSize2 = driver.findElements(By.xpath("//*[@id=\"tfs-widget-eventname-show_order_status\"]")).size();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[13]/fieldset/label["+totalLinkSize2+"]/div")).click();

	}
	@Then("^Validate the Chat Welcome Message \"(.*?)\"$")
	public void validate_the_Chat_Welcome_Message(String arg1) throws Throwable {
		//SHOULD SEE IF THE XPATH IS SAME FOR CHAT WELCOME MESSAGE
		Thread.sleep(5000);
		String AIVAText = driver.findElement(By.xpath("//*[@class=\"tfs-message-content\"]/div/text()")).getText();
		if(AIVAText.equals(arg1)){
			System.out.println("CHAT WELCOME MESSAGE IS AS PER EXPECTED");
		}else{
			Take_ScreenShot("validate_the_Chat_Welcome_Message");
		}
	}

	/*@Given("^User is able to type in text field$")
	public void user_is_able_to_type_in_text_field() throws Throwable {


	}*/

	@Then("^User message is sent successfully \"(.*?)\"$")
	public void user_message_is_sent_successfully(String arg1) throws Throwable {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("tfs_interaction_iframe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys(arg1);
		//Thread.sleep(2000);
		try{
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[1]/div[2]/button")).click();
			//Thread.sleep(3000);
		}
		catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/button")).click();
			//Thread.sleep(3000);
		}

		//Thread.sleep(2000);
	}
	//*[@id="root"]/div/div[2]/div[3]/div[1]/div[2]/button

	@Then("^Validate the AIVA responses \"(.*?)\"$")
	public void Validate_the_AIVA_responses(String ScenarioName) throws IOException, InterruptedException{
		try{
			Thread.sleep(5000);
			List<WebElement> element = driver.findElements(By.className("tfs-message-content"));
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String Date1 = sdf.format(timestamp);
			String FileName1 = "C:\\AIVA_Responses\\"+ScenarioName+"_"+Date1+".txt";
			String FileName2 = "C:\\AIVA_Responses\\Formated\\"+ScenarioName+"_"+Date1+".txt";
			PrintWriter writer = new PrintWriter(FileName1, "UTF-8");
			System.out.println("Element size is"+element.size());
			//System.out.println(element.size());
			int ElementSize = element.size();
			System.out.println("New Size of element is "+ElementSize);
			for(int i1 = 0; i1<ElementSize; i1++){
				String id = element.get(i1).getAttribute("class");
				System.out.println("class Names are: "+id);
				try{
					int i2=i1+1;
					String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div["+i2+"]")).getText();
					System.out.println("Chat Transcript:::   "+text);
					writer.println(text);
				}
				catch(Exception e){	}
			}
			/*String text1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[8]")).getText();
		writer.println(text1);*/
			writer.close();
			Thread.sleep(3000);
			ReplaceText.main(FileName1, FileName2);

		}catch(StaleElementReferenceException elementHasDisappeared){
			Thread.sleep(5000);
			List<WebElement> element = driver.findElements(By.className("tfs-message-content"));
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String Date1 = sdf.format(timestamp);
			String FileName1 = "C:\\AIVA_Responses\\"+ScenarioName+"_"+Date1+".txt";
			String FileName2 = "C:\\AIVA_Responses\\Formated\\"+ScenarioName+"_"+Date1+".txt";
			PrintWriter writer = new PrintWriter(FileName1, "UTF-8");
			System.out.println("Element size is"+element.size());
			//System.out.println(element.size());
			int ElementSize = element.size();
			System.out.println("New Size of element is "+ElementSize);
			for(int i1 = 0; i1<ElementSize; i1++){
				String id = element.get(i1).getAttribute("class");
				System.out.println("class Names are: "+id);
				try{
					int i2=i1+1;
					String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div["+i2+"]")).getText();
					System.out.println("Chat Transcript:::   "+text);
					writer.println(text);
				}
				catch(Exception e){	}
			}
			/*String text1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[8]")).getText();
		writer.println(text1);*/
			writer.close();
			Thread.sleep(3000);
			ReplaceText.main(FileName1, FileName2);
		}
	}

	@Then("^Validate AIVA Responses \"(.*?)\"$")
	public void Validate_AIVA_Responses(String Text1) throws InterruptedException{
		//Text1 = Text1.toString();
		Thread.sleep(8000);
		List<WebElement> element = driver.findElements(By.className("tfs-message-content"));
		int ElementSize = element.size();
		System.out.println("New Size of element is "+ElementSize);
		for(int i1 = ElementSize; i1>=ElementSize-2; i1--){
			try{
				String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div["+i1+"]")).getText();
				if(text.contains(Text1)){
					System.out.println("Matched with the string "+Text1);
					System.out.println("String found at the position of "+i1);
					break;
				}
			}catch(Exception e){}
		}
	}
	
	@Then("^Submit the FeedBack Form$")
	public void Submit_the_FeedBack_Form() throws InterruptedException{
		driver.findElement(By.className("tfs-card-panel-content")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("tfs_interaction_iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-textarea-freetextarea\"]")).sendKeys("FeedBack Submitted");
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-submit\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("tfs_interaction_iframe");
	}
	
	
	@Then("^Submit Wrap Up With Yes$")
	public void Submit_Wrap_Up_With_Yes() throws InterruptedException, FileNotFoundException, UnsupportedEncodingException{
		Validate_AIVA_Responses("Did that help?");
		Select_Quick_Response("Yes");
		Validate_AIVA_Responses("For your convenience, if you ever need to refresh your radio signal, just go to _www.sirius.com/refresh_ and follow the 3 steps.");
		Validate_AIVA_Responses("Is there anything else I can do for you?");
		Select_Quick_Response("Yes");
		Validate_AIVA_Responses("How can I be of service?");		
	}
	
	
	@Then("^Submit Wrap Up With No$")
	public void Submit_Wrap_Up_With_No() throws InterruptedException, FileNotFoundException, UnsupportedEncodingException{
		Validate_AIVA_Responses("Did that help?");
		Select_Quick_Response("No");
		Validate_AIVA_Responses("I'll try to do better in the future. Would you like me to connect you with a specialist who can help you right now?");
		Select_Quick_Response("No");
		Validate_AIVA_Responses("Is there anything else I can do for you?");
		Select_Quick_Response("Yes");
		Validate_AIVA_Responses("How can I be of service?");		
	}
	
	
	

	@Then("^Submit the Post Chat Survey$")
	public void Submit_the_Post_Chat_Survey() throws InterruptedException{
		driver.findElement(By.className("tfs-card-panel-content")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("tfs_interaction_iframe");
		Thread.sleep(1000);
		List<WebElement> allDivElements = driver.findElements(By.tagName("div"));
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
				else if (id.contains("tfs-widget-listinput")){
					String id1 = allDivElements.get(i).getAttribute("id");
					System.out.println("value of text is "+id1);
					if(id1.contains("tfs-widget-Q0")){
						String a = "//*[@id=\""+id1+"-A01 Yes\"]";
						System.out.println("a is "+a);
						driver.findElement(By.xpath(a)).click();
					}
				}
			} catch(Exception e) {}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-submit\"]")).click();
		Thread.sleep(2000);
	}

	@Then("^Submit the Feed Back Form$")
	public void Submit_the_Feed_Back_Form() throws InterruptedException{
		driver.findElement(By.className("tfs-card-panel-content")).click();
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-textarea-freetextarea\"]")).sendKeys("AIVA Testing");
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-submit\"]")).click();
		Thread.sleep(2000);
	}


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Then("^Select Quick Response \"(.*?)\"$")
	public void Select_Quick_Response(String QuickResponse) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException{

		driver.switchTo().defaultContent();
		driver.switchTo().frame("tfs_interaction_iframe");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("Test messsage");
		try{
			for(int a1=1;a1<=3;a1++){
				String a2= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[*]/fieldset/label["+a1+"]")).getText();
				if(a2.equals(QuickResponse)){
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[*]/fieldset/label["+a1+"]")).click();
				}

			}
		}catch(Exception e){

		}}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Then("^Set the Console cookie for Proactive$")
	public void Set_the_Console_cookie_for_Proactive() throws InterruptedException{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("_tfs.startInteraction({},{\"triggerAppId\":\"Proactive_invite\",\"type\":\"proactive\",\"ruleId\":\"my_proactive\","
				+ "\"queue\":\"sirius-account-default-queue-SiriusXM-General-Desktop\",\"appId\":\"desktopAuth_VA\"});");	
	}

	@Given("^New Proactive is triggered$")
	public void New_Proactive_is_triggered() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[3]/div[2]")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("_tfs.startInteraction({},{\"triggerAppId\":\"Proactive_invite\",\"type\":\"proactive\",\"ruleId\":\"my_proactive\","
				+ "\"queue\":\"sirius-account-default-queue-SiriusXM-General-Desktop\",\"appId\":\"desktopAuth_VA\"});");	
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"tfs_invite_Proactive_invite_context2\"]")).getText().equalsIgnoreCase("Chat with a live expert.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs_invite_Proactive_invite_action1\"]")).click();
		Thread.sleep(10000);
		driver.switchTo().frame("tfs_interaction_iframe");

	}

	@Then("^Agent message is sent successfully$")
	public void agent_message_is_sent_successfully() throws Throwable {
		AssistDriver.findElement(By.xpath("//*[@id=\"navigDiv_chatApp_label\"]")).click();
		Thread.sleep(5000);
		Thread.sleep(2000);
		AssistDriver.switchTo().frame(AssistDriver.findElement(By.xpath("//iframe[contains(@id, 'typingBox')]")));
		AssistDriver.findElement(By.id("dijitEditorBody")).sendKeys("Test message from Agent side");
		AssistDriver.findElement(By.id("dijitEditorBody")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);  
	}

	@Then("^Reinitiate the chat window for other scenario$")
	public void Reinitiate_the_chat_window_for_other_scenario() throws InterruptedException{
		Thread.sleep(1000);
		//driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"start-va\"]")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("tfs_interaction_iframe");

	}

	@Given("^Chat is ended from visitor side$")
	public void chat_is_ended_from_visitor_side() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[3]/div[2]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='tfs-widget-input-secondary-endchat']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[3]/div[2]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='tfs-widget-input-primary-endchat']")).click();
		Thread.sleep(3000);
	}

	@Then("^Verify the exit Survey and submit$")
	public void verify_the_exit_Survey_and_submit() throws Throwable {
		//driver.findElement(By.xpath("//*[@id=\"aria-description-Q01 Please rate your satisfaction with the SiriusX\"]")).getText().compareToIgnoreCase("Please rate your satisfaction with the SiriusXM online chat feature");
		//FillExitSurvey();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-submit\"]")).click();
	}

	@Then("^Submit the ADF$")
	public void submit_the_ADF() throws Throwable {
		//SPECIFIC TO CLIENTS AS THE ADF DIFFER FOR EACH CLIENT
		Thread.sleep(3000);
		AssistDriver.switchTo().defaultContent();
		AssistDriver.switchTo().frame(AssistDriver.findElement(By.xpath("//iframe[contains(@id, 'formContainer_INT')]")));
		DDL_Select("//*[@id=\"Q02_Category_-_Level_1_Select\"]/option","Account Management");   
		DDL_Select("//*[@id=\"Q03_Category_-_Level_2_Select\"]/option", "Change Current Plan/Term");
		DDL_Select("//*[@id=\"Q04_Disposition_-_Level_1_Select\"]/option", "Transferred");
		Thread.sleep(3000);
		AssistDriver.findElement(By.xpath("//*[@id=\"submit-form\"]")).click();
		Thread.sleep(2000);
	}
	//***************************************************************************//
	//***************UTILITIES FUNCTIONS*****************************************//
	public void DDL_Select(String XPath, String Option){
		List<WebElement> DDL= AssistDriver.findElements(By.xpath(XPath));   
		System.out.println("Total number of drop down values:::::::::" + DDL.size() );
		for (int i=1;i<DDL.size();i++){
			System.out.println("the drop down values are : " +  DDL .get(i).getText());
			String a = DDL.get(i).getText();
			if(a.equalsIgnoreCase(Option)){
				int a1= i+1;
				AssistDriver.findElement(By.xpath(XPath+"["+a1+"]")).click();
			}}
	}

	public static void IS_ELEMENT_PRESENT(String ElementName, String Xpath) throws IOException{
		SXMAIVA_Definition.driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		boolean exists = driver.findElements(By.id(Xpath) ).size() != 0;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		if(exists){
			System.out.println("Element with ID  "+ElementName+"  Exists");
		}else{
			Take_ScreenShot("IS_ELEMENT_PRESENT");
		}
	}	

	public static void Take_ScreenShot(String MethodName) throws IOException
	{
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Date1 = sdf.format(timestamp);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("C:\\AIVA_Responses\\SXM_Screenshots\\screenshot_"+Date1+"_"+MethodName+".png"));

	}

	public void FindAIVAResponse(){
		List<WebElement> element = driver.findElements(By.className("tfs-message-wrapper"));
		for(int i1 = 0; i1<element.size(); i1++){
			try{
				String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div/div[2]/div["+i1+"]")).getText();
				System.out.println(text);}
			catch(Exception e){
				System.out.println("value of i is "+i1);
			}			
		}
	}

	public void FillExitSurvey(){
		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("tfs_interaction_iframe");
			List<String> allIds = new ArrayList<String>();
			//Parent class for tfs-dialog tfs-dialog-survey
			//changing the tdElement xpath for AIVA card value
			//WebElement tdElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]"));
			List<WebElement> allDivElements = driver.findElements(By.tagName("div"));
			for(int i = 0; i<allDivElements.size(); i++){

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

			}}
		catch (Exception e){}
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-submit\"]")).click();
	}}