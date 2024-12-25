package MyWork.MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignmentZFold {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("Samsung Galaxy Z Fold 5");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@title='Search']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Flipkart']")).click();
		Thread.sleep(6000);
		driver.quit();
	}

}
