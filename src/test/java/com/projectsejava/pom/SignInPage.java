package com.projectsejava.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends Base {
	
	//LogIn
	By HomeUserNameLocator = By.name("userName");
	By HomePasswordLocator = By.name("password");
	By HomeSubmitLocator = By.name("submit");
	By HomeSuccesfully = By.xpath("//*[contains(text(),'Thank you for Loggin.')]");
	

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void signIn() throws InterruptedException {
		if (isDisplayed(HomeUserNameLocator)) {
			Thread.sleep(2000);
			type("yaneli", HomeUserNameLocator );
			Thread.sleep(2000);
			type("123",HomePasswordLocator );
			Thread.sleep(2000);
			click(HomeSubmitLocator);
			
		}else {
			System.out.println("System was not found");
		}
		
		
	}

	public boolean isHomeDisplayed() {
		
		
		return isDisplayed(HomeSuccesfully);
		
		
		
	}
}
