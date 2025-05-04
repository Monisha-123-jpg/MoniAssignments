package week2.day1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

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
				
				//click lead
				driver.findElement(By.linkText("Leads")).click();
				
				//click create lead
				driver.findElement(By.linkText("Create Lead")).click();
				
				//enter name
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Monisha");
				//enter last name
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("B");
				
				//enter company name
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
				
				//enter title
				driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("LeafTap");
				
				//click create lead
				driver.findElement(By.xpath("//input[@type='submit']"));
				String title =driver.getTitle();
				
				System.out.println("title of page is--"+title);
				
				driver.close();
				
				

	}

}
