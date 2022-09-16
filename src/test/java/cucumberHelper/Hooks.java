package cucumberHelper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import core.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
/*import io.cucumber.java.Scenario;*/

public class Hooks extends BaseClass {

	
	public String getByteScreenshot() throws IOException 
	{
		
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
	@After
	public void af() throws IOException, InterruptedException
	{
		driver.close();
		driver.quit();
	   
	}
	@AfterStep
	public void as(Scenario scenario) throws IOException, InterruptedException
	{
		
	    scenario.attach(getByteScreenshot(), "image/png", "screenshot name");		
	}
	
	
}
