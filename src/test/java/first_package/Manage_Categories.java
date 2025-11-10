package first_package;

import java.nio.file.Path;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Manage_Categories {

	public static void main(String[] args) throws InterruptedException {
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page p = browser.newPage();
		p.navigate("https://freelance-learn-automation.vercel.app/login");
		p.getByPlaceholder("Enter Email").fill("admin@email.com");
		p.getByPlaceholder("Enter Password").fill("admin@123");
		p.locator(".submit-btn").click();
		p.locator("//span[text()='Manage']").hover();
		p.locator("//a[@href='/course/manage']").click();
		p.locator("//button[text()='Add New Course ']").click();
		p.locator("//input[@id='thumbnail']").setInputFiles(Path.of("C:\\Users\\91894\\Downloads\\quotes.png"));
		p.locator("#name").fill("Playwright");
		p.locator("#description").fill("It is very easy");
		p.locator("#instructorNameId").fill("Keerthana");
		p.locator("#price").fill("1000");
		p.locator("//input[@name='startDate']").fill("11/11/2028");
		p.locator("//input[@name='endDate']").fill("04/11/2029");
		p.locator("//div[text()='Select Category']").click();
		p.locator("//button[text()='SQL']").click();
		p.locator("//button[text()='Save']").click();

		Thread.sleep(10000);
		Locator rows = p.locator("//div[@class='table-responsive']//tr");
		int r = rows.count();

		for (int i = 1; i < r; i++) {
			String t = rows.nth(i).textContent();

			if (t.contains("Playwright")) {
				System.out.println("test passed " + i);
				rows.nth(i).locator("xpath=.//td[last()]//button").click();
				System.out.println("clicked successfully");
				break;
			}

		}

		p.close();
		browser.close();

	}

}
