package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://finance.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		WebElement moreTab = driver.findElement(By.xpath("//span[text()='More']"));
		Actions action = new Actions(driver);
		action.moveToElement(moreTab).perform();
		//clicking crypto under more tab
		driver.findElement(By.xpath("(//a[text()='Crypto '])[3]")).click();
		
		List<String> entireCryptoName=new ArrayList<String>();
		List<WebElement> nameOfCrypto = driver.findElements(By.xpath("//div[text()='Name']//following::tbody/tr/td[2]"));
		for(WebElement allNameCrypto: nameOfCrypto) {
			String textOfNames = allNameCrypto.getText();
			entireCryptoName.add(textOfNames);
		}
		System.out.println("crypto names in table is---"+entireCryptoName);
		
		

	}

}
