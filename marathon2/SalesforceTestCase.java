package week5.marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class SalesforceTestCase {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.salesforce.com/in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// TODO Auto-generated method stub
		
		Shadow shadow = new Shadow(driver);
		shadow.findElementByXPath("//span[text()='Products']").click();
		shadow.setImplicitWait(5);
		WebElement seelAllPricing= shadow.findElementByXPath("//a[text()='See all product pricing']");
		driver.executeScript("arguments[0].scrollIntoView(true);",seelAllPricing);
		seelAllPricing.click();
		driver.findElement(By.xpath("(//a[contains(@href,'agentforce')])[1]")).click();
		String title = driver.getTitle();
		System.out.println("url title is--"+title);
		driver.quit();
		

	}

}
