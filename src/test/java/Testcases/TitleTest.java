package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class TitleTest extends BaseClass {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");

	}

	@Test(priority = 1)
	public void verifyTitle() {

		String actualTitle = driver.getTitle().trim().replaceAll("\\u00A0", " ").replaceAll("\\s+", " ");
		System.out.println("Normalized Page Title: " + actualTitle);
		String expected = "Consulting, Software Development, Digital Transformation | AdaptNXT".replaceAll("\\s+", " ");
		System.out.println("Expected Title: '" + expected);
		System.out.println("Actual Title: '" + actualTitle);
		Assert.assertTrue(actualTitle.contains(expected), "Expected Message is Not Displayed");
	}

	@Test(priority = 2)
	public void verifyTitleMismatch() {

		String actualTitle = driver.getTitle().trim().replaceAll("\\u00A0", " ").replaceAll("\\s+", " ");
		System.out.println("Normalized Page Title: " + actualTitle);
		String expected = "Consulting, Software Development, Digital Transformation";
		System.out.println("Expected Title: '" + expected);
		System.out.println("Actual Title: '" + actualTitle);
		Assert.assertFalse(actualTitle.contains(expected), "Expected Message is  Displayed");
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
