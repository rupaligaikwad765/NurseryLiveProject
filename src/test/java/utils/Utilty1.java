package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.WebTestBase;

public class Utilty1 extends WebTestBase {
	public static void selectValue(WebElement Element,String term,String value)
	{
		Select dropDown=new Select(Element);
		if(term.equalsIgnoreCase("byValue")){
            dropDown.selectByValue(value);
        }else if(term.equalsIgnoreCase("byIndex")){
            dropDown.selectByIndex(Integer.parseInt(value));
        }else if(term.equalsIgnoreCase("byVisibleText")){
            dropDown.selectByVisibleText(value);
        }else{
            System.out.println("What are you looking for?");
        }
	}

	public static void mouseHover(WebDriver driver, WebElement element){
        Actions action=new Actions(driver);
        action.moveToElement(element)
                .build()
                .perform();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   }
	
	public static void scrollDownByElement(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }
	
	public static void scrollUp(WebDriver driver) {
		
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(0,800)");
		javascriptExecutor.executeScript("window.scrollBy(0,-800)");
	}
	
	public static void switchToWindows(WebDriver driver) throws InterruptedException {
        String parentWindows = driver.getWindowHandle();//parent Id==1
        Set<String> allWindow = driver.getWindowHandles();//Parent+child<1,2>
        for (String s : allWindow) {
        	//child Id
            if (!parentWindows.contentEquals(s)) {
                driver.switchTo().window(s);
                Thread.sleep(10000);
                driver.close();
            }
           
        }
        driver.switchTo().window(parentWindows);
    }
	
	public static void getCookies(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies){
            System.out.println(c);
        }
    }
	public static void getScreenshot() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		//taking screenshot and storing it in the temporary file
		File source=tk.getScreenshotAs(OutputType.FILE);
		//creating destination file
		//File des=new File("D:/nurserylive.png");"./screenshots/" + fileName
		File des=new File("D:/nurserylive.png");
		//moving the file from source to destination
		FileUtils.copyFile(source,des);
		
	}
	
	public static void getBrokenLink() throws IOException {
		URL url=new URL("https://nurserylive.com/");
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		
		int code=con.getResponseCode();
		System.out.println(code);
		
		String msg=con.getResponseMessage();
		System.out.println(msg);
	}

	
	


}
