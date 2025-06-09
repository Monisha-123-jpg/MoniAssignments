package week6.marathon3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	
	public String FileName;
	public RemoteWebDriver driver;
	@Parameters({"url","username","password"})
     @BeforeMethod
	public  void preConditions(String url,String uName,String pwd) throws Exception {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(uName);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.id("Login")).click();
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        
	}

     
     @AfterMethod
 	public void postConditions() {
 		driver.close();
}
     
         @DataProvider(name="sendData")
         public String[][] sendData() throws Exception {
        	 return ReadFromExcelNew.readData(FileName);
	
}
}
