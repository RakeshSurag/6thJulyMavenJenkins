package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsMenuPage 
{
	@FindBy(xpath="//a[@id='logout_sidebar_link']") private WebElement Logout;
	
	public SwagLabsMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickLogout() throws InterruptedException
	{
		Thread.sleep(1500);
		Logout.click();
	}
}
