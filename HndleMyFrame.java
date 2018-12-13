package framepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HndleMyFrame {

	public static void main(String[] args) {
		
		//Open Firefox Driver
		WebDriver driver=new FirefoxDriver();
		
		//Open URL in Web Browser
		driver.navigate().to("http://demo.guru99.com/test/guru99home/");
		
		//
		
	}

}
