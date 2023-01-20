package com.projectsejava;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class localizadoresTest {
	
	private WebDriver driver;
	
	//Test
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");
	
	By registerNameLocator = By.id("email");
	By registerPasswordLocator = By.name("password");
	By registerConfirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerSubmitLocator = By.name("submit");
	By registerCookieLocator = By.cssSelector("body[link=\"#000099\"]");
	
	
	//LogIn
	By HomeUserNameLocator = By.name("userName");
	By HomePasswordLocator = By.name("password");
	By HomeSubmitLocator = By.name("submit");
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if (driver.findElement(registerPageLocator).isDisplayed()) {
			
			driver.findElement(registerNameLocator).sendKeys("yaneli");
			Thread.sleep(2000);
			driver.findElement(registerPasswordLocator).sendKeys("123");
			Thread.sleep(3000);
			driver.findElement(registerConfirmPasswordLocator).sendKeys("123");
			Thread.sleep(2000);
			//driver.findElement(registerCookieLocator).click();
			driver.findElement(registerSubmitLocator).click();
			
		}
		else {
			System.out.print("Register was not fount");
		}
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals ("Note: Your user name is yaneli.", fonts.get(5).getText());
	}
	
	@Test
	public void test2() throws InterruptedException {
		if (driver.findElement(HomeUserNameLocator).isDisplayed()){
			driver.findElement(HomeUserNameLocator).sendKeys("yaneli");
			driver.findElement(HomePasswordLocator).sendKeys("123");
			driver.findElement(HomeSubmitLocator).click();
			Thread.sleep(2000);
			
			List<WebElement> table = driver.findElements(By.tagName("table"));
			
			assertEquals("Login Successfully", table.get(8).getText());
			
		}
		else
			System.out.print("The page was not found");
		
	}
	

}
