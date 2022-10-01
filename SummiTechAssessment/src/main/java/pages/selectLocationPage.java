package pages;

import com.microsoft.playwright.Page;

public class selectLocationPage {
Page page = null;

String locationDropdownBtn = "svg";
String luth = "#react-select-2-option-0";
String continueBtn = "button:has-text('Continue')";
String frontDeskModule = "text=Front Desk";

public selectLocationPage(Page page) {
	this.page = page;
}
public void clickContinueBtn() {
	page.click(continueBtn);
}
public void clickFrontDeskModule() {
	page.click(frontDeskModule);
	
}}