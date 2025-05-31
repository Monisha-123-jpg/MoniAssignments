package week5.marathon2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliqTc {

	public static void main(String[] args) throws InterruptedException {
	   ChromeOptions option = new ChromeOptions();
	   option.addArguments("--disable-notifications");
	   ChromeDriver driver= new ChromeDriver(option);
	   driver.get("https://www.tatacliq.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   WebElement brandIcon = driver.findElement(By.xpath("//div[text()='Brands']"));
	   Actions action1= new Actions (driver);
	   action1.moveToElement(brandIcon).perform();
	   WebElement watchNAcc = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryDetailsValue'])[4]"));
	   action1.moveToElement(watchNAcc).perform();
	 
	   //click 1 st brand under featured brand
      driver.findElement(By.xpath("((//div[@class='DesktopHeader__featureBrands'])/div)[2]")).click();
      Thread.sleep(5000);
      //select sort by new arrival
      WebElement sortBy = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
      Select select = new Select(sortBy);
      select.selectByVisibleText("New Arrivals");
      //click men under categories
      driver.findElement(By.xpath("(//div[text()='Men'])[1]")).click();
      Thread.sleep(2000);
      List<WebElement> priceOfWatch = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
    
      for(WebElement allWatchPrice :priceOfWatch) {
    	  
    	  String priceOfW= allWatchPrice.getText();
    	System.out.println(priceOfW);
    	
      }
      String parentWin = driver.getWindowHandle();
      Thread.sleep(3000);
      WebElement element1 = driver.findElement(By.xpath("(//div[@class='ProductModule__imageAndDescriptionWrapper'])[1]"));
      driver.executeScript("arguments[0].click()", element1);
      
      //get window handles
      
      Set<String> windowHandles = driver.getWindowHandles();
      
      //convert set to list to use get method
      List<String> win = new ArrayList<String>(windowHandles);
                 
      //switch to child window
      driver.switchTo().window(win.get(1));
      WebElement addToCart = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
      addToCart.click();
      
    //geeting bag count
      action1.moveToElement(addToCart).perform();
      String bagCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
       
      System.out.println("no of products in add to bag is--"+bagCount);
      
      //click add to bag icon
      driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
      
      //get price of product in left side
      String price1= driver.findElement(By.xpath("//div[@class='CartItemForDesktop__productInformationHolder']/div[2]")).getText();
      System.out.println("price 1 is--"+price1);
      
      //get price during check out
   
      String price2= driver.findElement(By.xpath("//div[@class='DesktopCheckout__price']")).getText();
      System.out.println("price 2 is--"+price2);
      double double1 = Double.parseDouble(price1.replaceAll("[^\\d.]", ""));
      double double2 = Double.parseDouble(price2.replaceAll("[^\\d.]", ""));
      System.out.println("price 1 in double--"+double1);
      System.out.println("price 2 in double--"+double2);
      if(double1==double2) {
    	  System.out.println("prices matches");
      }
      else {
    	  System.out.println("prices not matched");
      }
   //   driver.switchTo().window(parentWin);
      driver.quit();
	}


	}
	

