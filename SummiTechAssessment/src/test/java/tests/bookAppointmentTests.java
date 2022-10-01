package tests;

import java.nio.file.Paths;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.dashboardPage;
import pages.loginPage;
import pages.selectLocationPage;

public class bookAppointmentTests {



	static dashboardPage dash;
	static selectLocationPage sl;
	 
	
	Page page;
	@BeforeTest
	public void setup() throws InterruptedException {
		Playwright play = Playwright.create();
		Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin1.json")));
		 page =context.newPage();
		 page.navigate("https://staging.indigoemr.com/login");
		

	}
	@Test
	public void bookAppointmentWithValidInfo() {
		sl = new selectLocationPage(page);
		sl.clickContinueBtn();
		sl.clickFrontDeskModule();
		dash = new dashboardPage(page);
		dash.clickBookFutureAppointmentBtn();
		dash.setMRN("alt00109");
		dash.setName("Adeolu Ogungbesan");
		dash.clickSelectBranchDropdown();
		dash.selectLuthBranch();
		dash.clickSpecialityDropdown();
		dash.selectOphthalmolgy();
		dash.clickCalenderDropdownBtn();
		dash.selectDate();


	}





}
