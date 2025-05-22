package week3.marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonTestCase {

	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys",Keys.ENTER);
		//to check count of numbers as result for bags for boys
		String textOfCounts = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();
		
		System.out.println("total result for bag boys "+textOfCounts);
		
		//TO CLICK 1 ST 2 BRANDS
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();
		System.out.println("clicked 1 st brand");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//to click 2 nd brand
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[5]")).click();
		System.out.println("clicked second brand");
		
		//to click sort by
		driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]")).click();
		System.out.println("sort clicked");
		
		//To click newest arrival
		driver.findElement(By.xpath("//a[contains(text(),'Newest Arrivals')]")).click();
		System.out.println("new arrival clicked");
		
		// to get text of name n price of brand
		String textOfName = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base']")).getText();
		System.out.println("1");
		System.out.println("name of brand--"+textOfName);
		
		Thread.sleep(5000);
		String textOfPrice = driver.findElement(By.xpath("(//div[@data-cy='title-recipe']/following-sibling::div)[1]")).getText();
		System.out.println("price of bag--"+textOfPrice);
		driver.quit();
		
		
		

	}

}
