package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class ServicesTest extends BaseClass {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void verifyServicespagetitle() {
		WebElement serviceslink = driver.findElement(By.linkText("Services"));
		serviceslink.click();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Services We Offer']")).getText(),
				"Services We Offer");
	}

	@Test(priority = 2)
	public void verifyServicespagemismatchtitle() {
		WebElement serviceslink = driver.findElement(By.linkText("Services"));
		serviceslink.click();
		Assert.assertNotEquals(driver.findElement(By.xpath("//h1[normalize-space()='Services We Offer']")).getText(),
				"Services We");
	}
	@Test(priority = 3)
	public void verifyhoverTechnlogiesToDataAnalyticsurlmatch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Serviceslink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Services")));
		Actions actions = new Actions(driver);
		actions.moveToElement(Serviceslink).perform();
		WebElement CICDlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='CI / CD']")));
		actions.moveToElement(CICDlink).click().perform();
		wait.until(ExpectedConditions.urlContains("https://adaptnxt.com/ci-cd/"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://adaptnxt.com/ci-cd/");

	}
   
	@Test(priority = 4)
	public void verifyhoverTechnlogiesToDataAnalyticsurlmismatch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Serviceslink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Services")));
		Actions actions = new Actions(driver);
		actions.moveToElement(Serviceslink).perform();
		WebElement CICDlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='CI / CD']")));
		actions.moveToElement(CICDlink).click().perform();
		wait.until(ExpectedConditions.urlContains("https://adaptnxt.com/ci-cd/"));
		Assert.assertNotEquals(driver.getCurrentUrl(), "https://adaptnxt.com/");

	}
	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
