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

public class SpecializationTest extends BaseClass {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
		
	}
	@Test(priority=1)
	public void verifySpecilaizationpagetitle() {
		driver.findElement(By.xpath("//a[normalize-space()='Specializations']")).click();
		driver.findElement(By.xpath("//h1[normalize-space()='Our Specializations']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Our Specializations']")).getText(),"Our Specializations");
	}
	@Test(priority=2)
	public void verifySpecilaizationmismatchpagetitle() {
		driver.findElement(By.xpath("//a[normalize-space()='Specializations']")).click();
		driver.findElement(By.xpath("//h1[normalize-space()='Our Specializations']")).getText();
		Assert.assertNotEquals(driver.findElement(By.xpath("//h1[normalize-space()='Our Specializations']")).getText(),"Our Special");
	}
	@Test(priority = 3)
	public void verifyhoverSpecializationToprocessandAutomation() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Specializationlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Specializations")));
		Actions actions = new Actions(driver);
		actions.moveToElement(Specializationlink).perform();
		WebElement processandAutomationlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Process and Automation']")));
		actions.moveToElement(processandAutomationlink).click().perform();
		wait.until(ExpectedConditions.urlContains("https://adaptnxt.com/our-specializations/#process-automation"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://adaptnxt.com/our-specializations/#process-automation");

	}
	@Test(priority = 4)
	public void verifyhoverSpecializationToprocessandAutomationmismatchurl() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Specializationlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Specializations")));
		Actions actions = new Actions(driver);
		actions.moveToElement(Specializationlink).perform();
		WebElement processandAutomationlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Process and Automation']")));
		actions.moveToElement(processandAutomationlink).click().perform();
		wait.until(ExpectedConditions.urlContains("https://adaptnxt.com/our-specializations/#process-automation"));
		Assert.assertNotEquals(driver.getCurrentUrl(), "https://adaptnxt.com/our-specializations/");

	}
	
	
	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
