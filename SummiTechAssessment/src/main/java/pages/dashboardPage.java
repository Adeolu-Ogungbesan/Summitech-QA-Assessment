package pages;

import com.microsoft.playwright.Page;

public class dashboardPage {
Page page = null;

String bookAppointmentBtn = "text=Book Future Appointment";
String MRNTextBox = "[placeholder='Enter MRN']";
String nameTextBox = "[placeholder='Enter Name']";
String prefferedBranchDropdown = ".modal-select__value-container";
String luthSelection = "#react-select-2-option-7";
String specialityDropdown = "text=Select Option";
String Ophthalmology = "#react-select-3-option-1";
String calenderDropdown = "[placeholder='YYYY-M-D']";
String appointmentDate = "[aria-label='Thu Oct 27 2022']";
String profileBtn = "li[role='button']:has-text('John Doe')";
String logOutBtn = "li:has-text('Logout')";

public dashboardPage(Page page) {
	this.page=page;
}

public void clickBookFutureAppointmentBtn() {
	page.click(bookAppointmentBtn);
}
public void setMRN(String MRNNumber) {
	page.fill(MRNTextBox, MRNNumber);
}
public void setName(String name) {
	page.fill(nameTextBox, name);
}
public void clickSelectBranchDropdown() {
	page.click(prefferedBranchDropdown);
}
public void selectLuthBranch() {
	page.click(luthSelection);
}
public void clickSpecialityDropdown() {
	page.click(specialityDropdown);
}
public void selectOphthalmolgy() {
	page.click(Ophthalmology);
}
public void clickCalenderDropdownBtn() {
	page.click(calenderDropdown);
}
public void selectDate() {
	page.click(appointmentDate);
	
}
public void clickProfileBtn() {
	page.hover(profileBtn);
	page.click(profileBtn);
}
public void clicklogoutBtn() {
	page.click(logOutBtn);
}
}
