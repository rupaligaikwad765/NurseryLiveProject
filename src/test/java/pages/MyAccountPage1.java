package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;

import utils.Utilty1;

public class MyAccountPage1 extends WebTestBase {
	@FindBy(xpath = "//*[@id=\'shopify-section-static-header\']/div[1]/div[2]/ul/li/a")
    WebElement accountTitle;
	
	 @FindBy(xpath = "//*[@id=\'shopify-section-static-header\']/div[1]/div[1]/div[2]/form/div[1]/input")
	    WebElement searchTextBox;

	    @FindBy(xpath = "//*[@id='shopify-section-static-header']/div[1]/div[1]/div[2]/form/div[1]/button[2]")
	    WebElement searchBtn;

	    @FindBy(xpath = "//*[@id=\"snize_results\"]/div[2]")
	    WebElement searchTitle;   
	    
	    @FindBy(xpath = "")
	    WebElement dropDown;
	
	    @FindBy(xpath = "//*[@id=\'shopify-section-static-header\']/div[1]/div[1]/div[2]/form/div[1]/span/select")
	    WebElement hover;

	    @FindBy(xpath = "//*[@id=\"shopify-section-static-footer\"]/footer/section/div[1]/div/div[4]/div/div/a[5]")
	    WebElement youtubeOption;
	    
	  
	public MyAccountPage1(){
        PageFactory.initElements(driver, this);
    }
	
	public String getTextOFMYAccountPage1(){
        return accountTitle.getText();
    }
	
	public void search() throws InterruptedException{
        //searchTextBox.click();
        searchTextBox.sendKeys("Winter Flowering Plants");
       searchTextBox.sendKeys(Keys.ENTER);
        //searchBtn.click();
        Thread.sleep(10000);     
    }
	public void selectDropDown(String term,String value) {
		dropDown.click();
		Utilty1.selectValue(dropDown,term,value);
	}
		
	public String getTextOfSearch() {
		//geting the result of search text
		return searchTitle.getText();
		
	}
	

	public void mouseHover() {
		Utilty1.mouseHover(driver,hover);
	}
	public void scrollDownMethod() {
		// TODO Auto-generated method stub
		Utilty1.scrollDownByElement(driver,youtubeOption);
		youtubeOption.click();
		
	}	
	public void windowHandle() throws InterruptedException{
        Utilty1.scrollDownByElement(driver,youtubeOption);
        youtubeOption.sendKeys(Keys.ENTER);
        Utilty1.switchToWindows(driver);
    }
	public void getScreenshot() throws IOException {
		Utilty1.getScreenshot();
	}
	public void getBrokenLink() throws IOException {
		Utilty1.getBrokenLink();
	}
	
	public void getCookiesHandle() {
		// TODO Auto-generated method stub
		Utilty1.getCookies();
	}

	}
