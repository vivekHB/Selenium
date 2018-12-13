package ExcelDrive;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WorkingOnExcel {
	static Workbook wbook;
    static WritableWorkbook wwbCopy;
    static String ExecutedTestCasesSheet;
    static WritableSheet shSheet;
    
    public void readExcel()
    {
    try{
    wbook = Workbook.getWorkbook(new java.io.File("C:\\Users\\madirajusv\\Desktop\\Testing Training\\Test data\\Excel.xls"));
    wwbCopy = Workbook.createWorkbook(new java.io.File("C:\\Users\\madirajusv\\Desktop\\Testing Training\\Test data\\testSampleDataCopy.xls"), wbook);
    shSheet = wwbCopy.getSheet(0);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
    
    public void setValueIntoCell(String strSheetName,int iColumnNumber, int iRowNumber,String strData) throws WriteException
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
    
    public void closeFile()
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

