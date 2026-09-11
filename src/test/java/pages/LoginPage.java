package pages;
import com.microsoft.playwright.*;

public class LoginPage {

private Page page;
public LoginPage(Page page) {
this.page = page;
}
public void open() {
page.navigate("https://practicetestautomation.com/practice-test-login/");
}
public void login(String username, String password) {
page.locator("#username").fill(username);
page.locator("#password").fill(password);
page.locator("#submit").click();
}
public boolean isLoginSuccessful() {
return page.locator("text=Logged In Successfully").isVisible();
}
public boolean isErrorDisplayed() {
return page.locator("#error").isVisible();
}

}

