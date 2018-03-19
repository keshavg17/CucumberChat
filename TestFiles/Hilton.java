package artOfTesting;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
//@CucumberOptions (features = {"src/test/resource/artOfTesting/features"}, glue = "steps")

@CucumberOptions(features = "src/test/resources/artOfTesting/features/Hilton.feature", format = { "pretty",
        "html:target/site/cucumber-pretty",
        "rerun:target/rerun.txt",
        "json:target/cucumber1.json" })
public class Hilton extends AbstractTestNGCucumberTests{	
	
}
