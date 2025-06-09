package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class AjioTc {

	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags",Keys.ENTER);
		Thread.sleep(3000);
	    WebElement menBox = driver.findElement(By.xpath("//label[@for='Men']"));
	    driver.executeScript("arguments[0].click()", menBox);
	    Thread.sleep(3000);
	    WebElement fashionBagBox = driver.findElement(By.xpath("//label[contains(@class,'Fashion Bags')]"));
	    driver.executeScript("arguments[0].click()", fashionBagBox);
	    Thread.sleep(3000);
	    String itemFound= driver.findElement(By.xpath("//div[contains(@aria-label,'Items Found')]")).getText();
	    System.out.println("count of items found---"+itemFound);
	    List<WebElement> brand = driver.findElements(By.className("brand"));
	    
	    List<String>  brandName= new ArrayList<String>();
         for(WebElement brandN:brand) {
        	 String textOfBrand = brandN.getText();
        	 brandName.add(textOfBrand);
        	 
         }
         System.out.println(brandName);
       
         List<WebElement> nameL = driver.findElements(By.xpath("//div[@class='nameCls']"));
 	    
 	    List<String>  nameList= new ArrayList<String>();
          for(WebElement nL:nameL) {
         	 String nameOfList = nL.getText();
         	 nameList.add(nameOfList);
         	 
          }
	}

}
