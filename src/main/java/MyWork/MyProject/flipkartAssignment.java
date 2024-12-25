package MyWork.MyProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkartAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Samsung Galaxy Z Fold 5");

		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy Z Fold5 (Phantom Black, 256 GB)']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[placeholder='Enter Delivery Pincode']")).sendKeys("201014");
		driver.findElement(By.cssSelector("input[placeholder='Enter Delivery Pincode']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		String DeliveryDate = driver.findElement(By.xpath("//div[text()='Faster delivery by']")).getText();
		System.out.println(DeliveryDate);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='Add 3 Items to Cart']")).click();
		
		Thread.sleep(3000);
		
		String Amount = driver.findElement(By.xpath("//div[text()='Total Amount']/parent::div/following-sibling::div[@class='_1Y9Lgu']//div/span")).getText();
		System.out.println(Amount);
		
		
	}

}
