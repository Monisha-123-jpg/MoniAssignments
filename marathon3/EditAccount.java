package week6.marathon3;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class EditAccount extends BaseClass  {
	
	@BeforeTest
	public void dataVal() {
		FileName="Saleeditacc";
	}

 @Test(dataProvider="sendData")

   public void runEditAcc(String billingStreet,String ShippingStreet) throws Exception {
     
        WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
        driver.executeScript("arguments[0].click()",accountsTab);
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Gokul"+ Keys.ENTER);//excel
        Thread.sleep(3000);
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]//a[@role='button']")).click();
        driver.findElement(By.xpath("(//ul[@role='presentation'])[3]//a[@title='Edit']")).click();
        WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
        driver.executeScript("arguments[0].click()",typeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Technology Partner']")).click();
        WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        driver.executeScript("arguments[0].click()",industryDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
        WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        biilingStreet.clear();
        biilingStreet.sendKeys(billingStreet);//excel
        WebElement shippingStreet = driver.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea"));
        shippingStreet.clear();
        shippingStreet.sendKeys(ShippingStreet);//excel
        WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
        driver.executeScript("arguments[0].click()",priorityDD);
        driver.findElement(By.xpath("//span[text()='Low']")).click();
        driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
        driver.findElement(By.xpath("//span[text()='Silver']")).click();
        WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
        driver.executeScript("arguments[0].click()",activeDD);
        driver.findElement(By.xpath("//span[text()='No']")).click();
        int randomNum1 = (int)(Math.random()*999999);
        int randomNum2 = (int)(Math.random()*999999);
        String phno = ""+randomNum1+randomNum2;
        phno = phno.substring(0,10);
        System.out.println("phno is--"+phno);
        Thread.sleep(5000);
        WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
        phnoField.clear();
        phnoField.sendKeys(phno);
        Thread.sleep(3000);
        WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
        driver.executeScript("arguments[0].click()",upsellOpportunityDD);
        driver.findElement(By.xpath("//span[text()='No']")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        Thread.sleep(3000);
        String phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]//span[@dir='ltr']")).getText();
        System.out.println("ph str is---"+phnoStr);
        Assert.assertTrue(phnoStr.contains(phno),"verify the mobileNumber");



    }

}
