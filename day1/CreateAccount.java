package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {

	public static void main(String[] args) {
		// for handling browser pop up
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(options);
		
		//launching url
        driver.get("http://leaftaps.com/opentaps/control/main/");
        driver.manage().window().maximize();
        
        //entering credentials
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
        //input pwd
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		
		//click on login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//click on Crm link
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//click on create acc
		driver.findElement(By.linkText("Accounts")).click();
		
		//Create Account
		driver.findElement(By.linkText("Create Account")).click();
		
		//entering account name
		driver.findElement(By.id("accountName")).sendKeys("Monisha");
		
		//entering description
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester." );
		
		//numberEmployees
		driver.findElement(By.id("numberEmployees")).sendKeys("100");
		
		//officeSiteName
 	    WebElement officeSiteName = driver.findElement(By.id("officeSiteName"));
 	    officeSiteName.sendKeys("LeafTap");
 	    System.out.println("entered officesite name----");
 	    
	    //clicking on create account
		driver.findElement(By.xpath("//input[@type='submit']"));
		driver.close();
		
       
        
	}

}
