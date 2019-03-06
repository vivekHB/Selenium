package VivekDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class OrangeHRMDemo {

	public static void main(String[] args) throws InterruptedException, WriteException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\snehakulakarni\\Desktop\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
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
		
		driver.findElement(By.id("welcome")).click();
	
			Thread.sleep(5000);
	
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[2]/a")).click();

		
		driver.navigate().to("https://mail.yahoo.com/");
		
		driver.findElement(By.id("login-username")).sendKeys("Bazzingamad@yahoo.com");
		driver.findElement(By.id("login-signin")).click();
		//driver.close();
		readExcel();
		setValueIntoCell("Sheet1",0, 0,"Total Number Of TestCases");
		setValueIntoCell("Sheet1",0, 1,"1");
		setValueIntoCell("Sheet1",1, 0,"TestCases Passed");
		setValueIntoCell("Sheet1",1, 1,"1");
		setValueIntoCell("Sheet1",2, 0,"TestCases Failed");
		setValueIntoCell("Sheet1",2, 1,"0");
		closeFile();
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



