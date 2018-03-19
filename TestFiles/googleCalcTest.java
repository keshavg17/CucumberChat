package artOfTesting;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
//@CucumberOptions (features = {"src/test/resource/artOfTesting/features"}, glue = "steps")

@CucumberOptions(features = "src/test/resources/artOfTesting/features/googleCalc.feature", format = { "pretty",
        "html:target/site/cucumber-pretty",
        "rerun:target/rerun.txt",
        "json:target/cucumber1.json" })
public class googleCalcTest extends AbstractTestNGCucumberTests{	
	
}
