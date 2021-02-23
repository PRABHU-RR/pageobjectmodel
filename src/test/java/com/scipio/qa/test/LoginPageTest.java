package com.scipio.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.scipio.qa.base.TestBase;
import com.scipio.qa.pages.HomePage;
import com.scipio.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	// Initialize TestBase Constructor
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validatingLoginPageTitle();
		Assert.assertEquals(title, "SCIPIO - MajorLeague: Login");
	}
	
	@Test(priority=2)
	public void brandLogoImageTest() {
		boolean logo =loginPage.validatingBrandLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("userName"), ("passWord"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
