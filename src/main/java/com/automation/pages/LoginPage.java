package com.automation.pages;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.base.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage>{
	private By firstNameInput = By.cssSelector(prop.getProperty("firstNameInput"));
	private By surnameInput = By.cssSelector(prop.getProperty("surnameInput"));
	private By emailInput = By.cssSelector(prop.getProperty("emailInput"));
	private By confirmEmailInput = By.cssSelector(prop.getProperty("confirmEmailInput"));
	private By passwordInput = By.cssSelector(prop.getProperty("passwordInput"));
	private By dobDayDropdown = By.cssSelector(prop.getProperty("dobDayDropdown"));
	private By dobMonthDropdown = By.cssSelector(prop.getProperty("dobMonthDropdown"));
	private By dobYearDropdown = By.cssSelector(prop.getProperty("dobYearDropdown"));
	private By femaleGenderOption = By.cssSelector(prop.getProperty("femaleGenderOption"));
	private By signUpButton = By.cssSelector(prop.getProperty("signUpButton"));
	
	public LoginPage(WebDriver driver, Logger log, Properties prop, Properties config) {
		super(driver, log, prop, config);
	}
	
	public void openPage() {
		log.info("Navigating to " + "URL" + " - " + config.getProperty("env"));
		getPage(config.getProperty("env"));
		waitForVisibilityOfElement(firstNameInput, 30);
	}
	
	public void enterFirstName(int textLength) {
		String randomFirstName = getRandomText(textLength);
		typeInput(randomFirstName, firstNameInput);
	}
	
	public void enterSurname(int textLength) {
		String randomSurname = getRandomText(textLength);
		typeInput(randomSurname, surnameInput);
	}
	
	public void enterEmailAddress(int textLength) {
		String randomEmailID = getRandomText(textLength) + "@outlook.com";
		typeInput(randomEmailID, emailInput);
		typeInput(randomEmailID, confirmEmailInput);
	}
	
	public void enterNewPassowrd(int textLength) {
		String randomPassword = getRandomText(textLength) + "@123";
		typeInput(randomPassword, passwordInput);
	}
	
	public void selectDOB(String dob) {
		String[] dobComponents = dob.split("-");
		selectFromDropdown(dobDayDropdown, dobComponents[0]);
		selectFromDropdown(dobMonthDropdown, dobComponents[1]);
		selectFromDropdown(dobYearDropdown, dobComponents[2]);
	}
	
	public void selectGender(String genderType) {
		if (genderType.equals("female")) {
			click(femaleGenderOption);
		}
	}
	
	public void submitSignUpForm() {
		click(signUpButton);
	}
}
