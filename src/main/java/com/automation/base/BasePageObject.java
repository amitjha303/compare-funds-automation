package com.automation.base;

import java.util.ArrayList;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
	protected WebDriver driver;
	protected Logger log;
	protected Properties prop;
	protected Properties config;

	protected BasePageObject(WebDriver driver, Logger log, Properties prop, Properties config) {
		this.driver = driver;
		this.log = log;
		this.prop = prop;
		this.config = config;
	}
	
	@SuppressWarnings("unchecked")
	protected T getPage(String url) {
		driver.get(url);
		return (T) this;
	}
	
	protected void typeInput(String keyInput, By element) {
		clearText(element);
		find(element).sendKeys(keyInput);
	}

	private WebElement find(By element) {
		return driver.findElement(element);
	}
	
	protected void click(By element) {
		find(element).click();
	}
	
	protected void waitForVisibilityOfElement(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
			attempts++;
		}
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : Integer.parseInt(config.getProperty("defaultExplicitWait"));
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}
	
	protected void clearText(By element) {
		int len = find(element).getAttribute("value").length(); 
		for(int i = 0; i < len; i++ ) {
			find(element).sendKeys(Keys.BACK_SPACE);
		}
	}
	
	protected void switchWindowTab(int tabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabIndex-1));
	}
}
