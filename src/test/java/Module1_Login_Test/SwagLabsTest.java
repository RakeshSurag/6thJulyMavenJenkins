package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.Utility_Class;
import Module1_Login.SwagLabsHomePage;
import Module1_Login.SwagLabsLoginPage;
import Module1_Login.SwagLabsMenuPage;

public class SwagLabsTest extends BaseClass
{
	SwagLabsLoginPage login;
	SwagLabsMenuPage menu;
	SwagLabsHomePage home;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		initializeBrowser();
	}
	
	@BeforeMethod
	public void loginToApp() throws IOException, InterruptedException
	{
		login=new SwagLabsLoginPage(driver);
		login.inpUsername(Utility_Class.getPFData("UN"));
		login.inpPassword(Utility_Class.getPFData("PWD"));
		login.clickLoginBtn();
	}
	
	@Test
	public void verifyLogoText() throws EncryptedDocumentException, InterruptedException, IOException
	{
		home = new SwagLabsHomePage(driver);
		home.verifyLogoText(Utility_Class.getTD(0, 2));
		Thread.sleep(1500);
		
	}
	
	@AfterMethod
	public void logoutApp(ITestResult itr) throws InterruptedException, IOException
	{
		TCID=1;
		if(itr.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.captureFailedSS(driver, TCID);
		}
		home.clickMenuBtn();
		menu= new SwagLabsMenuPage(driver);
		menu.clickLogout();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(1500);
		driver.quit();
	}
	
}
