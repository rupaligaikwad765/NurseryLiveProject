package testCase; 
import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage1;

import testBase.WebTestBase;

public class TC_01 extends WebTestBase{
	//each class is created for each web page
	LoginPage loginpage;
	HomePage homepage;
	MyAccountPage1 MAP;
	
	
	//create constructor in loading the config file 
		public TC_01() {
			//parent class cunstrutor call means loading property file or config.property file
			super();
		}
		
		@BeforeMethod //it will called only once before all the test cases are called
		public void BeforeMethod() {
			//loading the driver file and establish  the connection,loading the url
			initialization();
			loginpage=new LoginPage();
			homepage =new HomePage();
			MAP =new MyAccountPage1();
			
			
		}
		//for testing the login credentials
		//first test case==>checking the login credentials
		@Test(priority=1)
		public void verifyLoginWithValidcredential() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();//softassert generally used for checking condition 
		     homepage.userSearchClick();//login will be clicked
		     loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		     softAssert.assertEquals(MAP.getTextOFMYAccountPage1(), "Login", "My Account text should be match");
		     softAssert.assertAll();
		  System.out.println("verify");
		     
		}
		@Test(priority=2)
		public void verifySearchBar() throws InterruptedException{
		     SoftAssert softAssert = new SoftAssert();
		     MAP.search();
		     System.out.println(MAP.getTextOfSearch());
		     softAssert.assertEquals(MAP.getTextOfSearch(),"Showing 239 results for \"Winter Flowering Plants\"" );
		     softAssert.assertAll();
		    
		 }
		
		@Test(priority=3)  //mouse hovering on the user
		public void verifyMouseHover(){
		     SoftAssert softAssert = new SoftAssert();
		   MAP.mouseHover();
		     softAssert.assertAll();
		 }
		@Test(priority=4)
		public void verifyScrollDown() {
			JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
			javascriptExecutor.executeScript("window.scrollBy(0,2000)");
		}
		@Test(priority=5)
		public void verifyScrollup() {
			JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
			javascriptExecutor.executeScript("window.scrollBy(0,2000)");
		}
		@Test(priority=6)
		 public void verifyScreenshot() throws IOException{
		     SoftAssert softAssert = new SoftAssert();
		     MAP.getScreenshot();
		     softAssert.assertAll();
		 }
		@Test(priority=7)  
		 public void verifyGetWindowHandle() throws InterruptedException{
		     SoftAssert softAssert = new SoftAssert();
		     MAP.windowHandle();
		     softAssert.assertAll();
		 }		
		@Test(priority=8)  
		public void verifyCookiesHandle(){
		     SoftAssert softAssert = new SoftAssert();
		    MAP.getCookiesHandle();
		     softAssert.assertAll();
		 }
		@Test(priority=9)
		 public void verifyBrokenLink() throws IOException{
		     SoftAssert softAssert = new SoftAssert();
		     MAP.getBrokenLink();
		     softAssert.assertAll();
		 }
		
		@AfterMethod
		public void afterMethod() {
			
			driver.close();
	}

}
