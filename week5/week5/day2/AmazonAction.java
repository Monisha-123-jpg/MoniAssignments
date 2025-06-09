package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.utils.FileUtil;

public class AmazonAction {

	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//enter oneplus
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("price details of 1 st product--"+price);
		
		//get rating of 1 st product
		String ratings = driver.findElement(By.xpath("(//div[@class='a-row a-size-small'])[1]")).getText();
		System.out.println("rating is---"+ratings);
		
	
		
		driver.findElement(By.xpath("(//h2[contains(@class,'a-size-medium a-spacing-none')])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindowHandles=new ArrayList<String>(windowHandles);
		driver.switchTo().window(allWindowHandles.get(1));
		
		//to take screenshot of product displayed
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File pic = new File("./snap/aa.png");
		FileUtils.copyFile(screenshotAs, pic);
		
		//add to cart
		driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
		
		String cartTot = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("cart total is--"+cartTot);
		String newCartTot= cartTot.replaceAll("[^0-9]", "");
		System.out.println("new changed cart tot ----"+newCartTot);
		
		
		if(newCartTot.equals(price)) {
			System.out.println("price matches");
		}
			else 
		{
				System.out.println("price not matching");
			}
		driver.quit();
		}
	
		
	}


