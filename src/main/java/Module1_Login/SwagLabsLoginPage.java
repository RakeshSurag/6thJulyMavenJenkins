package Module1_Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLoginPage 
{
	@FindBy(xpath="//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath="//input[@id='password']") private WebElement PWD;
	@FindBy(xpath="//input[@id='login-button']") private WebElement Login;
	
	public SwagLabsLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void inpUsername(String username) throws IOException, InterruptedException
	{
		UN.sendKeys(username);
		Thread.sleep(1500);
	}
	
	public void inpPassword(String password) throws IOException, InterruptedException
	{
		PWD.sendKeys(password);
		Thread.sleep(1500);
	}
	
	public void clickLoginBtn()
	{
		Login.click();
	}
}
