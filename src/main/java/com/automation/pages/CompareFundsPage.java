package com.automation.pages;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.base.BasePageObject;

public class CompareFundsPage extends BasePageObject<CompareFundsPage>{
	private By addFundButton = By.cssSelector(prop.getProperty("addFundButton"));
	private By firstFundInput = By.cssSelector(prop.getProperty("firstFundInput"));
	private By secondFundInput = By.cssSelector(prop.getProperty("secondFundInput"));
	private By thirdFundInput = By.cssSelector(prop.getProperty("thirdFundInput"));
	private By fourthFundInput = By.cssSelector(prop.getProperty("fourthFundInput"));
	private By compareFundButton = By.cssSelector(prop.getProperty("compareFundButton"));
	private By productFactsTable = By.cssSelector(prop.getProperty("productFactsTable"));
	
	public CompareFundsPage(WebDriver driver, Logger log, Properties prop, Properties config) {
		super(driver, log, prop, config);
	}
	
	public void selectFundsToCompare() throws InterruptedException {
		log.info("Selecting funds to compare");
		waitForVisibilityOfElement(addFundButton, 30);
		click(addFundButton);
		waitForVisibilityOfElement(firstFundInput, 30);
		click(firstFundInput);
		click(secondFundInput);
		click(thirdFundInput);
		click(fourthFundInput);
		click(compareFundButton);
		waitForVisibilityOfElement(productFactsTable, 30);
	}
	
}
