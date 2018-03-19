package artOfTesting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Proxy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;


//@RunWith(Cucumber.class)
//@CucumberOptions (features = {"src/test/resource/artOfTesting/features"}, glue = "steps")

@CucumberOptions(features = "src/test/resources/UDEFeature/features/UDE.feature", format = { "pretty",
							"html:target/site/cucumber-pretty",
								"rerun:target/rerun.txt",
"json:target/cucumber1.json" })
public class SiriusXMAIVA extends AbstractTestNGCucumberTests{
	public static  BrowserMobProxy proxy;
	public static Proxy seleniumProxy;
	static Date date = new Date();
	static SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_h_mm_ss_a");
	static String Time = sdf.format(date);

	@BeforeSuite
	public void  Start_the_BrowserMob_Proxy() throws Exception{
		//Browser MOB CODE
		
		// start the proxy
	     proxy = new BrowserMobProxyServer();
	    proxy.start(0);
	 // get the Selenium proxy object
	    seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		
		
		/*server = new ProxyServer(9191);
		server.start();
		proxy = server.seleniumProxy();
		proxy.setSslProxy("localhost:"+server.getPort());
		proxy.setHttpProxy("localhost:"+server.getPort());
		System.out.println("Proxy started");
		server.newHar("StockMarketData");*/
		}


	//@When ("^The test is completed$")
	@AfterSuite
	public void The_test_is_completed() throws Exception{
		//BrowserMOB CODE
		Har har = proxy.getHar();
		File harFile = new File("C:\\Downloads\\_har\\Cucumber_BrowserMob_BG\\Test"+Time+".har");
		har.writeTo(harFile);
		System.out.println("Harfile Name    ::::   "+harFile);
		proxy.stop();
		System.out.println("Proxy Ended");
		//BrowserMOB CODE
	}

}