package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;

public class LoginPage extends WebTestBase {
	 @FindBy(xpath = "//*[@id=\"oxi_loginform_popup\"]/div[1]/div[1]/span/input")
	    WebElement emailTextBox;

	    @FindBy(xpath = "//*[@id=\"oxi_loginform_popup\"]/div[1]/div[2]/span/input")
	    WebElement passwordTextBox;

	    @FindBy(xpath = "//*[@id=\"oxi_loginform_popup\"]/div[2]/button/span/span")
	    WebElement loginbtn;

	    public LoginPage(){
	    	//used for creating webelements
	        PageFactory.initElements(driver, this);
	    }
//sending the mobileno and passwrord to the login
	    public void login(String email, String password) throws InterruptedException{
	        emailTextBox.sendKeys(email);
	        passwordTextBox.sendKeys(password);
	        Thread.sleep(10000);
	        loginbtn.click();
	    }


}
