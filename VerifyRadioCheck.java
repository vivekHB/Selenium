package com.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyMultipleCheckboxes {
	
    public static void main(String[] args) {
    	
        WebDriver driver = new FirefoxDriver();
        driver.get("https://apps.fas.usda.gov/esrquery/esrq.aspx");
      
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        
        System.out.println(checkBoxes.size());
        
        for(int i=0; i<checkBoxes.size(); i++)
        {
            checkBoxes.get(i).click();
            if(checkBoxes.get(i).isSelected()){
            	 System.out.println("checkBoxe is selected ");
                 
            }else{
           	 System.out.println("checkBoxe is not selected "); 
            } 
        }
    }
}
