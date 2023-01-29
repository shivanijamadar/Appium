package com.Simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SpinnerExample {
 //Spinners are DropDowns
	AndroidDriver<MobileElement> driver;
	@BeforeTest
	public void launchApp() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
		cap.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
	    cap.setCapability("noReset", true);
	    
	    driver = new AndroidDriver<>(new URL("http:0.0.0.0:4723/wd/hub"), cap);
	    
	}
	
	@Test
	public void selectValuesFromSpinners() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))").click();

		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner1")).click();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='yellow']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='yellow']")).click();
		
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner2")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='Earth']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Earth']")).click();
	}
	
	@AfterTest
	public void closeApp(){
		driver.quit();
	}
}
