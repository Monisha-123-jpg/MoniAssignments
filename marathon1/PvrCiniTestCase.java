package week3.marathon1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class PvrCiniTestCase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[text()= 'Cinema']")).click();
		driver.findElement(By.xpath("//div[@id='cinema']")).click();
		
		
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item']/span)[1]")).click();
		//click select date
		//driver.findElement(By.xpath("//span[text()='Select Date']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Tomorrow')]")).click();
		//selct muvi
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[1]")).click();
		//select timing
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@role='listbox']//span)[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Book'])[4]")).click();
		//click accept
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		//book available seat
		driver.findElement(By.xpath("(//span[contains(@class,'seat-current')])[1]")).click();
		
		//click proceed
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//print seat info
		
		String textOfSeatInfo = driver.findElement(By.xpath("//div[@class='seat-info']")).getText();
		System.out.println("seat info--"+textOfSeatInfo);
	    
		//totl price
		String textOfGrandTot = driver.findElement(By.xpath("(//div[@class='seat-bottom-btn']//div)[1]")).getText();
		System.out.println("total info--"+textOfGrandTot);
		
		//click continue
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(5000);
		
		//click close
		
	
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		
		//get title
		String title = driver.getTitle();
		System.out.println("title of page--"+title);
		
		driver.quit();
		
	
	}		
		
	}


