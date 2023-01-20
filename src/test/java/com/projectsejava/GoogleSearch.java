package com.projectsejava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


public class GoogleSearch {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver");		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void testGoogleSearch() {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.clear();
		
		searchBox.sendKeys("Automation Practice");
		
		searchBox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Automation Practice - Google Search", driver.getTitle());
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
}
