package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		//enter username and pwd
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//click login
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		//click crm link
		driver.findElement(By.partialLinkText("CRM")).click();
		//click on create acc
		driver.findElement(By.linkText("Accounts")).click();
				
		//Create Account
		driver.findElement(By.linkText("Create Account")).click();
		
		//entering account name
		driver.findElement(By.id("accountName")).sendKeys("Monisha");
		
		//entering description
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester." );
		
		//enter industry
		WebElement  industryBox=driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		Select select= new Select(industryBox);
		select.selectByVisibleText("Computer Software");
		
		//ownershipEnumId
		WebElement  ownershipBox=driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
		Select owner= new Select(ownershipBox);
		owner.selectByVisibleText("S-Corporation");
		
		//enter source
		WebElement  sourceBox=driver.findElement(By.xpath("//select[@id='dataSourceId']"));
		Select selectSource= new Select(sourceBox);
		selectSource.selectByValue("LEAD_EMPLOYEE");
		
		//enter marheting compaign   marketingCampaignId
		
		WebElement  marketingCampaign=driver.findElement(By.xpath("//select[@id='marketingCampaignId']"));
		Select selectMc= new Select(marketingCampaign);
		selectMc.selectByIndex(6);
		
		//select state /province
		WebElement  stateProvince=driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
		Select selectState= new Select(stateProvince);
		selectState.selectByValue("TX");
		
		
		
		String title=driver.getTitle();
	    System.out.println(title);
		//clicking on create account
		driver.findElement(By.xpath("//input[@type='submit']"));
		driver.close();
		
        

	}

}
