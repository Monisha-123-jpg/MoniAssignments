package week5.day2;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BigBasket {

	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("(//span[contains(@class,'CategoryMenu')])[3]")).click();
        WebElement foodAndOil = driver.findElement(By.xpath("(//span[text()='Category'])[2]/following::a[text()='Foodgrains, Oil & Masala'][1]"));
        Actions act = new Actions(driver);
        Thread.sleep(2000);
        act.moveToElement(foodAndOil).perform();
        driver.findElement(By.xpath("(//a[text()='Rice & Rice Products'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//li[contains(@class,'FilterByCategory')])[2]//a[text()='Boiled & Steam Rice']")).click();
        WebElement bbRoyal = driver.findElement(By.xpath("//input[@id='i-bbRoyal']"));
      
        //using java script executor to scroll and click
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", bbRoyal);
        js.executeScript("arguments[0].click();", bbRoyal);
           
        
       Thread.sleep(3000);
        //click tamil ponniboiled rice
        WebElement tamilPonniRice = driver.findElement(By.xpath("//div[contains(@class,'relative border')]//following::h3[text()='Tamil Ponni Boiled Rice']"));
       // js.executeScript("arguments[0].scrollIntoView(true);", tamilPonniRice);
        js.executeScript("arguments[0].click();",tamilPonniRice);
        
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> win = new ArrayList<>(windowHandles);
        driver.switchTo().window(win.get(1));
        
        Thread.sleep(5000);
       WebElement kg = driver.findElement(By.xpath("//div[contains(@class,'flex justify')]//following::span[text()='5 kg']"));
        driver.executeScript("arguments[0].click();", kg);
        
        String titleOfRice = driver.findElement(By.xpath("//section[contains(@class,'Description___Styled')]//h1[contains(text(),'5 kg')]")).getText();
        System.out.println("rice title is---"+titleOfRice);
        
        if(titleOfRice.contains("5 kg")) {
        	System.out.println("rice 5kg is selected");
        }
        else {
        	System.out.println("correct rice is not selected");
        }
        String priceOfRice = driver.findElement(By.xpath("//section[contains(@class,'Description___Styled')]//table/tr/td[1]")).getText();
        System.out.println(priceOfRice);
        
        driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
        String successMsg = driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']")).getText();
        System.out.println("printing succ msg----"+successMsg);
        Assert.assertEquals(successMsg, "An item has been added to your basket successfully","msg mismatch");
        
        
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File pic = new File("./snap/bb.png");
		FileUtils.copyFile(screenshotAs, pic);
		
		driver.close();
		driver.switchTo().window(win.get(0)).quit();
	}

}
