package pages;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Route.FulfillOptions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TextboxPage{

private Page page;
public TextboxPage(Page page) {
this.page = page;
}

// Locators
private String Fullname = "#userName";
private String Email = "#userEmail";
private String submitbtn = "#submit";
private String pid = "#email";
private String pname = "#name";

//Actions
public void enterFullname(String user) {
page.locator(Fullname).fill(user);
}
public void enterEmail(String email) {
page.locator(Email).fill(email);
}
public void submitbutton(){
page.locator(submitbtn).click();

}
public void verifyFullnameDisplayed(String expectedName) {
	// Assertion methods
	assertThat(page.locator(pname))
	.hasText("Name:" + expectedName);
	System.out.println("Assertion passed");
	}
	}