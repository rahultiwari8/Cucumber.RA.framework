package runnerPackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/rahultiwari/eclipse-workspace/RestAssured.Cucumber.Framework/src/main/java/feature/Customerorder.feature"
				
		,glue={"stepDefinition"},
		dryRun =false
		//,tags = {"@Sanity , @Regression"} // run all scnarioes ABCDE
		//,tags = {"~@Regression,~@Sanity"} // run only BCDE
		//,tags = {"@Regression"} // run all tagged with Regression
				//,tags = {"@Sanity"} // runs all tagged with sanity
				//,tags = {"@Regression"} // runs all tagged with Regression
				//,tags = {"~@Sanity"} // runs all tagged with Regression only not sanity
				//,tags = {"~@Regression"} // runs all tagged with sanity only not Regression
				//,tags = {"~@Regression,~@Sanity"} // runs all tagged with sanity or Regression not both
				//,tags = {"@Regression,@Sanity"} // runs all tagged with sanity and Regression not sanity and regression alone
		)

public class Runner {
	
	

	

	

}