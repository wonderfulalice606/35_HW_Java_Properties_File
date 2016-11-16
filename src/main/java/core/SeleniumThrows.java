package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumThrows {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String test_case = null;
		String url = null;
		String title_expected_result = null;

		Properties properties = new Properties();

		properties.load(new FileInputStream("./src/main/resources/Test.properties"));

		test_case = properties.getProperty("test_case");
		url = properties.getProperty("url");
		title_expected_result = properties.getProperty("title_expected_result");

		WebDriver driver = new FirefoxDriver();

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();

		if (title_expected_result.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + test_case);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected_result);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + test_case);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected_result);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
		driver.quit();
	}
}
