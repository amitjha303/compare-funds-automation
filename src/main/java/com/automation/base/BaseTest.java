package com.automation.base;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected static WebDriver driver;
	protected static Logger log;
	protected static Properties prop;
	protected static Properties config;
	
	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	protected void setUpClass(String browser, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = Logger.getLogger(testName);
		prop = ObjectRepository.loadObjectRepository(log);
		config = TestConfiguration.loadTestConfigurations(log);
		log.info("Test set up");
		driver = BrowserFactory.getDriver(browser, log);
		driver.manage().window().maximize();
	}
	
	@AfterTest(alwaysRun = true)
	protected void tearDown() {
		log.info("Test tear down");
		driver.quit();
	}
}
