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

public class TechnologiesTest extends BaseClass {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void verifyTechnologiespagetitle() throws InterruptedException {
		WebElement technologieslink = driver.findElement(By.linkText("Technologies"));
		technologieslink.click();
		Assert.assertEquals(
			driver.findElement(By.xpath("//h1[contains(text(),'Technologies We Work')]")).getText(),
			"Technologies We Work"
		);
	}

	@Test(priority = 2)
	public void verifyTechnologiespagetitlemismatch() throws InterruptedException {
		WebElement technologieslink = driver.findElement(By.linkText("Technologies"));
		technologieslink.click();
		Assert.assertNotEquals(
			driver.findElement(By.xpath("//h1[contains(text(),'Technologies We Work')]")).getText(),
			"Technologies We"
		);
	}

	@Test(priority = 3)
	public void verifyhoverTechnlogiesToDataAnalyticsurlmatch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement technologieslink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Technologies")));
		Actions actions = new Actions(driver);
		actions.moveToElement(technologieslink).perform();
		WebElement dataanalyticslink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Data Analytics']")));
		actions.moveToElement(dataanalyticslink).click().perform();
		wait.until(ExpectedConditions.urlContains("https://adaptnxt.com/technologies-we-work/#data-analytics"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://adaptnxt.com/technologies-we-work/#data-analytics");

	}
	@Test(priority = 4)
	public void verifyhoverTechnlogiesToDataAnalyticsurlmismatch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement technologieslink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Technologies")));
		Actions actions = new Actions(driver);
		actions.moveToElement(technologieslink).perform();
		WebElement dataanalyticslink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Data Analytics']")));
		actions.moveToElement(dataanalyticslink).click().perform();
		wait.until(ExpectedConditions.urlContains("https://adaptnxt.com/technologies-we-work/#data-analytics"));
		Assert.assertNotEquals(driver.getCurrentUrl(), "https://adaptnxt.com/technologies-we-work");

	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}