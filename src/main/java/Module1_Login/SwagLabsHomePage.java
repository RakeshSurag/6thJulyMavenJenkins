package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SwagLabsHomePage 
{
	@FindBy(xpath="//div[@class='app_logo']") private WebElement Logo;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement MenuBtn;
	
	public SwagLabsHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void verifyLogoText(String expLogoText) throws InterruptedException
	{
		String actLogoText = Logo.getText();
		Assert.assertEquals(actLogoText, expLogoText,"Failed: Both are different");
		Thread.sleep(2000);
	}
	
	public void clickMenuBtn()
	{
		MenuBtn.click();
	}
}
