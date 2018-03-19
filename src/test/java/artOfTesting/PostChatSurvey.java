package artOfTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PostChatSurvey {

	WebDriver driver;

	@Test
	public void main() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Keshav_My Files\\Selenium_Files\\chromedriver.exe");
		driver = new  ChromeDriver(); 
		driver.get("http://anvil.tellme.com/~keskumar/ude/#start");
		driver.findElement(By.xpath("//*[@id=\"start-va\"]")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("tfs_interaction_iframe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("keshav");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("I want to suspend my subscription");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("NO");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tfs-footer-textarea\"]")).sendKeys("no");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("tfs-card-panel-content")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("tfs_interaction_iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-textarea-freetextarea\"]")).sendKeys("FeedBack Submitted");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tfs-widget-input-submit\"]")).click();
		
	}
		
		
	/*	
		
		//driver.findElement(By.xpath("//*[@id=\"tfs-widget-Q04 Was the chat agent able to resolve your issue-A01 Yes\"]")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"tfs-widget-Q01 Please rate your satisfaction with the SiriusX\"]/div[2]/fieldset/div/span/span[5]")).click();
//        List<String> allIds = new ArrayList<String>();
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
                    //allIds.add(id );
              } catch(Exception e) {}
            
		
	}
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"tfs-widget-submit\"]")).click();
        
	}*/
	
}
