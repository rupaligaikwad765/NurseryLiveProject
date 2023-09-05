package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;

public class HomePage extends WebTestBase {
	//id for my accountin the home page
	@FindBy(linkText = "Login")
    WebElement usersearch;

	//creating web elements
	//initialising the page object
	
    public HomePage()
    {                                          //PageFactory==?>inbuild desing patter pouparly page object model
    	PageFactory.initElements(driver,this);           //PageFactory==>webpage to a web element
    }                                        //this==> alwaays refer to  create current object connected to driver
        
    //clicking my account
    public void userSearchClick(){
        usersearch.click();
    }
    
  

	
}
