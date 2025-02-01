package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class AboutUshover extends BaseClass {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void verifyAboutUshover() throws InterruptedException {
		WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
		Actions actions = new Actions(driver);
		actions.moveToElement(aboutUsLink).perform();
		WebElement visionLink = driver.findElement(By.xpath("//a[text()='Our Vision']"));
		actions.moveToElement(visionLink).perform();
		visionLink.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Digital Transformation and Software Development Company | AdaptNXT";
		Assert.assertTrue(actualTitle.contains(expectedTitle), "ExpectedTitle is not their");
	}

	@Test(priority = 2)
	public void verifyourvisionlinkmismatchpagetitile() throws InterruptedException {
		WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
		Actions actions = new Actions(driver);
		actions.moveToElement(aboutUsLink).perform();
		WebElement visionLink = driver.findElement(By.xpath("//a[text()='Our Vision']"));
		actions.moveToElement(visionLink).perform();
		visionLink.click();
		String actualTitle = driver.getTitle();
		String incorrectTitle = "Digital Transformation and Software Development";
		Assert.assertNotEquals(actualTitle, incorrectTitle, "The title matches the incorrect title.");
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
