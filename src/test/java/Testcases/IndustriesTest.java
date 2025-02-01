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

public class IndustriesTest extends BaseClass {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);

	}

	@Test(priority=1)
	public void VerifyIndustrieshoverpagetitle() throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Industries']")).click();
		Actions actions = new Actions(driver);
		WebElement healthcarelink = driver
				.findElement(By.xpath("//a[normalize-space()='Healthcare and Data Science']"));
		actions.moveToElement(healthcarelink).perform();
		WebElement actualpagetitle = driver.findElement(By.xpath("//h1[contains(text(),'Industries we Serve')]"));
		System.out.println(actualpagetitle.getText());
		String actualpagetitlemessage = actualpagetitle.getText();
		String expectedtitle = "Industries we Serve";
		Assert.assertTrue(actualpagetitlemessage.contains(expectedtitle), "ExpectedTitle is not their");

	}
	@Test(priority=2)
	public void VerifyIndustriespagemismatchtitle() throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Industries']")).click();
		Actions actions = new Actions(driver);
		WebElement healthcarelink = driver
				.findElement(By.xpath("//a[normalize-space()='Healthcare and Data Science']"));
		actions.moveToElement(healthcarelink).perform();
		WebElement actualpagetitle = driver.findElement(By.xpath("//h1[contains(text(),'Industries we Serve')]"));
		System.out.println(actualpagetitle.getText());
		String actualpagetitlemessage = actualpagetitle.getText();
		String expectedtitle = "Industries we";
		Assert.assertFalse(actualpagetitlemessage.contains(expectedtitle), "ExpectedTitle is not their");

	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
