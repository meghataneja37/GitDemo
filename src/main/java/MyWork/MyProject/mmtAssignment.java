package MyWork.MyProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mmtAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title*='notification-frame']")));
		driver.findElement(By.xpath("//a[@class='close']")).click();
		
		driver.switchTo().defaultContent();
		
		
		driver.findElement(By.xpath("//*[text()='Round Trip']")).click();
		
		driver.findElement(By.id("fromCity")).sendKeys("Delhi");
		Thread.sleep(3000);	
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		
		driver.findElement(By.id("toCity")).sendKeys("Kolkata");
		Thread.sleep(3000);
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Wed Jun 12 2024']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Fri Jun 14 2024']")).click();
		
		driver.findElement(By.xpath("//*[text()='Search']")).click();
		Thread.sleep(3000);
		
		String errorMsg = driver.findElement(By.xpath("//p[@class='error-title']")).getText();
		
		
		//*driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")).click();
		
		//String fare = driver.findElement(By.xpath("//p[@class='blackText fontSize16 blackFont'][1]")).getText();
		
		System.out.println(errorMsg);
		driver.quit();
		
		
		
		
		
		
	}

}
