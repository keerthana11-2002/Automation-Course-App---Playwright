package first_package;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Practice {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page p = browser.newPage();
		p.navigate("https://freelance-learn-automation.vercel.app/login");
		p.locator("xpath = //button[text()='Sign in']").click();
		
		PlaywrightAssertions.assertThat(p.locator(".errorMessage")).hasText("Email and Password is required");
		System.out.println("without entering email and password");
		
		 p.getByPlaceholder("Enter Email").fill("jkkeerthana10@gmail.com");
			p.locator("xpath = //button[text()='Sign in']").click();
			
			PlaywrightAssertions.assertThat(p.locator(".errorMessage")).hasText("Password is required");
			System.out.println("without entering password");


		
		browser.close();
		pw.close();

	}

}
