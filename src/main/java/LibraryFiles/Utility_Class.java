package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility_Class 
{
	public static String getTD(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("D:\\ECLIPSE FOR JAVA\\ECLIPSE WORKSPACE\\6thJulySeleniumMaven\\TestData\\POMDDF.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value=sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("D:\\ECLIPSE FOR JAVA\\ECLIPSE WORKSPACE\\6thJulySeleniumMaven\\PropertyFile.properties");
		Properties obj = new Properties();
		obj.load(file);
		String value = obj.getProperty(key);
		return value;
	}
	
	public static void captureFailedSS(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\ECLIPSE FOR JAVA\\ECLIPSE WORKSPACE\\6thJulySeleniumMaven\\Screenshot\\FailedSS"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
}
