package first_package;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ManageCategories1 {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext context = browser.newContext();
		Page p = context.newPage();
		p.navigate("https://freelance-learn-automation.vercel.app/login");
		p.getByPlaceholder("Enter Email").fill("admin@email.com");
		p.getByPlaceholder("Enter Password").fill("admin@123");
		p.locator(".submit-btn").click();
		p.locator("//span[text()='Manage']").hover();

		Page newPage = context.waitForPage(() -> {
			p.locator("//a[@href='/category/manage']").click();

		});
		p.bringToFront();
		p.locator("//span[text()='Manage']").hover();
		p.locator("//a[@href='/course/manage']").click();
		newPage.bringToFront();
		
	

	}

}
