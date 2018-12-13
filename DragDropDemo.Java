package com.selenium.UtilityFiles;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {

	 public static void main(String[] args) {
	  
	  WebDriver driver = new FirefoxDriver();

	  driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

	  WebElement draggable = driver.findElement(By.xpath("//*[@id='draggable']"));

	  WebElement droppable = driver.findElement(By.xpath("//*[@id='droppable']"));

	  Actions oAction = new Actions(driver);

	  oAction.dragAndDrop(draggable, droppable).perform();

	 String dropped_text= driver.findElement(By.xpath("//*[@id='droppable']/p")).getText();

	  if(dropped_text.equals("Dropped!"))
	  {
		  System.out.println("dragAndDrop operation   is verified successfully");
	  }else
	  {
		  System.out.println("Dropped! text is not verified successfully");
	  }
  
  
	  driver.close();
	}
}
