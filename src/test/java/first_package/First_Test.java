package first_package;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class First_Test {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page = browser.newPage();
		page.navigate("https://www.facebook.com");
		String url = page.url();
		System.out.println("The url : " + url);
		page.close();
		browser.close();
		pw.close();
	}

}
