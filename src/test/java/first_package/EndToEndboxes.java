package first_package;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class EndToEndboxes {

	public static void main(String[] args) {
		Browser browser = null;
		try {
			Playwright pw = Playwright.create();
			BrowserType browsertype = pw.chromium();
			browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			Page p = browser.newPage();
			p.navigate("https://freelance-learn-automation.vercel.app/login");
			// click signup
			p.locator("xpath=//a[@class='subLink']").click();
			PlaywrightAssertions.assertThat(p.locator("//button[text()='Sign up']")).isDisabled();
			p.locator("xpath=//input[@id='name']").fill("Keerthana");
			p.locator("xpath=//input[@id='email']").fill("jkkeerthana590@gmail.com");
			p.locator("xpath=//input[@id='password']").fill("itsmejk@2002");
			Locator interset = p.locator("//label[text()='SQL']//preceding::input[1]");
			PlaywrightAssertions.assertThat(interset).isEnabled();
			interset.click();

			p.locator("//input[@value='Female']").click();

			Locator state = p.locator("//select[@name='state']");
			state.selectOption("Tamil Nadu");

			Locator hobbies = p.locator("//select[@id='hobbies']");
			String[] arr = { "Swimming", "Dancing", "Playing" };
			hobbies.selectOption(arr);

			p.locator("//button[text()='Sign up']").click();
			System.out.println("Successfully login");

			// check successfully sign up

			PlaywrightAssertions.assertThat(p.locator("//div[contains(text(),'Signup successfully, Please login!')]"));

			// after sign up

			p.getByPlaceholder("Enter Email").fill("jkkeerthana10@gmail.com");
			p.locator("css=input[name='password1']").fill("Itsmejk@2002");
			p.locator("xpath=//button[@class='submit-btn']").click();
			p.getByAltText("menu").click();
			p.getByText("Sign out").click();
			PlaywrightAssertions.assertThat(p).hasURL(Pattern.compile("login"));
			System.out.println("successfully logout");
		} finally {
			browser.close();
		}
	}

}
