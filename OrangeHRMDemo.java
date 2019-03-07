package VivekDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class OrangeHRMDemo {
	static int TCCount;
	static int TCPass;
	static int TCFail;

	public static void main(String[] args) throws InterruptedException, WriteException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\snehakulakarni\\Desktop\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Robot robot = new Robot();
		TCCount=TCCount+1;
		TCPass=0;
		TCFail=0;
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		//TEST CASE 1
		
		
		if(title.equals("OrangeHRM"))
		{
			System.out.println("Title Verified!!!!");
			TCPass=TCPass+1;
		}else
		{
			System.out.println("Title is Different from expected");
			TCFail=TCFail+1;
		}
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		
		String welcome=driver.findElement(By.id("welcome")).getText();
		
		System.out.println(welcome);
		
		if(welcome.equals("Welcome Admin"))
		{
			System.out.println("Welcome page verified!!");
			
		}else {
			System.out.println("Welcome message is different from expected");
		}
		
		
		
		
		//TEST CASE 2
		TCCount=TCCount+1;
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("btnAdd")).click();
		Select user = new Select(driver.findElement(By.id("systemUser_userType")));
		user.selectByIndex(1);
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Linda Anderson");
		driver.findElement(By.id("systemUser_userName")).sendKeys("Linda");
		driver.findElement(By.id("systemUser_password")).sendKeys("linda123");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("linda123");
		driver.findElement(By.id("btnSave")).click();
		if(driver.findElement(By.id("searchSystemUser_userName"))!= null)
				{
					System.out.println("Sucessfully created User");
					TCPass=TCPass+1;
				}
		else
		{
			System.out.println("Failed to created User");
			TCFail=TCFail+1;
		}
		
		
		driver.findElement(By.id("welcome")).click();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[2]/a")).click();
	
		
		
		
		
		driver.navigate().to("https://mail.yahoo.com/");
		
		driver.findElement(By.id("login-username")).sendKeys("Bazzingamad@yahoo.com");
		driver.findElement(By.id("login-signin")).submit();
		Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys("vivek123");
		readExcel();
		setValueIntoCell("Sheet1",0, 0,"Total Number Of TestCases");
		setValueIntoCell("Sheet1",0, 1,""+TCCount);
		setValueIntoCell("Sheet1",1, 0,"TestCases Passed");

		robot.keyPress(KeyEvent.VK_ENTER);
		
		setValueIntoCell("Sheet1",1, 1,""+TCPass);
		setValueIntoCell("Sheet1",2, 0,"TestCases Failed");
		setValueIntoCell("Sheet1",2, 1,""+TCFail);
		closeFile();
		

		
		Thread.sleep(5000);
		driver.findElement(By.linkText("Compose")).click();
		
		driver.findElement(By.id("message-to-field")).sendKeys("kulkarniksneha@gmail.com");
		
		driver.findElement(By.cssSelector("input[type='file']")).click();
		
		System.out.println("Select the path of the report   Y|N:");
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		@SuppressWarnings("unused")
		String z = s.next();
		
			driver.findElement(By.cssSelector("button[title='Send this email']")).click();
		driver.close();
		
	}
	
	
		
		static Workbook wbook;
	    static WritableWorkbook wwbCopy;
	    static String ExecutedTestCasesSheet;
	    static WritableSheet shSheet;
	    
	    public static void readExcel()
	    {
	    try{
	    	wbook = Workbook.getWorkbook(new java.io.File("C:\\Users\\snehakulakarni\\Desktop\\Driver\\Excel\\Copy Book.xls"));
	    wwbCopy = Workbook.createWorkbook(new java.io.File("C:\\Users\\snehakulakarni\\Desktop\\Driver\\Excel\\Report.xls"),wbook);
	    shSheet = wwbCopy.getSheet(0);
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    }
	    
	    public static void setValueIntoCell(String strSheetName,int iColumnNumber, int iRowNumber,String strData) throws WriteException
	    {
	        WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
	        Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
	                
	        try {
	            wshTemp.addCell(labTemp);
	             } 
	            catch (Exception e) 
	            {
	                e.printStackTrace();
	            }
	    }
	    
	    public static void closeFile()
	    {
	        try {
	            // Closing the writable work book
	            wwbCopy.write();
	            wwbCopy.close();

	            // Closing the original work book
	            wbook.close();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	        
	        
	        
	        
	        
	        
	        
	        

	}



