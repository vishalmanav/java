package com.bold.learnjava;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TakescreenShot {

	public static WebDriver driver;
	public static String browser = "chrome";
	public static WebDriverWait wait;
	public static Set<String> handles ;
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			wait = new WebDriverWait(driver, 5);

			driver.get("http://hdfcbank.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Thread.sleep(5000);

			Takescreenshot();

			driver.findElement(By.id("loginsubmit")).click();

			//Switch after click on login button
			switchwindow();

			// wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='container']/div[@class='pdtb25
			// text-center']/a")))).click();

			// driver.findElement(By.xpath("//div[@class='container']/div[@class='pdtb25
			// text-center']/a")).click();
			Thread.sleep(5000);

			//click on  known more button after switch 
			driver.findElement(By.xpath("//div[@class='col-md-3 col-sm-6'][last()-3]/div/a")).click();
			//click on click here on jet privilage page
			driver.findElement(By.xpath("//div[@class='col2']/p[3]/a")).click();
			switchwindow();

		} finally {
			driver.quit();
		}

	}

	public static void Takescreenshot() throws IOException 
	{

		Date d = new Date();
		String newdate = d.toString().replace(" ", "_").replace(":", "_");
		System.out.println(newdate);

		JavascriptExecutor je = ((JavascriptExecutor) driver);
		je.executeScript("document.getElementById('loginsubmit').style.backgroundColor='args[0]'", "#000000");

		TakesScreenshot srnshot = ((TakesScreenshot) driver);
		File srcfile = srnshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("D:\\Screenshot\\shot " + newdate + ".jpg"));

	}

	public static void switchwindow() {
		String currentWindow = driver.getWindowHandle();
		System.err.println("Current Window id " + currentWindow);
		handles = driver.getWindowHandles();
		ArrayList<String> windowHandles = new ArrayList<String>(handles);

		for (int i = 0; i < windowHandles.size(); i++) {
				if (!windowHandles.get(i).equals(currentWindow)) {
					driver.switchTo().window(windowHandles.get(windowHandles.size()-1));
					System.out.println(driver.getTitle());
					break;
			}
		}

		/*
		 * String firstWindow = handle.iterator().next(); String secondWindow =
		 * handle.iterator().next(); driver.switchTo().window(secondWindow);
		 * System.out.println(driver.switchTo().window(secondWindow).getTitle())
		 * ;
		 * 
		 * System.out.println("First window id is " + firstWindow);
		 * System.out.println("First window id is " + secondWindow);
		 */
		// driver.getTitle();

	}

}
