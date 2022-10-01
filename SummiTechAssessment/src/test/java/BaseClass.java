

import java.nio.file.Paths;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class BaseClass {

	
	// TODO Auto-generated method stub

	static Playwright playwright = null;
	static BrowserContext browserContext = null;
	static Browser browser = null;
static Page page = null;
@BeforeClass
	public static Page initBrowser(String browserName) {
	System.out.println("Browser name is : " +browserName);	   
	playwright = Playwright.create();
		    switch (browserName.toLowerCase()) {
			case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "firefox":
				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "safari":
				browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "chrome":
				browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
				break;

			default:
				System.out.println("Please pass the right browser name...");
				break;
			}
		    browserContext = browser.newContext();
		    page = browserContext.newPage();
			
			/*
			 * browserContext.tracing().start(new Tracing.StartOptions()
			 * .setScreenshots(true) .setSnapshots(true) .setSources(true));
			 */	
		    page.setDefaultNavigationTimeout(100000);
		    page.navigate("https://stage.outreach.sloovi.com/login");

		    return page;
		    }}
		

/*
 * //@AfterClass
 * 
 * public void TearDown() { browserContext.tracing().stop(new
 * Tracing.StopOptions()
 * .setPath(Paths.get("C:\\Users\\hp\\git\\Sloove\\loginPage\\trace.zip"))); } }
 */