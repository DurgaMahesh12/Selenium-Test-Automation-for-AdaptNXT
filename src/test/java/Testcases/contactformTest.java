package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class contactformTest extends BaseClass {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void verifyconatctformprovieAlldetails() {
		driver.findElement(By.xpath("//div[@class='ast-custom-button']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Your Name']")).sendKeys("Durga Mahesh");
		driver.findElement(By.xpath("//input[@placeholder='Your Email']")).sendKeys("durgamaheshvanum123@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Your Phone Number']")).sendKeys("9177517544");
		driver.findElement(By.xpath("//textarea[@placeholder='Message to us...']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='random-math-quiz']")).sendKeys("25");
		driver.findElement(By.xpath("//input[@value='Send Email']")).click();
		WebElement errormessage = driver
				.findElement(By.xpath("//div[contains(text(),'One or more fields have an error. Please check and')]"));
		String actualwarnmessage = errormessage.getText();
		Assert.assertEquals(actualwarnmessage, "One or more fields have an error. Please check and try again.");
	}

	@Test(priority = 2)
	public void verifyconatctformwithoutdetails() {
		driver.findElement(By.xpath("//div[@class='ast-custom-button']")).click();
		driver.findElement(By.xpath("//input[@value='Send Email']")).click();
		WebElement errormessage = driver
				.findElement(By.xpath("//div[contains(text(),'One or more fields have an error. Please check and')]"));
		String actualwarnmessage = errormessage.getText();
		Assert.assertEquals(actualwarnmessage, "One or more fields have an error. Please check and try again.");
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
