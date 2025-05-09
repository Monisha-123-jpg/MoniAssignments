package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(options);
           
	        driver.get("http://leaftaps.com/opentaps/control/main/");
	        driver.manage().window().maximize();
	       String Title= driver.getTitle();
	       System.out.println(Title);
	       //input username
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
			//enter company name
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
			//enter name
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Monisha");
			//enter last name
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("B");
			
			//select employee using index
			WebElement sourceDd=driver.findElement(By.id("createLeadForm_dataSourceId"));
			Select select = new Select(sourceDd);
			select.selectByIndex(4);
			
			//createLeadForm_marketingCampaignId
			WebElement marketCampaign=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
			Select select1 = new Select(marketCampaign);
			select1.selectByVisibleText("Automobile");
			
			//select ownership
			WebElement ownerShip=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
			Select select2 = new Select(ownerShip);
			select2.selectByValue("OWN_CCORP");
			
			
		driver.findElement(By.name("submitButton")).click();
		System.out.println("create lead btn clicked");
			driver.close();


	}

}
