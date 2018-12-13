package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		
		//Open Fire fox Browser
		WebDriver driver=new FirefoxDriver();
		
		//Open URL In Browser
		driver.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		//Get the Title of WebPage
		String title=driver.getTitle();
		
		//print the title of the web page
		System.out.println(title);
		
		//Verify Title of WebPage
		if(title.equals("OrangeHRM"))
		{
			System.out.println("Title Verified!!!!");
		}else
		{
			System.out.println("Title is Different from expected");
		}
		
		//Enter the user name
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		//Enter the password
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		
		//Clicking On Login Button
		driver.findElement(By.id("btnLogin")).click();
		
		
		

		Thread.sleep(5000);
		
		//Identify Welcome selenium
		String welcome=driver.findElement(By.id("welcome")).getText();
		
		//Print welcome message
		System.out.println(welcome);
		
		//To verify whether the welcome page successfully opened or not
		if(welcome.equals("Welcome Admin"))
		{
			System.out.println("Welcome page verified!!");
		}else {
			System.out.println("Welcome message is different from expected");
		}
		
		//click logout
		driver.findElement(By.id("welcome")).click();
	
			Thread.sleep(5000);
	
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[2]/a")).click();
		
		
		driver.close();
	}

}
