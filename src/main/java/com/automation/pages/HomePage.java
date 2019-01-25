package com.automation.pages;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.base.BasePageObject;

public class HomePage extends BasePageObject<HomePage>{
	private By individualInvestorLink = By.xpath(prop.getProperty("individualInvestorLink"));
	
	public HomePage(WebDriver driver, Logger log, Properties prop, Properties config) {
		super(driver, log, prop, config);
	}
	
	public void openPage() {
		log.info("Navigating to " + config.getProperty("env") + " " + "URL");
		getPage(config.getProperty("env"));
		waitForVisibilityOfElement(individualInvestorLink, 30);
	}
	
	public InvestorHomePage navigateToInvestorHomePage() {
		log.info("Navigating to Individual Investor page");
		click(individualInvestorLink);
		return new InvestorHomePage(driver, log, prop, config);
	}
	
}
