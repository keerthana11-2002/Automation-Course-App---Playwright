package first_package;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginLogout {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page p = browser.newPage();
		p.navigate("https://freelance-learn-automation.vercel.app/login");
		p.getByPlaceholder("Enter Email").fill("jkkeerthana10@gmail.com");
		p.locator("css=input[name='password1']").fill("Itsmejk@2002");
		p.locator("xpath=//button[@class='submit-btn']").click();

		PlaywrightAssertions.assertThat(p.locator("//h4[@class='welcomeMessage']")).containsText("Welcome");
		p.getByAltText("menu").click();

		p.getByText("Sign out").click();
		PlaywrightAssertions.assertThat(p).hasURL(Pattern.compile("login"));

		browser.close();
		pw.close();
	}

}
