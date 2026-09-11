package tests;
import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ExcelUtil;

public class LoginTest {
Playwright playwright;
Browser browser;
Page page;
@BeforeMethod
public void setup() {
playwright = Playwright.create();
browser = playwright.chromium().launch(
new BrowserType.LaunchOptions().setHeadless(false));
page = browser.newPage();
}
@DataProvider(name = "loginData")
public Object[][] loginData() throws Exception {
return ExcelUtil.getData();
}

@Test(dataProvider = "loginData")
public void verifyLogin(String username, String password) {
LoginPage login = new LoginPage(page);
login.open();
login.login(username, password);
if (username.equals("student") &&
password.equals("Password123")) {

Assert.assertTrue(login.isLoginSuccessful());

} else {

Assert.assertTrue(login.isErrorDisplayed());

}

}

@AfterMethod
public void tearDown() {
browser.close();
playwright.close();

}

}
