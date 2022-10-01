package tests;

import static org.testng.Assert.assertEquals;

import java.nio.file.Paths;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.loginPage;
import pages.selectLocationPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class loginTests  {
	static loginPage lp;
	static selectLocationPage sl;
	BrowserContext brc;
	Page page;
	@BeforeTest
	public void setup() throws InterruptedException {
		lp = new loginPage(page);
		sl = new selectLocationPage(page);

		Playwright play = Playwright.create();
		Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		brc =browser.newContext();
		page = brc.newPage();
		page.navigate("https://staging.indigoemr.com/login");
	}


	@Test(priority = 6) public void loginWithValidCredentials() { 
		lp = new loginPage(page); 
		lp.setUsername("test-qa@inboxkitten.com");
		lp.setPassword("qaV9ult!x"); 
		lp.clickLoginBtn();
		sl = new selectLocationPage(page);
		sl.clickContinueBtn();
		sl.clickFrontDeskModule();
		assertThat(page).hasURL("https://staging.indigoemr.com/frontdesk/dashboard");
		brc.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLogin1.json")));

	}

	@Test(priority = 5)
	public void loginWithCorrectEmailAndIncorrectPassword() {
		lp = new loginPage(page);
		lp.setUsername("test-qa@inboxkitten.com");
		lp.setPassword("password");
		lp.clickLoginBtn();
		String message =lp.errorMessage();
		assertEquals(message, "Invalid email or password");
	}
	@Test(priority = 4)
	public void loginWithIncorrectEmailAndCorrectPassword() {
		lp = new loginPage(page);
		lp.setUsername("test@inboxkitten.com");
		lp.setPassword("qaV9ult!x");
		lp.clickLoginBtn();
		String message =lp.errorMessage();
		assertEquals(message, "Invalid email or password");
	}
	@Test(priority = 3)
	public void loginWithEmptyEmailAndCorrectPassword() {
		lp = new loginPage(page);
		lp.setUsername("");
		lp.setPassword("qaV9ult!x");
		lp.clickLoginBtn();
		String message =lp.emptyEmailErrorMsg();
		assertEquals(message, "Empty email address");
	}
	@Test(priority = 2)
	public void loginWithCorrectEmailAndEmptyPassword() {
		lp = new loginPage(page);
		lp.setUsername("test-qa@inboxkitten.com");
		lp.setUsername("");
		lp.clickLoginBtn();
		String message =lp.emptyPasswordErrorMsg();
		assertEquals(message, "Empty password");
	}
	@Test(priority = 1)
	public void loginWithEmptyEmailAndEmptyPassword() {
		lp = new loginPage(page);
		lp.setUsername("");
		lp.setPassword("");
		lp.clickLoginBtn();
		String message =lp.emptyEmailErrorMsg();
		assertEquals(message, "Empty email address");

	}


}

