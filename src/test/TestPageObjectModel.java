package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.HomePage;

public class TestPageObjectModel {

	WebDriver myDriver;

	HomePage objHomePage;

	@BeforeTest
	public void setup() {

		myDriver = new FirefoxDriver();

		myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void FirstTestCase() {
		
		myDriver.get("http://book.theautomatedtester.co.uk/");

		// Create Home Page Object
		objHomePage = new HomePage(myDriver);

		// Verify Home Page Text
		objHomePage.verifyHomePageText();

		// Click on First Link
		objHomePage.clickOnLinkChapter1();
	}

	@AfterMethod
	public void tearDown() {

		myDriver.quit();
	}
}
