package pages;

import com.microsoft.playwright.Page;

public class ProfilePage {

private Page page;
// Locators
private String Elements = "//div[contains(text(), 'Elements')]";
private String textbox = "//span[contains(text(), 'Text Box')]";

public ProfilePage(Page page) {
this.page = page;
}

public String getPageTitle() {
return page.title();
}
public void clickElement() {
page.locator(Elements).click();
}
public void clickTextBox() {
page.locator(textbox).click();
}
public boolean isLogoutDisplayed() {
return page.locator("#submit").isVisible();
}
}

