package week5.day2;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class SnapDeal {

	
	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement menFashiont = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
        Actions act = new Actions(driver);
        act.moveToElement(menFashiont).perform();
        driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
        
        //get count
        String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
        System.out.println("sport show count--"+count);
        //click trainnig shoe
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
        
        //click sort by and low to high
        driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
        driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
        //get all prices and sort
        Thread.sleep(5000);
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
        List<Integer>  allPrice=new ArrayList<>();
       
        for(WebElement allPr:prices) {
        	String textOfPrices = allPr.getText();
        	String replacedPrice= textOfPrices.replaceAll("[^0-9]", "");
        	int int1 = Integer.parseInt(replacedPrice);
        	allPrice.add(int1);
        	
        }
        System.out.println(allPrice);
       List<Integer>  allPricesorted=new ArrayList<>(allPrice);
        
        Collections.sort(allPricesorted);
        System.out.println("sorted list are--"+allPricesorted);
        if(allPrice.equals(allPricesorted)) {
        	System.out.println("all prices are in sorted order");
        }
        else
        {
        	System.out.println("not in sorted order");
        }
        
        
        //send values to from price and to price
        driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
        driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("300");
      
        driver.findElement(By.xpath("//input[@name='toVal']")).clear();
        driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("800");
        //click go btn
        driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
     
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      WebElement whiteAndBlue = driver.findElement(By.xpath("//span[@class='filter-color-tile White&Blue ']"));
      driver.executeScript("arguments[0].click()", whiteAndBlue);
        
        //verify filters
        List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filters-top-selected']//div[1]"));
        for(WebElement allFilter :filters) {
        	String textOfFilters= allFilter.getText();
        	   if (!textOfFilters.isEmpty()) {
        	        System.out.println("Filter name === " +textOfFilters);
        	    }
        	
        }
        
        WebElement firstImg = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
        Actions act1 = new Actions(driver);
        act1.moveToElement(firstImg).perform();
    
        driver.findElement(By.xpath("(//div[contains(@class,'quick-view')])[1]")).click();
     
        Thread.sleep(3000);
        String priceInPopup = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
        System.out.println("price after quick view--"+priceInPopup);
        
        String disInPopup = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
        System.out.println("price after quick view--"+disInPopup);
        
        
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File pic = new File("./snap/snapdeal.png");
		FileUtils.copyFile(screenshotAs, pic);
		
		driver.quit();
		
	}
	

}

