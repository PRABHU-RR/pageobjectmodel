package com.scipio.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.scipio.qa.util.TestUtil;

public class TestBase {
	/*
	 * Creating Static variable to access without objects
	 */
	public static WebDriver driver;
	public static Properties prop;
	static String current = System.getProperty("user.dir");
	/**
	 * Creating a Constructor for TestBase
	 */
	public TestBase() {
		try {
			FileInputStream ip = new FileInputStream(
					current +"/src/main/java/com/scipio/qa/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void intialization(){
		String browserName = prop.getProperty("browser");
		String driverLocation = prop.getProperty("driverLocation");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",current + driverLocation);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", current + driverLocation);
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}
