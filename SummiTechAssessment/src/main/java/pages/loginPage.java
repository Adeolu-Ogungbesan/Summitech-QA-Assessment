package pages;

import com.microsoft.playwright.Page;

public class loginPage {
	
	Page page = null;
	String emailAddTxtBox = "[placeholder='johndoe@gmail.com']";
	String passwordTxtBox = "//input[@type='password']";
	String viewPassword = "i";
	String rememberPasswordBtn = "text=Remember Me";
	String loginBtn = "button:has-text(\"Login\")";
	String errorMessage = "text=invalid email or password";
	String emptyEmailErrorMessage = "text=Empty email address";
	String emptyPasswordErrorMsg = "text=Empty password";
	
	public loginPage(Page page) {
		this.page = page;
	}
	public void setUsername(String email) {
		page.fill(emailAddTxtBox, email);
	}
	
	public void setPassword(String password) {
		page.fill(passwordTxtBox, password);
	}
	public void clickLoginBtn() {
		page.click(loginBtn);
	}
	public String errorMessage() {
		return page.textContent(errorMessage);
		
	}
	
	public String emptyEmailErrorMsg() {
		return page.textContent(emptyEmailErrorMessage);
	}
	public String emptyPasswordErrorMsg() {
		return page.textContent(emptyPasswordErrorMsg);
	}
	public void clickViewPassword() {
		page.click(viewPassword);
	}
	public String passwordText() {
		return page.textContent(passwordTxtBox);
	}
}
