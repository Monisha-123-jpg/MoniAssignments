package week6.marathon3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccount extends BaseClass {
	@BeforeTest
	public void dataVal() {
		FileName="SalesCreateacc";
	}
@Test(dataProvider="sendData")
    public  void runcreateAcc(String accountName) {
	
        
	    WebElement accTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
	    driver.executeScript("arguments[0].click()", accTab);
		driver.findElement(By.xpath("//a[@title='New']")).click();
       // String accountName = "Gokul";//excel
        driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountName);
        WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
        driver.executeScript("arguments[0].click()",ownershipDD);
        driver.findElement(By.xpath("(//label[text()='Ownership']/following::lightning-base-combobox-item)[2]")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String toastMessage = driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text[text()='Gokul']")).getText();
        System.out.println(toastMessage);
        Assert.assertTrue(toastMessage.toLowerCase().contains(accountName.toLowerCase()),"Verify the Account name");
       
    }

}
