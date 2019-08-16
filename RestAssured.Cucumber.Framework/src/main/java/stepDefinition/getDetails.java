package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import util.Excelop;


public class getDetails {
	 Excelop excelObj;
	 RequestSpecification request;  
	
	 @Before
	public void ini() throws IOException
	{
		 excelObj = new Excelop("/Users/rahultiwari/eclipse-workspace/RestAssured.Cucumber.Framework/target/Workbook.xlsx");
		  request= RestAssured.given();
	}
	 
	 @After
		public void tearDown() throws IOException
		{
			 excelObj.closeWorkbook();
			  
		}
	
	
	static Logger log = Logger.getLogger(getDetails.class);

    //public BaseExcel excel= new BaseExcel(); //To create an object of BaseExcel Class

    

            Response response=null;

             // ValidaworksheetleResponse json;

              
	
	@Given("^I want to execute service \"([^\"]*)\"$")
	public void i_want_to_execute_service(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		log.info("Executing service" + arg1);
	    
	}

	@When("^I submit the GET request as per the data in Excel Worksheet \"([^\"]*)\"$")
	public void i_submit_the_GET_request_as_per_the_data_in_Excel_Worksheet(String arg1) throws Throwable {
		
				
		String endpoint=excelObj.readData(arg1, 1, 1).toString();
		String qparamname=excelObj.readData(arg1, 1, 2).toString();
		String qparamval=excelObj.readData(arg1, 1, 3).toString();
		
		System.out.println(endpoint);
		
		response = request.given().when().relaxedHTTPSValidation().and().queryParam(qparamname, qparamval).get(endpoint);
	    
	}

	@SuppressWarnings("deprecation")
	@When("^I validate status code$")
	public void i_validate_status_code() throws Throwable {
		String val=excelObj.readData("first", 1, 5).toString();
double statusCodeexcel=Double.parseDouble(val);
		
		System.out.println("statusCodeexcel" + (int)statusCodeexcel);
		
		Assert.assertEquals((int)statusCodeexcel, response.getStatusCode());
		
		
	    
	}

	@When("^I validate mandatory tag in response from Excel Worksheet \"([^\"]*)\"$")
	public void i_validate_mandatory_tag_in_response_from_Excel_Worksheet(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		excelObj.writeData(arg1, 1, 9, response.prettyPrint());
		
	    
	}

	@When("^I validate response content$")
	public void i_validate_response_content() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I validate tag values in response from Excel Worksheet \"([^\"]*)\"$")
	public void i_validate_tag_values_in_response_from_Excel_Worksheet(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I validate header parameter in response$")
	public void i_validate_header_parameter_in_response() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
