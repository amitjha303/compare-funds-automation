package com.automation.pages;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.base.BasePageObject;

public class InvestorHomePage extends BasePageObject<InvestorHomePage>{
	private By fundCompareLink = By.xpath(prop.getProperty("fundCompareLink"));
	
	public InvestorHomePage(WebDriver driver, Logger log, Properties prop, Properties config) {
		super(driver, log, prop, config);
	}
	
	public CompareFundsPage navigateToCompareFundPage() {
		log.info("Navigating to Compare Funds page");
		waitForVisibilityOfElement(fundCompareLink, 30);
		click(fundCompareLink);
		switchWindowTab(2);
		return new CompareFundsPage(driver, log, prop, config);
	}
	
}
