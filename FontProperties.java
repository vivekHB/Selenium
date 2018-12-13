package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class GetCssfontsizecolor {
	 public static void main(String[] a) {  
	     WebDriver driver = new FirefoxDriver(); 


	     driver.get("https://www.google.com/"); 


	    String  font_name = driver.findElement(By.linkText("Gmail")).getCssValue("font-family");  
	     System.out.println("font-family : " + font_name);  
	     Assert.assertEquals("arial,sans-serif", font_name);
	     System.out.println("font_name is verified");
	     System.out.println();
	  
	     String  font_size = driver.findElement(By.linkText("Gmail")).getCssValue("font-size");  
	     System.out.println("font-size : " + font_size);  
	     Assert.assertEquals("13px", font_size);
	     System.out.println("font_size is verified");
	     System.out.println();


	     String font_color = driver.findElement(By.linkText("Gmail")).getCssValue("color");  
	     System.out.println("font-color : " + font_color);  
	     Assert.assertEquals("rgba(0, 0, 0, 1)", font_color);
		 System.out.println("font_color is verified");
	     driver.close();  
	   }  
}
