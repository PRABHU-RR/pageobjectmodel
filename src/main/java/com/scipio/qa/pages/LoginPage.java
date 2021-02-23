package com.scipio.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scipio.qa.base.TestBase;

public class LoginPage extends TestBase {
	// PageFactory - OR(Object Repository)
	@FindBy(id = "field_id__2")
	WebElement username;

	@FindBy(id = "field_id__3")
	WebElement password;

	@FindBy(id = "field_id__7")
	WebElement loginbutton;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerbutton;

	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement brandlogo;

	//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Getting Login Page Title
	public String validatingLoginPageTitle() {
		return driver.getTitle();
	}
	
	//Verify BrandLogo Displaying or not
	public boolean validatingBrandLogo() {
		return brandlogo.isDisplayed();
	}
	
	//Redirecting to Home page after login
	public HomePage login(String username,String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginbutton.click();
		return new HomePage();
	}



}
