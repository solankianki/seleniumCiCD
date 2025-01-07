package framework.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/framework/cucumber", tags= "@Regression" ,glue="framework.StepDefination",
monochrome=true,plugin= {"html:target/cucmber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	
}
