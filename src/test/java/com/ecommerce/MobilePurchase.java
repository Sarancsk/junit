package com.ecommerce;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class MobilePurchase {
	
	static WebDriver driver;
	@BeforeClass
	
	public static void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\FlipkartJunit\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public static void closeBrowser() throws Exception {
		Thread.sleep(3000);
		
	driver.quit();
	
	}
	static long starttime;
	@Before
	public void beforeTest() {
		System.out.println("Before test");
		long starttime=System.currentTimeMillis();
	}
	@After
	public void afterTest() {
		System.out.println("After test");
		long endtime=System.currentTimeMillis();
		System.out.println(endtime-starttime);
		}
	
	
	
	
	@Test
	public void m1() {
		WebElement clseBtn = driver.findElement(By.xpath("//button[text()='✕']"));
		clseBtn.click();
		}
	@Test
	public void m2() {
		WebElement searchBtn =driver.findElement(By.xpath("//input[@type='text']"));
		searchBtn.sendKeys("mi mobiles");
	}
	static String name;
	@Test
	public void m3() throws IOException {
	
		WebElement searchclk=driver.findElement(By.xpath("//button[@type='submit']"));
		searchclk.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement phoneName=driver.findElement(By.xpath("(//div[contains(text(),'Redmi')])[1]"));
	    String name=phoneName.getText();
	    File f=new File("C:\\Users\\Admin\\eclipse-workspace\\FlipkartJunit\\ExcelSheet\\Redmi.xlsx");
		FileInputStream f1=new FileInputStream(f);
		XSSFWorkbook w =new XSSFWorkbook(f1);
		XSSFSheet s=w.getSheet("mobile");
		s.getRow(0).createCell(1).setCellValue(name);
		 FileOutputStream fs=new FileOutputStream(f);
		 w.write(fs);
		 fs.close();
		
	}
	

}
