package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static AndroidDriver driver;
	private String deviceName = "Pixel 3a API 30";
	private String platformVersion = "11";
	private String appPackage = "de.payback.client.android";
	private String appActivity = "de.payback.app.deeplinks.StarterActivity";
	
	public AndroidDriver getDriver() throws MalformedURLException {
		if (driver == null) 
			driver = createDriver();
		
		return driver;
	}

	private AndroidDriver createDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);

		capabilities.setCapability("platformVersion", platformVersion);

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("autoGrantPermissions", "true");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("automationName", "UiAutomator2");
		
		capabilities.setCapability("appPackage", appPackage);

		
		capabilities.setCapability("appActivity", appActivity);

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		return driver;
	}
}
