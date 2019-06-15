package com.automation.testcases;

import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;

public class SignUpTest extends BaseTest {

	@Test()
	public void CreateNewAccountTest() {
		LoginPage loginPage = new LoginPage(driver, log, prop, config);
		loginPage.openPage();
		loginPage.enterFirstName(8);
		loginPage.enterSurname(5);
		loginPage.enterEmailAddress(10);
		loginPage.enterNewPassowrd(8);
		loginPage.selectDOB("24-10-1994");
		loginPage.selectGender("female");
		loginPage.submitSignUpForm();
	}
}
