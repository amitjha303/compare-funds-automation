package com.automation.testcases;

import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.CompareFundsPage;
import com.automation.pages.HomePage;
import com.automation.pages.InvestorHomePage;

public class CompareFundsTest extends BaseTest {

	@Test()
	public void compare4FundsTest() throws InterruptedException {
		HomePage homePage = new HomePage(driver, log, prop, config);
		homePage.openPage();
		InvestorHomePage investorHomePage = homePage.navigateToInvestorHomePage();
		CompareFundsPage compareFundsPage = investorHomePage.navigateToCompareFundPage();
		compareFundsPage.selectFundsToCompare();
	}
}
