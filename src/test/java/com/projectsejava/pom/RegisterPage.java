package com.projectsejava.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base{
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");
	
	By registerNameLocator = By.id("email");
	By registerPasswordLocator = By.name("password");
	By registerConfirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerSubmitLocator = By.name("submit");
	By registerCookieLocator = By.cssSelector("body[link=\"#000099\"]");
	By registerMessage = By.tagName("font");
	

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void registerUser() throws InterruptedException {
		
		click(registerLinkLocator);
		
		Thread.sleep(2000);
		if (isDisplayed(registerPageLocator)) {
			Thread.sleep(2000);
			type("yaneli", registerNameLocator);
			Thread.sleep(2000);
			type("123", registerPasswordLocator);
			Thread.sleep(2000);
			type("123",registerConfirmPasswordLocator);
			Thread.sleep(2000);
			
			click(registerSubmitLocator);
		}else {
			System.out.println("The register page was not found ");
		}
	}
	
	public String registerMessage() {
		
		List<WebElement> fonts = findElements(registerMessage);
		
		return getText(fonts.get(5));
	} 
	

}
