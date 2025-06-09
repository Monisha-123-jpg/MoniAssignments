package week6.marathon3;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteAccount  extends BaseClass{
	@BeforeTest
	public void dataVal() {
		FileName="SalesCreateacc";
	}

@Test(dataProvider="sendData")
   public  void runDeleteAcc(String accountname) throws Exception {
	
        
        WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
        driver.executeScript("arguments[0].click()",accountsTab);

        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accountname+ Keys.ENTER);//excel
        Thread.sleep(2000);
        String noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        String[] s = noOfItems.split(" ");
        int countBeforeDelete = Integer.parseInt(s[0]);
        System.out.println("1...."+countBeforeDelete);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]//a[@role='button']")).click();//table/tbody/tr/td[6]
        driver.findElement(By.xpath("(//ul[@role='presentation'])[3]//a[@title='Delete']")).click();
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        Thread.sleep(2000);
        String noOfItems1 = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        s = noOfItems1.split(" ");
        int countAfterDelete = Integer.parseInt(s[0]);

        Assert.assertTrue(countBeforeDelete==(countAfterDelete+1),"Verify the account has deleted");

    }


}
