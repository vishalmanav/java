package com.bold.learnjava;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switchtabs {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		/*Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_T);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_T);*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//a[@id='loginsubmit']")).click();

		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterate = winids.iterator();
		
		String firstWindow = iterate.next();
		String secondWindow = iterate.next();
		
		System.out.println(firstWindow);
		System.out.println(secondWindow);
		
		driver.switchTo().window(secondWindow);
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='benefits']/a[2]"))).click();
				//driver.findElement(By.cssSelector(".row > .col-md-3:nth-child(1)>.benefits>a")).click();
		driver.findElement(By.xpath("//div[@class='col-md-3 col-sm-6'][last()-3]/div/a")).click();
		
		driver.findElement(By.xpath("//div[@class='col2']/p[3]/a")).click();
		
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		
		 firstWindow = iterate.next();
		 secondWindow = iterate.next();
		String thirdWindow = iterate.next();
		
		driver.switchTo().window(thirdWindow);
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().defaultContent();
		
		System.out.println(driver.getTitle());
		driver.quit();
		
				
	}

}
