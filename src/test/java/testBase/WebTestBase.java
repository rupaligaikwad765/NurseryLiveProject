package testBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public WebTestBase()
	{
		try
		{
			//reading the property file
			//user.dir==>it will take the current path
			
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//properties//config1.properties");
			prop = new Properties();
			//loading the property file
			prop.load(fileInputStream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void initialization()
	 {
		//for reading the property
        String browserName = prop.getProperty("browser");//chrome
        
        
        if (browserName.equals("chrome")){
        	//loading the driver
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/driver1/msedgedriver.exe");
            //ChromeOptions options = new ChromeOptions();		
            EdgeOptions options=new EdgeOptions();
    		options.addArguments("--remote-allow-origins=*");
    		//creating object for chrome driver 
    	     driver = new EdgeDriver(options);
    	     
    	   /*  WebDriverManager.chromedriver().setup();
    			System.setProperty("webdriver.http.factory", "jdk-http-client");
    			 driver=new ChromeDriver();*/
    	     
    	    driver.navigate().to(prop.getProperty("url"));//loading url
           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
           driver.manage().deleteAllCookies();
        }
	 }


}
