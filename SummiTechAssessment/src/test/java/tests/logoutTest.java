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
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class logoutTest {



	static dashboardPage dash;
	static selectLocationPage sl;
	Browser browser;
	BrowserContext context;
	loginPage lp;
	Page page;
	@BeforeTest
	public void setup() throws InterruptedException {
		Playwright play = Playwright.create();
		browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));		
		context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin1.json")));
		page = context.newPage();
		page.navigate("https://staging.indigoemr.com/login");


	}
	@Test
	public void logout() {	
		sl = new selectLocationPage(page);
		sl.clickContinueBtn();
		sl.clickFrontDeskModule();
		dash = new dashboardPage(page);
		dash.clickProfileBtn();
		dash.clicklogoutBtn();
		assertThat(page).hasURL("https://staging.indigoemr.com/login");


	}





}
