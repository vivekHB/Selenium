package com.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyCheckbox {
	public static void main(String[] args) throws InterruptedException{

		WebDriver driver= new FirefoxDriver();
		
		driver.get("http://demo.guru99.com/v4/");


		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mngr77331");


		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("jugYzEz");
	

		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("html/body/div[2]/div/ul/li[15]/a")).click();
		Thread.sleep(5000);

		String alert_text=driver.switchTo().alert().getText();

		System.out.println("Print alert text   :"+alert_text);

		if(alert_text.equals("You Have Succesfully Logged Out!!"))
		{
			System.out.println("alert text verified successfully");
		}else
		{
			System.out.println("alert text not verified successfully");
		}


		driver.switchTo().alert().accept();

		Thread.sleep(5000);
		driver.close();
	
	}

}