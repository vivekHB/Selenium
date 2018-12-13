package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		if(title.equals("OrangeHRM"))
		{
			System.out.println("Title Verified!!!!");
		}else
		{
			System.out.println("Title is Different from expected");
		}
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		

		Thread.sleep(5000);
		
		String welcome=driver.findElement(By.id("welcome")).getText();
		
		System.out.println(welcome);
		
		if(welcome.equals("Welcome Admin"))
		{
			System.out.println("Welcome page verified!!");
		}else {
			System.out.println("Welcome message is different from expected");
		}
		
		driver.findElement(By.id("welcome")).click();
	
			Thread.sleep(5000);
	
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[2]/a")).click();
		
		
		driver.close();
	}

}
