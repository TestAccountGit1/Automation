package com.testing;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class Testing {
	static WebDriver driver;
    @Test
	public void launchBrowser() throws Exception{
    	for(int i=0;i<=1;i++) {
    		if(i==0) {
    	ChromeOptions option1 = new ChromeOptions();
    	option1.addArguments("--disable-notification");
    	option1.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		 driver = new ChromeDriver(option1);
		 automationTesting();
		
    		}
    		if(i==1) {
    			driver = new FirefoxDriver();
    			automationTesting();
    		}
    	}}
    
         
    	public static void automationTesting() throws Exception{
    	driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement radio = driver.findElement(By.xpath("//input[@value='radio3']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(radio));
		
		radio.click();
		
		
		String country = "india";
		
		WebElement entry = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		 
	      entry.sendKeys(country);
		 String text1 = new String("Option1");
	      WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
	      Select s1 = new Select(dropDown);
	      List<WebElement> option = s1.getOptions();
	      for(WebElement d1 : option) {
	    	  if(d1.getText().equalsIgnoreCase(text1)) {
	    		  d1.click();
	    	  }
	      }
	      
	      driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
	      driver.findElement(By.xpath("//button[@id='openwindow']")).click();
	      String currentWindow = driver.getWindowHandle();
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 
		 while(it.hasNext()) {
			 String win = it.next();
			 if(!win.equalsIgnoreCase(currentWindow)) {
				 driver.switchTo().window(win);
			 }
		 }
		 
		 System.out.println(driver.getCurrentUrl());
		 driver.close();
		 driver.switchTo().window(currentWindow);
		 
		 Thread.sleep(200);
		 driver.findElement(By.xpath("//a[@id='opentab']")).click();
		  windows = driver.getWindowHandles();
		  Iterator<String> it1 = windows.iterator();
		  while(it1.hasNext()) {
				 String win = it1.next();
				 if(!win.equalsIgnoreCase(currentWindow)) {
					 driver.switchTo().window(win);
				 }
			 }
		  
		  Thread.sleep(500);
		  WebElement mail = driver.findElement(By.xpath("(//span[text()='info@qaclickacademy.com'])[2]"));
		  Assert.assertEquals(mail.getText(),"info@qaclickacademy.com");
		  driver.close();
		  driver.switchTo().window(currentWindow);
		  
		  driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("Testing");
		  driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		  
		  Alert a1 = driver.switchTo().alert();
		  a1.accept();
		  Thread.sleep(500);
		  driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		  a1 = driver.switchTo().alert();
		  a1.dismiss();
		  
		  WebElement table1 = driver.findElement(By.xpath("//table[@id='product']"));
		  List<WebElement> rows = table1.findElements(By.tagName("tr"));
		  
			  for(WebElement row :rows) {
				  List<WebElement> column = row.findElements(By.tagName("td"));
				  for (WebElement column1 : column) {
					  String cellText = column1.getText();
					  System.out.println("Cell Text: " + cellText);
				  
			  }
		  }
		 
		driver.close();
		driver.quit();
		
    		}
	}
	

